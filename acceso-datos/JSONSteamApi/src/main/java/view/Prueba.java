package view;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import model.Juegos;
import model.Result;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String jsonTxt = IOUtils.toString(new URL("http://www.ies-azarquiel.es/paco/apisteam/game"),"utf-8");			
			Result result = new Gson().fromJson(jsonTxt, Result.class);
			
			for (Juegos juego: result.getApplist().getApps().getJuegos()){
				System.out.println(juego.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
