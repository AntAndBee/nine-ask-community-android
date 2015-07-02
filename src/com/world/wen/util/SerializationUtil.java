/**
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 * @COMPANY IFXME.COM
 * @AUTHOR dkslbw@gmail.com
 * @TIME 2014年8月10日 下午9:41:21
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * 
 */
package com.world.wen.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;

/**
 * @DESCRIBE 序列化和反序列化工具
 */
public class SerializationUtil {

	private static SerializationUtil util;

	public static SerializationUtil sharedSerializationUtil() {
		if (util == null) {
			util = new SerializationUtil();
		}
		return util;
	}

	/**
	 * 序列化
	 * 
	 * @param obj
	 */
	public void serialize(Context context, Object obj) {
		try {
			// 需要一个文件输出流和对象输出流；文件输出流用于将字节输出到文件，对象输出流用于将对象输出为字节
			ObjectOutputStream out = new ObjectOutputStream(context.openFileOutput(AppInfoUtil.sharedAppInfoUtil().getSerializeDir(),
					Context.MODE_PRIVATE));
			out.writeObject(obj);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 反序列化
	 * 
	 * @return
	 */
	public Object unSerialize(Context context) {
		try {
			ObjectInputStream in = new ObjectInputStream(context.openFileInput(AppInfoUtil.sharedAppInfoUtil().getSerializeDir()));
			return in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void delete(Context context)
	{
		File file = context.getFileStreamPath(AppInfoUtil.sharedAppInfoUtil().getSerializeDir());
		if (file != null) {
			file.delete();
		}
	
	}
}
