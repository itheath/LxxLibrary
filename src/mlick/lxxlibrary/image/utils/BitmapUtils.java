package mlick.lxxlibrary.image.utils;

import android.graphics.Bitmap;
import android.view.View;

public class BitmapUtils {

	// ��Viewת����Bitmap

	/**
	 * ��һ��View�Ķ���ת����bitmap
	 */
	public static Bitmap getViewBitmap(View v) {

		v.clearFocus();
		v.setPressed(false);

		// �ܻ�����ͷ���false
		boolean willNotCache = v.willNotCacheDrawing();
		v.setWillNotCacheDrawing(false);
		int color = v.getDrawingCacheBackgroundColor();
		v.setDrawingCacheBackgroundColor(0);
		if (color != 0) {
			v.destroyDrawingCache();
		}
		v.buildDrawingCache();
		Bitmap cacheBitmap = v.getDrawingCache();
		if (cacheBitmap == null) {
			return null;
		}
		Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);
		// Restore the view
		v.destroyDrawingCache();
		v.setWillNotCacheDrawing(willNotCache);
		v.setDrawingCacheBackgroundColor(color);
		return bitmap;
	}
}
