package dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import model.ResultDetalle;
import model.ResultMaster;

public class DaoDetail {
	public static ResultDetalle getData(String appid){
		String jsonTxt = "";
		try {
			jsonTxt = IOUtils.toString(new URL("https://store.steampowered.com/api/appdetails/?appids="+appid),"utf-8");
			jsonTxt= jsonTxt.substring(jsonTxt.indexOf(":")+1, jsonTxt.length()-1);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return new Gson().fromJson(jsonTxt, ResultDetalle.class);
	}
}
