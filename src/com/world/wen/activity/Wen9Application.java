package com.world.wen.activity;

import android.app.Application;
import android.os.Environment;

public class Wen9Application extends Application {
	/**
	 * 存储session中的id
	 */
	public static String SESSION_ID = "";
	public boolean isLoged = false;
	/**
	 * 是否有更新
	 */
	public boolean hasUpdate = false;
	/**
	 * 是否处于离线模式
	 */
	public static boolean isInOfflineState = false;

	/** 记录当前的移动网络状态 ，true为链接成功，false为链接失败 */
	private boolean mobileState = false;
	/** 记录当前无线wifi网络状态，true为链接成功，false为链接失败 */
	private boolean wifiState = false;

	/** 手机SD卡路径 */
	private final String SDCardPath = Environment.getExternalStorageDirectory()
			.toString();
	/** 本软件缓存照片的目录 ,和系统存储目录相同 */
	public final String SysDefaultImageDir = SDCardPath + "/DCIM/camera/";
	/** 本软件使用的存储目录 */
	public final String BaseSDCardPath = SDCardPath + "/IYIMING/";
	/** 本软件上传图片的缓存目录 */
	public final String UploadImagePath = BaseSDCardPath + "uploadImage/";

	public boolean isMobileState() {
		return mobileState;
	}

	public void setMobileState(boolean mobileState) {
		this.mobileState = mobileState;
	}

	public boolean isWifiState() {
		return wifiState;
	}

	public void setWifiState(boolean wifiState) {
		this.wifiState = wifiState;
	}
}
