package mlick.lxxlibrary.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * ���ӵ���¼�
 * 
 * @author lxx
 * @date 2014-9-15
 * @time ����1:47:25
 */
public abstract class BaseFragmentActivity1 extends BaseFragmentActivity {

	// ���ò����ļ��ļ���
	public abstract void setViewOnClickListen();

	// ��ӵ�setViewOnclickListen
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setViewOnClickListen();
	}

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
