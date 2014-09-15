package mlick.lxxlibrary.system;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class GetAllApplication {

	/**
	 * ���ݰ��������ж��Ƿ���ڸ�Ӧ��
	 * 
	 * @param context
	 * @param packageName
	 * @return �ж�pName���Ƿ���Ŀ�����İ�������TRUE��û��FALSE
	 */
	public static boolean isAvilible(Context context, String packageName) {
		final PackageManager packageManager = context.getPackageManager();// ��ȡpackagemanager
		List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// ��ȡ�����Ѱ�װ����İ���Ϣ
		List<String> pName = new ArrayList<String>();// ���ڴ洢�����Ѱ�װ����İ���
		// ��pinfo�н���������һȡ����ѹ��pName list��
		if (pinfo != null) {
			for (int i = 0; i < pinfo.size(); i++) {
				String pn = pinfo.get(i).packageName;
				pName.add(pn);
			}
		}
		return pName.contains(packageName);// �ж�pName���Ƿ���Ŀ�����İ�������TRUE��û��FALSE
	}

	
	
}
