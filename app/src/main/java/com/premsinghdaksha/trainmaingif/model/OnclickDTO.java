package com.premsinghdaksha.trainmaingif.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OnclickDTO implements Serializable {

	@SerializedName("url")
	private String url;

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"OnclickDTO{" + 
			"url = '" + url + '\'' + 
			"}";
		}
}