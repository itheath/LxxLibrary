package mlick.lxxlibrary.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class BaseFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutResID());
		ViewInJect(this);
		initValue();
		initView();
	}

	public abstract int getLayoutResID();

	// ���а󶨵�����У�������Ը����û�����Ҫ������ѡ��
	// ��Afinal�����������а󶨵� FinalActivity.initInjectedView(baseActivity);
	// ��xUtils�����������а󶨵� ViewUtils.inject(baseActivity);
	public abstract void ViewInJect(BaseFragmentActivity baseFragmentActivity);

	// ��ʼ������ֵ
	public abstract void initValue();

	// ��ʼ�������ļ�
	public abstract void initView();

}
