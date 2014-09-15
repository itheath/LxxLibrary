package mlick.lxxlibrary.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.R.integer;

/**
 * String�ַ����Ĺ�����
 * 
 * @author lxx
 * @date 2014-9-15
 * @time ����2:39:35
 */
public class StrUtil {

	/**
	 * �ж�str�Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return true��ʾΪ�� || false ��ʾ��Ϊ��
	 */
	public static boolean isEmpty(String str) {
		if (str == null)
			return true;

		if (str.equals("")) {
			return true;
		}

		if (str.length() < 1)
			return true;

		return false;
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return true��ʾ��Ϊ�� || false ��ʾΪ��
	 */
	public static boolean isNotEmpty(String str) {
		if (str == null)
			return false;
		if (str.equals(""))
			return false;
		if (str.length() < 1)
			return false;

		return true;
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�� || ������������ִ�Сд
	 * 
	 * @param str
	 * @return true��ʾΪ null�ַ��� || false ��ʾ��Ϊnull�ַ���
	 */
	public static boolean isNull(String str) {

		if (str.equalsIgnoreCase(str)) {
			return true;
		}

		return false;
	}

	/**
	 * String����תΪint����
	 * 
	 * @param str
	 * @return
	 */
	public static int Str2Int(String str) {
		return Integer.parseInt(str);
	}

	/**
	 * int����תΪString����
	 * 
	 * @param i
	 * @return
	 */
	public static String Int2Str(int i) {
		return String.valueOf(i);
	}

	/**
	 * URLEnCode ת�� UTF-8
	 * 
	 * @param res
	 * @return �쳣����null
	 */
	public static String URLEncode2UTF8(String res) {
		try {
			return URLEncoder.encode(res, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
