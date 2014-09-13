package mlick.lxxlibrary.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * ��װ�Զ����Activity
 * 
 * @author lxx
 * @date 2014-9-4
 * @time ����3:25:16
 */
public abstract class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutResID());
		ViewInJect(this);
		initValue();
		initView();
	}

	// �õ������ļ���id
	public abstract int getLayoutResID();

	// �Ը�Activity���а󶨣����Ը����û�����Ҫ����
	// ��Afinal�����������а󶨵� FinalActivity.initInjectedView(baseActivity);
	// ��xUtils�����������а󶨵� ViewUtils.inject(baseActivity);
	public abstract void ViewInJect(BaseActivity baseActivity);

	// ��ʼ������
	public abstract void initValue();

	// ���»���ͼ
	public abstract void initView();

	// // ��ʼ�����¼�
	// public abstract void setViewOnClickListen();

}
