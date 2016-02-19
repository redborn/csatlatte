package org.redborn.csatlatte.commons.amazonaws.services.s3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;

/**
 * 수능라떼의 Amazon S3와 연동하여 파일을 처리합니다. 
 * 
 * @author 최순열
 *
 */
@Service
public class CsatAmazonS3 {
	
	private String bucketName;
	private String accessKey;
	private String secretKey;
	private AmazonS3 amazonS3;
	
	public CsatAmazonS3() {
		this("/usr/local/csat/s3.properties");
	}
	
	public CsatAmazonS3(String propertiesPath) {
		try {Properties properties = new Properties();
			properties.load(new FileInputStream(propertiesPath));
			bucketName = (String) properties.get("bucketName");
			accessKey = (String) properties.get("accessKey");
			secretKey = (String) properties.get("secretKey");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		amazonS3 = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey));
		amazonS3.setRegion(Region.getRegion(Regions.AP_NORTHEAST_2));
	}
	
	/**
	 * 파일을 Amazon S3에 Upload 합니다.
	 * 
	 * @param file 파일
	 * @param prefix perfix
	 * @return 파일 코드
	 */
	public String upload(File file, String prefix) {
		String fileCode = makeFileCode(prefix);
		amazonS3.putObject(new PutObjectRequest(bucketName, new StringBuilder(prefix).append(File.separator).append(fileCode).toString(), file));
		return fileCode;
	}
	
	/**
	 * Amazon S3의 파일을 삭제 합니다.
	 * 
	 * @param prefix perfix
	 * @param fileCode 파일 코드
	 */
	public void delete(String prefix, String fileCode) {
		amazonS3.deleteObject(bucketName, new StringBuilder(prefix).append(File.separator).append(fileCode).toString());
	}
	
	/**
	 * 요청한 파일의 InputStream 입니다.
	 * 
	 * @param prefix perfix
	 * @param fileCode 파일 코드
	 * @return inputStream
	 */
	public InputStream getInputStream(String prefix, String fileCode) {
		InputStream inputStream = null;
		try {
			S3Object s3Object = amazonS3.getObject(new GetObjectRequest(bucketName, new StringBuilder(prefix).append(File.separator).append(fileCode).toString()));
			if (s3Object != null) {
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				try {
					IOUtils.copy(s3Object.getObjectContent(), byteArrayOutputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
				inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			}
		} catch (AmazonS3Exception e) {
			return null;
		}
		return inputStream;
	}
	
	/**
	 * prefix의 위치에 존재하지 않는 fileCode를 만듭니다. 
	 * 
	 * @param prefix S3 경로
	 * @return 파일 코드
	 */
	private String makeFileCode(String prefix) {
		String fileCode = null;
		do {
			fileCode = UUID.randomUUID().toString();
			try {
				amazonS3.getObjectMetadata(bucketName, new StringBuilder(prefix).append(File.separator).append(fileCode).toString());
			} catch (AmazonS3Exception e) {
				if (e.getStatusCode() == HttpStatus.SC_NOT_FOUND) {
					break;
				}
			}
			break;
		} while (true);
		return fileCode;
	}
	
}