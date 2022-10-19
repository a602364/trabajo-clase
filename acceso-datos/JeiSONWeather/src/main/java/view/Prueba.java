package view;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import model.Dia;
import model.Result;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String jsonTxt = IOUtils.toString(new URL("https://api.darksky.net/forecast/21259f9de3537b4f719c53580fa39c3a/39.8710026,-4.0251675?lang=es&exclude=minutely,hourly,alerts,flags/r/n"
                    + ""),"utf-8");			
			Result result = new Gson().fromJson(jsonTxt, Result.class);
			
			for (Dia dia: result.getDaily().getData()) {
				System.out.println(dia.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
