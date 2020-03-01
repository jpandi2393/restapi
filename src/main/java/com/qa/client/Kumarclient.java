package com.qa.client;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Kumarclient {
	
	//GET Method
	
	public CloseableHttpResponse GET(String url) throws ClientProtocolException, IOException
	
	{  //1.GET Method
		CloseableHttpClient httpclient=HttpClients.createDefault();//get a client connection
		
		HttpGet httpreq =new HttpGet(url);//GET req
		
		CloseableHttpResponse response=httpclient.execute(httpreq); //hit the get url
		
		return response;
				
}
}
 