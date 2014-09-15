package mlick.lxxlibrary.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.os.Environment;

/**
 * �ļ������Ĺ�����
 * 
 * @author lxx
 * @date 2014-9-15
 * @time ����3:41:43
 */
public class FileUtil {

	/**
	 * ��SD���ϴ����ļ�
	 * 
	 * @param filepath
	 * @return Ϊnull˵���ļ��Ѿ�����
	 * @throws IOException
	 */
	public static File createSDFile(String filepath) throws IOException {

		if (isFileExist(filepath)) {
			return null;
		}

		File file = new File(filepath);
		file.createNewFile();
		return file;
	}

	/**
	 * ��SD���ϴ���Ŀ¼
	 * 
	 * @param filepath
	 * @return Ϊnull˵���Ѿ����ڸ�Ŀ¼
	 */
	public static File createSDDir(String filepath) {

		if (isFolderExists(filepath)) {
			return null;
		}

		File dir = new File(filepath);

		dir.mkdir();
		return dir;
	}

	/*
	 * �ж�SD���ϵ��ļ����Ƿ����
	 */
	public static boolean isFileExist(String filepath) {
		File file = new File(filepath);
		return file.exists();
	}

	/**
	 * �ж��ļ����Ƿ����
	 * 
	 * @param strFolder
	 * @return
	 */
	public static boolean isFolderExists(String filepath) {
		File file = new File(filepath);
		if (!file.exists()) {
			return true;
		}
		return false;
	}

	public static String getPath(Context context, String packageName,
			String content) {
		String path = null;
		boolean hasSDCard = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);// �ж��Ƿ���sd��

		if (hasSDCard) {
			path = Environment.getExternalStorageDirectory().getPath()
					+ packageName + "/" + content;
		} else {
			path = context.getFilesDir().getPath() + packageName + "/"
					+ content;
		}

		// File file = new File(path);
		//
		// if (!file.exists()) {
		// file.mkdirs();
		// }
		// return file.getPath();
		return path;

	}

	/*
	 * ��һ��InputStream���������д�뵽SD����
	 */
	public static File write2SDFromInput(String path, String fileName,
			InputStream input) {
		File file = null;
		OutputStream output = null;
		try {
			// ����Ŀ¼
			createSDDir(path);
			// �����ļ�
			file = createSDFile(path + fileName);
			// ���������
			output = new FileOutputStream(file);
			// ����������
			byte buffer[] = new byte[4 * 1024];
			// д������
			int bufferLength = 0;
			while ((bufferLength = input.read(buffer)) != -1) {
				output.write(buffer, 0, bufferLength);
			}
			// ��ջ���
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر������
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	/**
	 * ���Ƶ����ļ�
	 * 
	 * @param oldPath
	 *            String ԭ�ļ�·�� �磺c:/fqf.txt
	 * @param newPath
	 *            String ���ƺ�·�� �磺f:/fqf.txt
	 * @return boolean
	 */
	public void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // �ļ�����ʱ
				InputStream inStream = new FileInputStream(oldPath); // ����ԭ�ļ�
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // �ֽ��� �ļ���С
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("���Ƶ����ļ���������");
			e.printStackTrace();

		}
	}
}
