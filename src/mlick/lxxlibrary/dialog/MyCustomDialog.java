package mlick.lxxlibrary.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

public class MyCustomDialog {
	/**
	 * 
	 * @param context
	 * @param title
	 *            ����
	 * @param content
	 *            ��ʾ����
	 * @param confirmClick
	 *            ȷ��
	 * @param cancelClick
	 *            ȡ��
	 */
	public static void showDialog(Context context, String title,
			String content, String confirm,
			DialogInterface.OnClickListener confirmClick, String cancel,
			DialogInterface.OnClickListener cancelClick) {
		AlertDialog.Builder adb = new AlertDialog.Builder(context);
		adb.setTitle(title);
		adb.setMessage(content);
		// adb.setPositiveButton("ȷ��", confirmClick);
		// adb.setNegativeButton("ȡ��", cancelClick);
		adb.setPositiveButton(confirm, confirmClick);
		adb.setNegativeButton(cancel, cancelClick);
		adb.show();
	}

	/**
	 * ֻ��ȷ�����Ĳ���
	 * 
	 * @param context
	 * @param title
	 *            ����
	 * @param content
	 *            ��ʾ����
	 * @param confirmClick
	 *            ȷ��
	 */
	public static void showDialog2(Context context, String title,
			String content, String confirm,
			DialogInterface.OnClickListener confirmClick) {
		AlertDialog.Builder adb = new AlertDialog.Builder(context);
		adb.setTitle(title);
		adb.setMessage(content);
		// adb.setPositiveButton("ȷ��", confirmClick);
		adb.setPositiveButton(confirm, confirmClick);
		adb.show();
		// .setIcon(android.R.drawable.ic_dialog_info)
	}

	public static void showDialogList(Context context, String titleString,
			final String items[], DialogInterface.OnClickListener listener) {
		AlertDialog.Builder adb = new AlertDialog.Builder(context);
		// adb.setTitle("�б��");
		adb.setTitle(titleString);
		adb.setIcon(android.R.drawable.ic_dialog_info);
		adb.setItems(items, listener);
		adb.show();
	}

	/**
	 * ��ʾ��Ϣ �б�Ի���
	 * 
	 * @param context
	 * @param items
	 * @param editText
	 *            ����ĳ����������Ϊ���������
	 */
	public static void showDialogList2(Context context, String titleString,
			final String items[], final EditText editText) {
		AlertDialog.Builder adb = new AlertDialog.Builder(context);
		// adb.setTitle("�б��");
		adb.setTitle(titleString);
		adb.setIcon(android.R.drawable.ic_dialog_info);
		adb.setItems(items, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				editText.setText(items[which]);
			}
		});
		adb.show();
	}
	
	
	
}
