package mlick.lxxlibrary.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.widget.Toast;

/**
 * �ж��ֻ�����
 */
public class PhoneProperty {
	public Context context;
	private static PhoneProperty mPhoneProperty = null;

	public static PhoneProperty getInstance(Context context) {

		if (mPhoneProperty == null) {
			mPhoneProperty = new PhoneProperty(context);

		}
		return mPhoneProperty;
	}

	public PhoneProperty(Context context2) {
		this.context = context2;
	}

	private DisplayMetrics getPhoneMetrics() {
		DisplayMetrics dm = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm;
	}

	public float getPhoneDensity() {
		return getPhoneMetrics().density;
	}

	public float getPhoneScaledDensity() {
		return getPhoneMetrics().scaledDensity;
	}

	/**
	 * 
	 * @����: ��ȡ�ֻ��ֱ��ʸ߶�
	 * @����: ��ǿ
	 * @����: 2013-3-14 ����11:31:43
	 * @return int �ֻ��ֱ��ʸ߶�
	 */
	public int getPhoneHeight() {
		return getPhoneMetrics().heightPixels;
	}

	/**
	 * 
	 * @����: ��ȡ�ֻ��ֱ��ʿ��
	 * @����: ��ǿ
	 * @����: 2013-3-14 ����11:31:43
	 * @return int �ֻ��ֱ��ʿ��
	 */
	public int getPhoneWeigh() {
		return getPhoneMetrics().widthPixels;
	}

	/**
	 * ��绰 ����
	 * 
	 * @param context
	 * @param number
	 */
	public static void callUser(final Context context, final String number) {
		if (number == null || number.length() < 8) {
			Toast.makeText(context, "�绰����Ϊ�գ����߸�ʽ����ȷ", Toast.LENGTH_SHORT).show();
		} else {
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setTitle("ȷ��Ҫ����绰��");
			builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
					try {
						Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
						context.startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
						Toast.makeText(context, "��ȡ������", Toast.LENGTH_SHORT).show();
					}

				}
			});
			builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			builder.show();

		}
	}

	/**
	 * ��ȡ�汾��
	 * 
	 * @return ��ǰӦ�õİ汾��
	 */
	public String getVersion() {
		try {
			PackageManager manager = context.getPackageManager();
			PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
			String version = info.versionName;
			return version;
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	/**
	 * ��֤�ֻ���
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[^4,\\D])|(18[^4,\\D]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	/**
	 * ��֤�ֻ���ʽ >>>>> ����� mlick 2014��8��8��15:03:19
	 */
	public static boolean isMobileNO2(String mobiles) {
		/*
		 * �ƶ���134��135��136��137��138��139��150��151��157(TD)��158��159��187��188
		 * ��ͨ��130��131��132��152��155��156��185��186 ���ţ�133��153��180��189����1349��ͨ��
		 * �ܽ��������ǵ�һλ�ض�Ϊ1���ڶ�λ�ض�Ϊ3��5��8������λ�õĿ���Ϊ0-9
		 */
		String telRegex = "[1][358]\\d{9}";// "[1]"�����1λΪ����1��"[358]"����ڶ�λ����Ϊ3��5��8�е�һ����"\\d{9}"��������ǿ�����0��9�����֣���9λ��
		if (StringUtils.isEmpty(mobiles))
			return false;
		else
			return mobiles.matches(telRegex);
	}

	/**
	 * ��֤�ֻ��� 2015.02.12 by SHDB 11λ��1��ʼ
	 * 
	 * @param ��Ҫ��֤�ĵ绰����
	 * 
	 * @return (true:��ȷ /false:����ȷ)
	 */
	public static boolean isMobileNum(String mobiles) {
		// TODO
		// ��̨���� regexp = "^((1[3458]\\d)|(170))\\d{8}$"
		String telRegex = "[1]\\d{10}"; // "[1]"�����1λΪ����1��"\\d{9}"��������ǿ�����0��9�����֣���10λ��
		if (StringUtils.isEmpty(mobiles))
			return false;
		else
			return mobiles.matches(telRegex);
	}

	/**
	 * ��֤�����ʽ >>>>> ����� mlick 2014��8��8��
	 */
	public static boolean isEmail(String strEmail) {
		if (StringUtils.isEmpty(strEmail)) {
			return false;
		}

		String strPattern = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(strPattern);
		Matcher m = p.matcher(strEmail);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��ȡϵͳ���� 2015.02.10 by SHDB
	 * 
	 * @return ϵͳ����
	 */
	public String getSysName() {
		// TODO��20150210
		// android.os.Build.MODEL + ","+ android.os.Build.VERSION.SDK + ","+
		// android.os.Build.VERSION.RELEASE);
		//return "1";
		// ��ȡ�ֻ��ͺ�
				return android.os.Build.MODEL;
	}

	/**
	 * ��ȡϵͳ���� 2015.02.10 by SHDB
	 * 
	 * @return ϵͳ����
	 */
	public String getSysType() {
		// TODO 20150210
		// ��ȡ�ֻ��ͺ�
		return android.os.Build.MODEL;

	}

	/**
	 * ��ȡϵͳ�汾�� 2015.02.10 by SHDB
	 * 
	 * @return ϵͳ�汾��
	 */
	public String getSysVersion() {
		return android.os.Build.VERSION.RELEASE;
	}

	/**
	 * ��ȡϵͳIMEI 2015.02.10 by SHDB
	 * 
	 * @return ϵͳIMEI
	 */
	public String getSysImei() {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String imei = tm.getDeviceId();
		return imei;
	}

	/**
	 * ��ȡϵͳWiFi Mac��ַ 2015.02.10 by SHDB
	 * 
	 * @return ϵͳWiFi Mac��ַ
	 */
	public String getSysWifiMac() {
		WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo info = wifi.getConnectionInfo();
		String wifiMac = info.getMacAddress();
		return wifiMac;
	}

}
