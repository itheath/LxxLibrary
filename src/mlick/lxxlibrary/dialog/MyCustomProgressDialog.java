package mlick.lxxlibrary.dialog;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * �Զ���Ľ�����
 * 
 * @author lxx
 * @date 2014-9-4
 * @time ����5:13:30
 */
public class MyCustomProgressDialog {

	/**
	 * �Զ����ProgressDialog�Ի�����еĴ���
	 */
	public static ProgressDialog getCustomProgressDialog(Context context,
			String content, boolean canceledOnTouchOutside) {
		ProgressDialog progressDialog = new ProgressDialog(context);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setMessage(content);
		progressDialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
		return progressDialog;
	}
}
