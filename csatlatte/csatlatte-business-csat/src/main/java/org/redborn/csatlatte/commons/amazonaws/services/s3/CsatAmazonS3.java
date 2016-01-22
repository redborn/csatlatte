package org.redborn.csatlatte.commons.amazonaws.services.s3;

import java.io.File;
import java.util.UUID;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

public class CsatAmazonS3 {

	public String upload(File file, String directory) {
		AmazonS3 s3 = new AmazonS3Client(new BasicAWSCredentials("AKIAIOCOA4VJ4WXPHRYQ", "EA3YgLwUkAX6vbOG5021v7urXQyRjCmkOpe1JI/H"));
		s3.setRegion(Region.getRegion(Regions.AP_NORTHEAST_2));
		UUID.randomUUID();
		s3.putObject(new PutObjectRequest("rb-csat", new StringBuilder(directory).append("/").append(file.getName()).toString() , file));
		return null;
	}

}