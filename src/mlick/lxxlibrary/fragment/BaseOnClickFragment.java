package mlick.lxxlibrary.fragment;

import android.view.View;

/**
 * �̳��Ե�������BaseFragment�Ļ���
 * 
 * @category ��ӳ������Onclick�¼��ĺ���
 * @author lxx
 * @date 2014-9-4
 * @time ����3:03:30
 */
public abstract class BaseOnClickFragment extends BaseFragment implements
        android.view.View.OnClickListener {

    @Override
    public void onClick(View v) {
        setMyOnClickListen(v);
    }

    // ���ò����ļ��ļ���
    public abstract void setMyOnClickListen(View v);
}
