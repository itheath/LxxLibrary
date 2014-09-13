package mlick.lxxlibrary.dialog;

import android.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * ��������Զ����ֵ�dialog
 * 
 * @author lxx
 * @date 2014-9-4
 * @time ����3:53:39
 */
public class MyCusomLayoutDialog {
	/**
	 * �Զ����Dialog���
	 * 
	 * ��Ҫ���ⲿ����һ�� AlertDialog �������� final AlertDialog dlg =
	 * new AlertDialog.Builder(this).create();
	 * �����ļ����Բο�layoutĿ¼�µ�dialog_call_telephone.xml����ļ�
	 * 
	 * @param context
	 *            ����dialog��context
	 * 
	 * @param RLayoutId
	 *            �Զ���Ĳ���
	 * 
	 * @param ROkId
	 *            ȷ����ť��id
	 * 
	 * @param RCancelId
	 *            ȡ����ť��id
	 * 
	 * @param okListener
	 *            ȷ����ť�ļ����¼�
	 * 
	 * @param cancleListener
	 *            ȡ����ť�ļ����¼�
	 */
	public static void showExitGameAlert(AlertDialog dlg, int RLayoutId,
			int ROkId, int RCancelId, View.OnClickListener okListener,
			View.OnClickListener cancleListener, String content, int RTextId) {
		dlg.show(); // �Ƚ��е��ã��ٽ�������

		Window window = dlg.getWindow();// *** ��Ҫ����������ʵ������Ч����.
		// ���ô��ڵ�����ҳ��,shrew_exit_dialog.xml�ļ��ж���view����
		window.setContentView(RLayoutId);

		// Ϊȷ�ϰ�ť����¼�
		View ok = window.findViewById(ROkId);
		ok.setOnClickListener(okListener);

		// Ϊȡ����ť����¼�
		View cancel = window.findViewById(RCancelId);
		cancel.setOnClickListener(cancleListener);

		TextView text = (TextView) window.findViewById(RTextId);
		text.setText(content);
	}

	
	
}
