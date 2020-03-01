package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Javabase {
	
	public Properties prop;
	
	public int status_code_200 = 200;
	public int status_code_400 = 400;
	public int status_code_404 = 404;



	

	public Javabase()
	
	{
		try
		{
			
			 prop= new Properties();
			 
			 FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.Properties");
			 
			 prop.load(fp);
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
		
	}
}
