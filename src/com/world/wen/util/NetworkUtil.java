package com.world.wen.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;

import com.world.wen.activity.Wen9Application;


public class NetworkUtil {
	/**
	 * @方法描述: 初始化当前手机的网络状态,网络状态即时记录保存在Application的moblieState和wifiState变量
	 * @作者:zhangshuo
	 * @param context
	 */
	public static void initNetworkState(Context context) {
		State wifiState = null;
		State mobileState = null;
		Wen9Application application = (Wen9Application) context
				.getApplicationContext();
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		wifiState = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
		mobileState = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
				.getState();
		if (wifiState != null && mobileState != null
				&& State.CONNECTED != wifiState
				&& State.CONNECTED == mobileState) {
			/* 手机网络连接成功 */
			application.setMobileState(true);
			application.setWifiState(false);
		} else if (wifiState != null && mobileState != null
				&& State.CONNECTED != wifiState
				&& State.CONNECTED != mobileState) {
			/* 手机没有任何的网络 */
			application.setMobileState(false);
			application.setWifiState(false);
		} else if (wifiState != null && State.CONNECTED == wifiState) {
			/* 无线网络连接成功 */
			application.setMobileState(false);
			application.setWifiState(true);
		}
	}

	/**
	 * 网络是否可用
	 * 
	 * @param activity
	 * @return
	 */
	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity == null) {
		} else {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * wifi是否打开
	 */
	public static boolean isWifiEnabled(Context context) {
		ConnectivityManager mgrConn = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		TelephonyManager mgrTel = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		return ((mgrConn.getActiveNetworkInfo() != null && mgrConn
				.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED) || mgrTel
				.getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS);
	}

	/**
	 * 判断当前网络是否是wifi网络
	 * if(activeNetInfo.getType()==ConnectivityManager.TYPE_MOBILE) { //判断3G网
	 * 
	 * @param context
	 * @return boolean
	 */
	public static boolean isWifi(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
	
		
		if (activeNetInfo != null
				&& activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
			if(null != connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()
					&& connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == State.CONNECTED){
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断当前网络是否是移动网络
	 * 
	 * @param context
	 * @return boolean
	 */
	public static boolean isMobile(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
		if (activeNetInfo != null
				&& activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
			if(null != connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()
					&& connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == State.CONNECTED){
				return true;
			}
		}
		return false;
	}
}
