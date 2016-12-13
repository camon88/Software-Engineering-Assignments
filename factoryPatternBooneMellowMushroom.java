public class BooneMellowMushroomPizza extends PizzaStore {
	public MellowMushroomPizza createPizza(String desc) {
		switch(desc){
			case "gourmet white":
				return new GourmetWhitePizza();
			case "kosmic karma":
				return new KosmicKarmaPizza();
				
			//All other MellowMushroomPizza types implemented similarly
			
			default:
				throw new IllegalArgumentException("Error: " + desc + " is not a valid pizza choice");
		}
	}
}

abstract class MellowMushroomPizza extends Pizza {
	protected Pizza decoratedPizza;
	private String name;
	
	public MellowMushroomPizza(String name){
		this.name = name;
	}
	
	public void prepare() {
		System.out.println("Preparing your pizza...");
	}
	
	public void bake() {
		System.out.println("Baking your pizza...");
	}
	
	public void cut() {
		System.out.println("Cutting your pizza...");
	}
	
	public void box() {
		System.out.println("Boxing your pizza...");
	}
	
	public int getCalories(){
		return decoratedPizza.getCalories();
	}
	
	public String getDescription() {
		return decoratedPizza.getDescription();
	}
	
	public String toString() {
		reutrn name + ": " + decoratedPizza.getDescription();
	}
}

class GourmetWhitePizza extends MellowMushroomPizza {
	public GourmetWhitePizza() {
		super("Gourmet White");
		//Assumed MellowCrust since none was specified.
		decoratedPizza = new Onions(new RomaTomatoes(new Mozzarella(new Feta(new Provolone(new SunDriedTomatoes(new OliveOilAndGarlic(new MellowsCrust()))))))); 
	}
}

class KosmicKarmaPizza extends MellowMushroomPizza {
	public KosmicKarmaPizza(){
		super("Kosmic Karma");
		//Assumed MellowCrust since none was specified.
		decoratedPizza = new Pesto(new RomaTomatoes(new SunDriedTomatoes(new Spinach(new Mozzarella(new Feta(new RedSauce(new MellowsCrust())))))));
	}
}

