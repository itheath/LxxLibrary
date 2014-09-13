package mlick.lxxlibrary.toast;

import android.content.Context;
import android.widget.Toast;

/**
 * ��ʾtoast������
 * 
 * @author lxx
 * @date 2014-9-4
 * @time ����5:31:34
 */
public class ToastUtils {
	/**
	 * 
	 * ���� ����ʾ
	 * 
	 * @param context
	 *            �����Ķ���
	 * @param content
	 *            ��ʾ��Ϣ
	 */
	public static void showLongToast(Context context, String content) {
		if (context != null) {
			Toast.makeText(context, content, Toast.LENGTH_LONG).show();
		}
	}

	public static void showLongToast(Context context, int content) {
		if (context != null) {
			Toast.makeText(context, context.getResources().getString(content),
					Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * ���� ����ʾ
	 * 
	 * @param context
	 *            �����Ķ���
	 * @param content
	 *            ��ʾ��Ϣ
	 */
	public static void showShortToast(Context context, String content) {
		if (context != null) {
			Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
		}
	}

	public static void showShortToast(Context context, int content) {
		if (context != null) {
			Toast.makeText(context, context.getResources().getString(content),
					Toast.LENGTH_SHORT).show();
		}
	}
}
