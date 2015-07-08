package mlick.lxxlibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * SharedPreferences ������
 * 
 * @author lxx
 * @date 2014-9-15
 * @time ����2:30:39
 */
public class SPhelper {

//	private static SPhelper sPhelper; // ��ʱû��ʹ�õ���ģʽ
//
//	public static SPhelper getInstance() {
//		if (sPhelper == null) {
//			sPhelper = new SPhelper();
//		}
//		return sPhelper;
//	}

	private static SharedPreferences sp;
	private static String SPNAME = "lxxsp"; // ȱʡֵ

    private static void initial(Context mContext, String fileName) {
		sp = mContext.getSharedPreferences(fileName, 0);
	}

	/**
	 * Ĭ�Ϸ��õ��ļ�Ϊlxxsp
	 * 
	 * @param mContext
	 * @param key
	 * @param value
	 */
	public static void save(Context mContext, String key, Object value) {
		initial(mContext, SPNAME);
		if (value instanceof String) {
			sp.edit().putString(key, (String) value).commit();
		} else if (value instanceof Boolean) {
			sp.edit().putBoolean(key, (Boolean) value).commit();
		} else if (value instanceof Integer) {
			sp.edit().putInt(key, (Integer) value).commit();
		} else if (value instanceof Float) {
			sp.edit().putFloat(key, (Float) value).commit();
		} else if (value instanceof Long) {
			sp.edit().putLong(key, (Long) value).commit();
		}
	}

	/**
	 * �Զ����ļ�
	 * 
	 * @param mContext
	 * @param fileName
	 * @param key
	 * @param value
	 */
	public static void save(Context mContext, String fileName, String key,
			Object value) {
		initial(mContext, fileName);
		if (value instanceof String) {
			sp.edit().putString(key, (String) value).commit();
		} else if (value instanceof Boolean) {
			sp.edit().putBoolean(key, (Boolean) value).commit();
		} else if (value instanceof Integer) {
			sp.edit().putInt(key, (Integer) value).commit();
		} else if (value instanceof Float) {
			sp.edit().putFloat(key, (Float) value).commit();
		} else if (value instanceof Long) {
			sp.edit().putLong(key, (Long) value).commit();
		}
	}

	/**
	 * ��ȡĬ�ϵ��ļ��µ�ֵ ����Ϊboolean��
	 * 
	 * @param mContext
	 * @param key
	 * @return
	 */
	public static Boolean getBoolean(Context mContext, String key) {
		initial(mContext, SPNAME);
		try {
			return sp.getBoolean(key, false);
		} catch (Exception e) {
			return false;
		}
	}

	public static Boolean getBoolean(Context mContext, String fileName,
			String key) {
		initial(mContext, fileName);
		try {
			return sp.getBoolean(key, false);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * ��ȡstring���͵�ֵ
	 * 
	 * @param mContext
	 * @param key
	 * @return
	 */
	public static String getString(Context mContext, String key) {
		initial(mContext, SPNAME);
		return sp.getString(key, "");
	}

	public static String getString(Context mContext, String fileName, String key) {
		initial(mContext, fileName);
		return sp.getString(key, "");
	}

	/**
	 * ��ȡĬ�ϵ�int���͵Ĵ洢��ֵ
	 * 
	 * @param mContext
	 * @param key
	 * @return
	 */
	public static int getInteger(Context mContext, String key) {
		initial(mContext, SPNAME);
		return sp.getInt(key, 0);
	}

	public static int getInteger(Context mContext, String fileName, String key) {
		initial(mContext, SPNAME);
		return sp.getInt(key, 0);
	}

	/**
	 * ��ȡĬ�ϵ�float���͵�ֵ
	 * 
	 * @param mContext
	 * @param key
	 * @return
	 */
	public static Float getFloat(Context mContext, String key) {
		initial(mContext, SPNAME);
		return sp.getFloat(key, 0);
	}

	public static Float getFloat(Context mContext, String fileName, String key) {
		initial(mContext, SPNAME);
		return sp.getFloat(key, 0);
	}

	/**
	 * ��ȡĬ�ϵ�Long���͵�ֵ
	 * 
	 * @param mContext
	 * @param key
	 * @return
	 */
	public static Long getLong(Context mContext, String key) {
		initial(mContext, SPNAME);
		return sp.getLong(key, 0);
	}

	public static Long getLong(Context mContext, String fileName, String key) {
		initial(mContext, SPNAME);
		return sp.getLong(key, 0);
	}

	/**
	 * ���Ĭ�ϵ��Ǹ��洢�ļ�
	 * 
	 * @param mContext
	 */
	public static void removeFile(Context mContext) {
		initial(mContext, SPNAME);
		Editor editor = sp.edit();
		editor.clear();
		editor.commit();
	}

	/**
	 * ���ָ�����ļ�Ŀ¼
	 * 
	 * @param mContext
	 * @param fileName
	 */
	public static void removeFile(Context mContext, String fileName) {
		initial(mContext, fileName);
		Editor editor = sp.edit();
		editor.clear();
		editor.commit();
	}

}