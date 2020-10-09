package com.vastika.uis.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageUtil {

	private static final String Image_PATH="/Users/sayanashrestha/Desktop/";
	private static final int BUFFER_SIZE=1000;
	
	
	public static final String writeImageToFile(CommonsMultipartFile file) {
		
		String fileName = file.getOriginalFilename();
		String imageUploadPath= Image_PATH+ fileName;
		
		InputStream is= null;
		try(	
				FileOutputStream fos= new FileOutputStream(imageUploadPath)
				){
				byte[] bytes= file.getBytes();
				fos.write(bytes);
				fos.flush();
				
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return imageUploadPath;
	}
	
	public static void displayImage(String imagePath, HttpServletResponse response) {
		
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(imagePath),BUFFER_SIZE );
			BufferedOutputStream out= new BufferedOutputStream(response.getOutputStream(),BUFFER_SIZE );	
				){
			int len;
			byte[] bytes = new byte[BUFFER_SIZE];
			
			while((len=in.read(bytes))!=-1){
				out.write(bytes, 0, len);
				out.flush();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
