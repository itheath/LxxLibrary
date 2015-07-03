package mlick.lxxlibrary.activity;

import android.view.View;

/**
 * ���ӵ���¼�
 * 
 * @author lxx
 * @date 2014-9-15
 * @time ����1:47:25
 */
public abstract class BaseOnClickFragmentActivity extends BaseFragmentActivity
        implements android.view.View.OnClickListener {
    @Override
    public void onClick(View v) {
        setMyOnClickListen(v);
    }

    // ���ò����ļ��ļ���
    public abstract void setMyOnClickListen(View v);

}
