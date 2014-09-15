package mlick.lxxlibrary.system;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * �ж������Ƿ���ͨ�Ĺ�����
 * 
 * @author lxx
 * @date 2014-9-15
 * @time ����3:04:20
 */
public class NetworkUtils {

	public enum STATE {
		/**
		 * ������
		 */
		CONNECT_NONE,

		/**
		 * WIFI����
		 */
		CONNECT_WIFI,

		/**
		 * WIFI����
		 */
		CONNECT_MOBILE
	};

	// /**
	// * ������
	// */
	// public static final int STATE_CONNECT_NONE = 0;
	//
	// /**
	// * WIFI����
	// */
	// public static final int STATE_CONNECT_WIFI = 1;
	//
	// /**
	// * �ƶ����� 2G/3G
	// */
	// public static final int STATE_CONNECT_MOBILE = 2;

	/**
	 * ��ȡ��ǰ��������״̬
	 * 
	 * @param context
	 * @return ���� STATE_CONNECT_NONE�������ӣ� STATE_CONNECT_WIFI��WIFI����,
	 *         STATE_CONNECT_MOBILE���ƶ����� 2G/3G
	 */
	public static Enum<?> getNetConnectState(Context context) {
		final ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		if (networkInfo != null && networkInfo.isConnected()) {
			// return STATE_CONNECT_WIFI;
			return STATE.CONNECT_NONE;
		}
		networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (networkInfo != null && networkInfo.isConnected()) {
			// return STATE_CONNECT_MOBILE;
			return STATE.CONNECT_MOBILE;
		}
		// return STATE_CONNECT_NONE;
		return STATE.CONNECT_NONE;
	}

	public static boolean isNetworkAvailable(Context context) {
		boolean bConnected = false;
		ConnectivityManager connManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connManager != null) {
			NetworkInfo[] infos = connManager.getAllNetworkInfo();
			for (NetworkInfo info : infos) {
				if (info.getState() == NetworkInfo.State.CONNECTED) {
					bConnected = true;
					break;
				}
			}
		}
		return bConnected;
	}
}
