package mlick.lxxlibrary.custom.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;


public class RoundImageView extends ImageView {

    public RoundImageView(Context context) {
        super(context);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        Bitmap b = null;
        if (drawable instanceof BitmapDrawable) {
            b = ((BitmapDrawable) drawable).getBitmap();
//        } else if (drawable instanceof AsyncDrawable) {//�ж��Ƿ��ǽ������������첽���ض����еĴ������
        } else {
            b = Bitmap
                    .createBitmap(
                            getWidth(),
                            getHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas1 = new Canvas(b);
            // canvas.setBitmap(bitmap);
            drawable.setBounds(0, 0, getWidth(), getHeight());
            drawable.draw(canvas1);
        }
        if (null == b) {
            return;
        }
        /**
         * �˴�Ӧ�ô����Ƿ����ڴ���������
         */
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);
        if (bitmap == null) {
            return;
        }
        int w = getWidth(), h = getHeight();
        Bitmap roundBitmap = getCroppedBitmap(bitmap, w);
        canvas.drawBitmap(roundBitmap, 0, 0, null);
    }

    public static Bitmap getCroppedBitmap(Bitmap bmp, int radius) {
        Bitmap sbmp;
        if (bmp.getWidth() != radius || bmp.getHeight() != radius) {
            sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
        } else {
            sbmp = bmp;
        }
        Bitmap output = Bitmap.createBitmap(sbmp.getWidth(), sbmp.getHeight(),
                Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();

//
//        paint.setColor(Color.WHITE);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        paint.setStyle(Paint.Style.STROKE); // ���ÿ���
//        paint.setStrokeWidth(2); // ����Բ���Ŀ��
//        paint.setAntiAlias(true); // �������
//        canvas.drawCircle(sbmp.getWidth() / 2 + 0.9f,
//                sbmp.getHeight() / 2 + 0.9f, sbmp.getWidth() / 2 + 0.2f, paint); // ����Բ��
        
        final int color = 0xffa19774;
      
        final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
       
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawARGB(0, 0, 0, 0);
//        paint.setColor(Color.parseColor("#FFFFFF"));
        canvas.drawCircle(sbmp.getWidth() / 2 + 0.7f,
                sbmp.getHeight() / 2 + 0.7f, sbmp.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);
        
        
        return output;
    }

}
