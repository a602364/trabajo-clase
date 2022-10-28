package view;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import model.Apps;
import model.ResultMaster;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String jsonTxt = IOUtils.toString(new URL("http://www.ies-azarquiel.es/paco/apisteam/game"),"utf-8");			
			ResultMaster result = new Gson().fromJson(jsonTxt, ResultMaster.class);
			
			for (Apps apps: result.getApplist().getApps()){
				System.out.println(apps.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
