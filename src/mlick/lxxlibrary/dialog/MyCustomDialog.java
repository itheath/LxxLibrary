package mlick.lxxlibrary.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

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

    /**
     * �Զ����Dialog���
     * 
     * ��Ҫ���ⲿ����һ�� AlertDialog �������� final AlertDialog dlg = new
     * AlertDialog.Builder(this).create();
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
