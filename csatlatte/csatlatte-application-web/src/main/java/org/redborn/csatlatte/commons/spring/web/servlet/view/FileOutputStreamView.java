package org.redborn.csatlatte.commons.spring.web.servlet.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.redborn.csatlatte.commons.servlet.http.HttpServletUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileOutputStreamView extends AbstractView {
	
	private InputStream inputStream;
	private String outputFileName;
	
	public static final String PNG = "png";
	public static final String GIF = "gif";
	public static final String BMP = "bmp";
	public static final String JPEG = "jpg";
	public static final String EXCEL = "xls";
	public static final String DOCUMENT = "doc";
	public static final String PDF = "pdf";
	
	private static int IE = 0;
	private static int CHROME = 1;
	private static int SAFARI = 2;
	private static int FIRE_FOX = 3;
	private static int OPERA = 4;
	private static int ANDROID = 5;
	
	/**
	 * @param path 파일 경로
	 * @throws FileNotFoundException 
	 */
	public FileOutputStreamView(String path) throws FileNotFoundException {
		this(path, path.substring(path.lastIndexOf(".") + 1));
	}
	
	/**
	 * @param path 파일 경로
	 * @param extension 확장자
	 * @throws FileNotFoundException 
	 */
	public FileOutputStreamView(String path, String extension) throws FileNotFoundException {
		this(path, extension, path.substring(path.lastIndexOf("/")));
	}
	
	/**
	 * @param path 파일 경로
	 * @param extension 확장자
	 * @param outputFileName 출력 파일명
	 * @throws FileNotFoundException 
	 */
	public FileOutputStreamView(String path, String extension, String outputFileName) throws FileNotFoundException {
		this(new FileInputStream(path), extension, outputFileName);
	}
	
	/**
	 * @param path 파일 경로
	 * @param extension 확장자
	 * @param outputFileName 출력 파일명
	 * @param noImagePath 이미지 없을 경우 출력할 이미지
	 */
	public FileOutputStreamView(InputStream inputStream, String extension, String outputFileName) {
		super.setContentType(HttpServletUtils.getInstance().getMime(extension));
		this.inputStream = inputStream;
		this.outputFileName = outputFileName;
	}
	
	/**
	 * 브라우저에 따른 숫자를 구합니다.
	 * 
	 * @param userAgent 
	 * @return 브라우저에 따른 숫자
	 */
	private int getBrower(String userAgent) {
		userAgent = userAgent.toLowerCase();
		int brower = -1;
		if (userAgent.indexOf("msie") > -1) {
			brower = IE;
		} else if (userAgent.indexOf("chrome") > -1) {
			brower = CHROME;
		} else if (userAgent.indexOf("safari") > -1) {
			brower = SAFARI;
		} else if (userAgent.indexOf("firefox") > -1) {
			brower = FIRE_FOX;
		} else if (userAgent.indexOf("opera") > -1) {
			brower = OPERA;
		} else if (userAgent.indexOf("android") > -1) {
			brower = ANDROID;
		}
		return brower;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (inputStream != null) {
			OutputStream out = null;
			
			response.setContentType(getContentType());
			response.setContentLength(inputStream.available());
			response.setHeader("Content-Transfer-Encoding", "binary");
			int brower = getBrower(request.getHeader("User-Agent"));
			if (brower == IE) {
				outputFileName = URLEncoder.encode(outputFileName, "UTF-8").replaceAll("\\+", "%20");
			} else if (brower == CHROME) {
				int fileNameLength = outputFileName.length();
				StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < fileNameLength; i++) {
	                char c = outputFileName.charAt(i);
	                if (c > '~') {
	                    sb.append(URLEncoder.encode("" + c, "UTF-8"));
	                } else {
	                    sb.append(c);
	                }
	            }
	            outputFileName = sb.toString();
			} else if (brower == SAFARI || brower == FIRE_FOX || brower == OPERA) {
				outputFileName =  "\"" + new String(outputFileName.getBytes("UTF-8"), "8859_1") + "\"";
			} else if (brower == ANDROID) {
				
			}
			
			response.setHeader("Content-Disposition", "attachment;filename=" + outputFileName);
			
			try {
				out = response.getOutputStream();
				FileCopyUtils.copy(inputStream, out);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						out.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
