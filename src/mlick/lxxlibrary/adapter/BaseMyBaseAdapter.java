package mlick.lxxlibrary.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Adapter ���ȷ�װ ����Ϊlist����
 * 
 * @author lxx
 * @date 2014-9-4
 * @time ����2:19:37
 */
public abstract class BaseMyBaseAdapter extends BaseAdapter {

	public List<?> baseData; // ��װ������
	public Context baseContext; // ��ȡ����context
	public LayoutInflater baseInf; // ��ȡ����layoutinflater

	public BaseMyBaseAdapter(Context context) {
		this.baseContext = context;
		baseInf = LayoutInflater.from(context);
	}

	public void setmData(List<?> baseData) {
		this.baseData = baseData;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		if (baseData != null) {
			return baseData.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		if (baseData != null) {
			return baseData.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		if (baseData != null) {
			return baseData.get(position).hashCode();
		}
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return this.getMyView(position, convertView, parent);
	}

	public abstract View getMyView(int position, View convertView,
			ViewGroup parent);

}
