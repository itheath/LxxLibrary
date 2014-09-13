package mlick.lxxlibrary.fragment;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * �̳��Ե�������BaseFragment�Ļ���
 * @category ��ӵ��������Onclick�¼�
 * @author lxx
 * @date 2014-9-4
 * @time ����3:03:30
 */
public abstract class BaseFragment1 extends BaseFragment {
	// �����ļ��еļ����¼�
	public OnClickListener baseListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			setMyOnClickListen(v);
		}
	};

	// ���ò����ļ��ļ���
	public abstract void setMyOnClickListen(View v);

}
