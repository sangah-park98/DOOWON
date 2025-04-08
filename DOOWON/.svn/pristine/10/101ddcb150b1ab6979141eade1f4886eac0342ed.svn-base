package egovframework.pf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	public static void copyFile(String org, String desc) throws IOException{
	 
		File file = new File(org);
		File mfile = new File(desc);
		
	  InputStream inStream = null;
	  OutputStream outStream = null;
	 	 
	  try{
	      inStream = new FileInputStream(file); //원본파일
	      outStream = new FileOutputStream(mfile); //이동시킬 위치
	 
	 
	      byte[] buffer = new byte[1024];
	 
	 
	      int length;
	 
	 
	      while ((length = inStream.read(buffer)) > 0){
	      outStream.write(buffer, 0, length);
	      }
	  }catch(IOException e){
	      e.printStackTrace();
	  }finally{
	  inStream.close();
	      outStream.close();
	  }
	}
}
