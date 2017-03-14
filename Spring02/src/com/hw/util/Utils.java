package com.hw.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Utils {

	public static boolean writeLog(String exception){
		
		File fileDir = new File("log");
		if(!fileDir.exists()){
			fileDir.mkdir();
		}
		
		File file = new File("log/log.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		Writer writer = null;
		try {
			writer = new FileWriter(file,true);
			writer.write(exception+"\r\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
