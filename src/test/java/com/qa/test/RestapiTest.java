package com.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.base.Javabase;
import com.qa.client.Kumarclient;
import com.qa.util.TestUtil;

public class RestapiTest extends Javabase {
	
	Javabase javaBase;
	
	String endpointurl;
	
	String apiUrl;
	
	String url;
	
	CloseableHttpResponse response;
	
	JSONObject responsejson;
	
	@BeforeTest
	
	public void setup() throws ClientProtocolException,IOException
	
	{
		javaBase = new Javabase();
		
		endpointurl=prop.getProperty("URL");
		
		apiUrl=prop.getProperty("serviceurl");
		
		url=endpointurl+apiUrl; 
		
		
	}
	
	
	@Test
	
	public void test() throws ClientProtocolException, IOException
	
	{
	
		Kumarclient client=new Kumarclient();
		
	    response=client.GET(url);
	   
        int status_code=response.getStatusLine().getStatusCode();
		
		System.out.println("Status_Code is----->"+status_code);
		
		Assert.assertEquals(status_code, status_code_200,"Status code is not ok");
		
	//2.JSON String
		String respone=EntityUtils.toString(response.getEntity(),"UTF-8");
		
		JSONObject responsejson = new JSONObject(respone);
		
		responsejson.put("updated_address", "abc");
		
		responsejson.put("updated_name", "kumar");
        
		System.out.println("Response JSON----->" +responsejson);
		
		String data =TestUtil.getValueByJPath(responsejson, "/data"); //Testutil is a class which is used for parsing a json object.
		
		System.out.println("Respnse for email--->" +data);
		
					
	    //3.Headers
		
		Header[] headerarray=response.getAllHeaders();
		
		HashMap<String,String> headers = new HashMap<String,String>(); //Hashmap---> to store the value in the form of key value in particular format
		
		for(Header header:headerarray )
			
		{
			headers.put(header.getName(), header.getValue());
			
		}
			
		
		System.out.println("Headers---->" +headers);
			
		
	
	}

	      

}

	

	
	
