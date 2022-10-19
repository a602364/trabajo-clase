package model;

public class Dia {
	private long time;
	private String summary;
	private String icon;
	private float precipProbability;
	private float temperatureMax;
	private float temperatureMin;
	
	
	public long getTime() {
		return time;
	}
	public String getSummary() {
		return summary;
	}
	public String getIcon() {
		return icon;
	}
	public float getPrecipProbability() {
		return precipProbability;
	}
	public float getTemperatureMax() {
		return temperatureMax;
	}
	public float getTemperatureMin() {
		return temperatureMin;
	}
	
	@Override
	public String toString() {
		return "Dia [time=" + time + ", summary=" + summary + ", icon=" + icon + ", precipProbability="
				+ precipProbability + ", temperatureMax=" + temperatureMax + ", temperatureMin=" + temperatureMin + "]";
	}
	
	
	
}
