public class SteamPlant {
	static SteamPlant uniqueInstance = new SteamPlant();
		private final int MAX_TEMPERATURE = 250;
		private final int MIN_TEMPERATURE = 50;
		private final int INITIAL_TEMPERATURE = 225;
		private final int INITIAL_HEAT_AVAILABLE = 1000;
		private int currentTemperature; 
		private int heatAvailable;

	   	private SteamPlant() {
	   		setTemperature(INITIAL_TEMPERATURE);
	   		heatAvailable = INITIAL_HEAT_AVAILABLE;
	   	}

	public static SteamPlant getSteamPlant() {
	    if (uniqueInstance == null) {
	        synchronized (SteamPlant.class) {
	           if (uniqueInstance == null) {
	              uniqueInstance = new SteamPlant();
	           }
	        }
	    }
		return uniqueInstance;
	}

	public synchronized int consumeHeat(int h) {
		h = (h < heatAvailable) ? h : heatAvailable;
		heatAvailable -= h;
		System.out.println ("Consuming Heat Units: " + h + " Heat Left Available: " + heatAvailable);
		return h;
	}
	
	public void timeTick() {
		int newHeat = (currentTemperature - 212) * 100;
		heatAvailable += newHeat;
		if (heatAvailable < 0) heatAvailable = 0;
		System.out.println ("TimeTick. Heat Produced: " + newHeat + " Heat Available: " + heatAvailable);
	}
	
	public void setTemperature(int t) {
		t = (t < MAX_TEMPERATURE) ? t : MAX_TEMPERATURE;
		t = (t > MIN_TEMPERATURE) ? t : MIN_TEMPERATURE;
		currentTemperature = t;
	}

	public void changeTemperature(int delta) {
		setTemperature(currentTemperature + delta);
		System.out.println ("changeTemperature: " + currentTemperature);
	}
}
