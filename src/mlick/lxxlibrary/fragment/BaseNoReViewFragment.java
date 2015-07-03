package mlick.lxxlibrary.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * �Զ����Fragment���� �ظ���onCreateView
 * 
 * @author lxx
 * @date 2014-9-4
 * @time ����3:11:03
 */
public abstract class BaseNoReViewFragment extends Fragment {

	private LayoutInflater inflater;

	private View mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (mView != null) {
			ViewGroup parent = (ViewGroup) mView.getParent();
			if (parent != null) {
				parent.removeView(mView);
			}
			return mView;
		}

		mView = inflater.inflate(getLayoutResID(), container, false); // ����fragment����

		this.inflater = inflater;
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

	public LayoutInflater getBaseInflater() {
		return inflater;
	}

	// ��ȡ����Ҫ���Ӳ����ļ�
	public View getBaseView() {
		return mView;
	}

	// ���а󶨵�����У�������Ը����û�����Ҫ������ѡ��
	public abstract void ViewInJect(Fragment baseFragment, View view);

	/**
	 * �õ���Ҫ���صĲ����ļ���id�������䷵��
	 * 
	 * @return Rid
	 */
	public abstract int getLayoutResID();

	// ��ʼ������ֵ
	public abstract void initValue();

	// ��ʼ�������ļ�
	public abstract void initView();

	// ���ò����ļ��ļ���
	// public abstract void setViewOnClickListen();
}
