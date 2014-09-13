package mlick.lxxlibrary.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * �Զ����Fragment����
 * 
 * @category ������Ҫ��������µĹ��ܣ����Խ��м̳и���ȥʵ��
 * @author lxx
 * @date 2014-9-4
 * @time ����2:23:13
 */
public abstract class BaseFragment extends Fragment {

	private LayoutInflater inflater;
	private View mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.inflater = inflater;
		// View view = getLayoutView(inflater, container, savedInstanceState);
		mView = inflater.inflate(getLayoutResID(), container, false); //
		// ��Ҫ���ÿ�ܰ�fragment����
		// ViewUtils.inject(this, view);
		ViewInJect(this, mView);
		initValue();
		initView();
		return mView;
	}

	// ��Activity��ʼ����ʱ��������ͼ����
	// public void onActivityCreated(Bundle savedInstanceState) {
	// super.onActivityCreated(savedInstanceState);
	// // setViewOnClickListen();
	// }

	/**
	 * ��ȡ�Ӳ�����inflater,���ڽ���ʵ������������
	 * 
	 * @return
	 */
	public LayoutInflater getBaseInflater() {
		return inflater;
	}

	// ��ȡ����Ҫ���Ӳ����ļ�
	public View getBaseView() {
		return mView;
	}

	// �õ���Ҫ���صĲ����ļ���id�������䷵��
	public abstract int getLayoutResID();

	// ���а󶨵�����У�������Ը����û�����Ҫ������ѡ��
	// ��Afinal�����������а󶨵� FinalActivity.initInjectedView(baseFragment,view);
	// ��xUtils�����������а󶨵� ViewUtils.inject(baseFragment,view);
	public abstract void ViewInJect(Fragment baseFragment, View view);

	// ��ʼ������ֵ
	public abstract void initValue();

	// ��ʼ�������ļ�
	public abstract void initView();
}
