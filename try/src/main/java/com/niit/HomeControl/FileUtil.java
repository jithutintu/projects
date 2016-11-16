package com.niit.HomeControl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	//COMMON FUNCTIONALITIES ARE PUT HERE.. LIKE comma problems etc.
	
		public static String removeComma(String name){
			//REPLACE , WITH <EMPTYSPACE>
			return name.replace(",", "");
		}
		
		/*public static void main(String[] args) {
			System.out.println(Util.removeComma(",PRD001"));
		}*/
	}
	
