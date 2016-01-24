package org.redborn.csatlatte.commons.amazonaws.services.s3;

import java.io.File;
import java.util.UUID;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class CsatAmazonS3 {
	
	private String bucketName = "rb-csat";
	private String accessKey = "AKIAIOCOA4VJ4WXPHRYQ";
	private String secretKey = "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";
	private AmazonS3 amazonS3;
	
	public CsatAmazonS3 () {
		amazonS3 = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey));
	}
	
	public String upload(File file, String prefix) {
		String fileCode = makeFileCode(prefix);
		amazonS3.putObject(new PutObjectRequest(bucketName, new StringBuilder(prefix).append("/").append(fileCode).toString(), file));
		return fileCode;
	}
	
	/**
	 * 요청 한 경로에 코드 형식으로 변환하여 파일을 옮깁니다. 
	 * 
	 * @param file 파일
	 * @param prefix S3 경로
	 * @return 파일 코드
	 */
	private String makeFileCode(String prefix) {
		String fileCode = null;
		do {
			fileCode = UUID.randomUUID().toString();
			try {
				amazonS3.getObjectMetadata(bucketName, new StringBuilder(prefix).append("/").append(fileCode).toString());
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