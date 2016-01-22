package org.redborn.csatlatte.commons.amazonaws.services.s3;

import java.io.File;
import java.util.UUID;

/**
 * 파일 Utils 입니다.
 * 
 * @author 최순열
 *
 */
public class FileUtils {
	
	/**
	 * 요청 한 경로에 코드 형식으로 변환하여 파일을 옮깁니다. 
	 * 
	 * @param file 파일
	 * @param path 경로
	 * @return 파일 코드
	 */
	public static String renameToFileCode(File file, String path) {
		String fileCode = null;
		File moveFile;
		do {
			fileCode = UUID.randomUUID().toString();
			moveFile = new File(new StringBuilder(path).append("/").append(fileCode).toString());
		} while (moveFile.isFile());
		file.renameTo(moveFile);
		return fileCode;
	}

}