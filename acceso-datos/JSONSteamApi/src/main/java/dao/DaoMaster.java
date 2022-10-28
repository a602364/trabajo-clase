package dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import model.ResultMaster;

public class DaoMaster {
	public static ResultMaster getData(){
		String jsonTxt = "";
		try {
			jsonTxt = IOUtils.toString(new URL("http://www.ies-azarquiel.es/paco/apisteam/game"),"utf-8");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return new Gson().fromJson(jsonTxt, ResultMaster.class);
	}
}
