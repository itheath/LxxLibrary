package mlick.lxxlibrary.image.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class BitmapConvert {

	/**
	 * ѹ������ͼƬȻ��浽һ���µ��ļ��� ��󷵻��µ�ͼƬ��·��
	 * 
	 * @param dst
	 * @param width
	 * @param height
	 * @param newFile
	 * @param MaxKB
	 *            ���ò�Ҫ������ͼƬ�Ĵ�С
	 * @return �����µ�ͼƬ��·��,��������쳣����null
	 */
	public static String compressImageToFile(File newFile, String dst,
			int width, int height, int MaxKB) {

		Bitmap image = getBitmapFromFile(dst, width, height);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// ����ѹ������������100��ʾ��ѹ������ѹ��������ݴ�ŵ�baos��
		int options = 100;

		while (baos.toByteArray().length / 1024 > MaxKB) { // ѭ���ж����ѹ����ͼƬ�Ƿ����1024kb,���ڼ���ѹ��
			baos.reset();// ����baos�����baos
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);// ����ѹ��options%����ѹ��������ݴ�ŵ�baos��
			options -= 10;// ÿ�ζ�����10
		}

		byte[] bitmapdata = baos.toByteArray();

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(newFile);
			fos.write(bitmapdata);
			fos.close();
			baos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return newFile.getPath();
	}

	/**
	 * byte�ֽ�ת��bitmap
	 * 
	 * @param b
	 * @return
	 */
	public static Bitmap Bytes2Bimap(byte[] b) {
		if (b == null) {
			return null;
		}

		if (b.length != 0) {
			return BitmapFactory.decodeByteArray(b, 0, b.length);
		} else {
			return null;
		}
	}

	/**
	 * ������Ƭ���������е�ѹ������bitmap
	 * 
	 * @param image
	 * @return bitmap
	 */
	public static Bitmap compressImage(Bitmap image) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// ����ѹ������������100��ʾ��ѹ������ѹ��������ݴ�ŵ�baos��
		int options = 100;
		while (baos.toByteArray().length / 1024 > 1024) { // ѭ���ж����ѹ����ͼƬ�Ƿ����1024kb,���ڼ���ѹ��
			baos.reset();// ����baos�����baos
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);// ����ѹ��options%����ѹ��������ݴ�ŵ�baos��
			options -= 10;// ÿ�ζ�����10
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// ��ѹ���������baos��ŵ�ByteArrayInputStream��

		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// ��ByteArrayInputStream��������ͼƬ
		return bitmap;
	}

	/**
	 * �ӱ�����Դ���ļ��ж�ȡͼƬ��bitmap��
	 * 
	 * @param dst
	 *            �ļ�·��
	 * @param width
	 *            ͼƬ�Ŀ��
	 * @param height
	 *            ͼƬ�ĸ߶�
	 * @return Bitmap ����BitmapͼƬ
	 */
	public static Bitmap getBitmapFromFile(String dst, int width, int height) {
		if (null != dst && !dst.equals("")) {
			BitmapFactory.Options opts = null;
			if (width > 0 && height > 0) {
				opts = new BitmapFactory.Options(); // ����inJustDecodeBoundsΪtrue��decodeFile��������ռ䣬��ʱ����ԭʼͼƬ�ĳ��ȺͿ��
				opts.inJustDecodeBounds = true;
				BitmapFactory.decodeFile(dst, opts);
				// ����ͼƬ���ű���
				final int minSideLength = Math.min(width, height);
				opts.inSampleSize = computeSampleSize(opts, minSideLength,
						width * height); // ����һ��Ҫ�������û�false����Ϊ֮ǰ���ǽ������ó���true
				opts.inJustDecodeBounds = false;
				opts.inInputShareable = true;
				opts.inPurgeable = true;
			}
			try {
				return BitmapFactory.decodeFile(dst, opts);
			} catch (OutOfMemoryError e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	/**
	 * �����࣬����ͼƬ�Ĵ�С����ֹ�ڴ�����
	 * 
	 * @param options
	 * @param minSideLength
	 * @param maxNumOfPixels
	 * @return
	 */
	public static int computeSampleSize(BitmapFactory.Options options,
			int minSideLength, int maxNumOfPixels) {
		int initialSize = computeInitialSampleSize(options, minSideLength,
				maxNumOfPixels);

		int roundedSize;
		if (initialSize <= 8) {
			roundedSize = 1;
			while (roundedSize < initialSize) {
				roundedSize <<= 1;
			}
		} else {
			roundedSize = (initialSize + 7) / 8 * 8;
		}

		return roundedSize;
	}

	/**
	 * �����࣬����ͼƬ�Ĵ�С����ֹ�ڴ�����
	 * 
	 * @param options
	 * @param minSideLength
	 * @param maxNumOfPixels
	 * @return
	 */
	private static int computeInitialSampleSize(BitmapFactory.Options options,
			int minSideLength, int maxNumOfPixels) {
		double w = options.outWidth;
		double h = options.outHeight;

		int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil(Math
				.sqrt(w * h / maxNumOfPixels));
		int upperBound = (minSideLength == -1) ? 128 : (int) Math.min(
				Math.floor(w / minSideLength), Math.floor(h / minSideLength));

		if (upperBound < lowerBound) {
			// return the larger one when there is no overlapping zone.
			return lowerBound;
		}

		if ((maxNumOfPixels == -1) && (minSideLength == -1)) {
			return 1;
		} else if (minSideLength == -1) {
			return lowerBound;
		} else {
			return upperBound;
		}
	}

	/**
	 * �任ͼƬ����״֮ȥԲ��
	 * 
	 * @param image
	 * @param outerRadiusRat
	 *            ��ǵ�԰��
	 * @return Bitmap
	 */
	public static Bitmap createFramedPhoto(Bitmap image, float outerRadiusRat) {

		// ����Դ�ļ��½�һ��darwable����
		Drawable imageDrawable = new BitmapDrawable(image);

		// �½�һ���µ����ͼƬ
		Bitmap output = Bitmap.createBitmap(image.getWidth(),
				image.getHeight(), Bitmap.Config.ARGB_8888);

		Canvas canvas = new Canvas(output);

		// �½�һ������
		RectF outerRect = new RectF(0, 0, image.getWidth(), image.getHeight());

		// ����һ����ɫ��Բ�Ǿ���

		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

		paint.setColor(Color.RED);

		canvas.drawRoundRect(outerRect, outerRadiusRat, outerRadiusRat, paint);

		// ��ԴͼƬ���Ƶ����Բ�Ǿ�����
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));

		imageDrawable.setBounds(0, 0, image.getWidth(), image.getHeight());

		canvas.saveLayer(outerRect, paint, Canvas.ALL_SAVE_FLAG);

		imageDrawable.draw(canvas);

		canvas.restore();

		return output;

	}
}
