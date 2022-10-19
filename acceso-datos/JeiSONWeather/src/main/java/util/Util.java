package util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Util {
	public static String timeStampToDate(long ts) {
	    SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
	    return(df.format(ts*1000));
	}
	
	public static double farToCel(double far) {
		double cel = (far - 32) * 0.5556;
		DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
		DecimalFormat df = new DecimalFormat("#0.00",simbolos);   
		cel = Double.valueOf(df.format(cel));
	    return(cel);
	}

}
