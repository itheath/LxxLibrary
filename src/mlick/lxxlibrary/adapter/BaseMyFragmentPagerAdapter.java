package mlick.lxxlibrary.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

/**
 * �ʺ����ݽ��ٵ�Fragmentʱ��PagerAdapter�ķ�װ
 * 
 * @author lxx
 * @date 2014-9-4
 * @time ����2:15:07
 */
public class BaseMyFragmentPagerAdapter extends FragmentPagerAdapter {

	private ArrayList<Fragment> mFragments;

	private FragmentManager mFragmentManager;

	// private FragmentTransaction mCurTransaction;

	public BaseMyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		this.mFragmentManager = fm;
	}

	public BaseMyFragmentPagerAdapter(FragmentManager fm,
			ArrayList<Fragment> list) {
		super(fm);
		this.mFragmentManager = fm;
		this.mFragments = list;
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "";
	}

	// @Override
	// public Object instantiateItem(ViewGroup container, int position) {
	// return getItem(position);
	// }

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	/**
	 * ��ʱ���������
	 * 
	 * @param fragments
	 */
	public void setFragments(ArrayList<Fragment> fragments) {
		if (this.mFragments != null) {
			FragmentTransaction ft = mFragmentManager.beginTransaction();
			for (Fragment f : this.mFragments) {
				ft.remove(f);
			}
			ft.commit();
			ft = null;
			mFragmentManager.executePendingTransactions();
		}
		this.mFragments = fragments;
		notifyDataSetChanged();
	}
}
