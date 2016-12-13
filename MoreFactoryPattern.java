/**
*	Problem 1 code.
*/
public abstract class CondimentDecorator extends Beverage {
	private Beverage beverage;
	
	public CondimentDecorator(Beverage b) {
		beverage = b;
	}
	
	public double cost() {
		return beverage.cost();
	}
	
	public String getDescription() {
		return beverage.getDescription();
	}
}

class Mocha extends CondimentDecorator {
	public Mocha(Beverage beverage) {
		super(beverage);
	}
	
	public double cost() {
		return 0.20 + super.cost();
	}
	
	public String getDescription() {
		return super.getDescription() + " Mocha "
	}
}

/**
*	Problem 2
*/

abstract class Pizza {
    private String description = "Unknown Pizza";
    
    public String getDescription() {
        return description;
    }
    
    public abstract int getCalories();
    
    /** Code to test Pizza **/
	public static void main(String[] args) {
        Pizza pizza = new OliveOilAndGarlic(new OliveOilAndGarlic(new MellowCrust()));
        System.out.println("Description " + pizza.getDescription());
        System.out.println("Calories " + pizza.getCalories());
    }
    
}

class MellowCrust extends Pizza {
    
    public String getDescription() {
        return "Mellow Crust";
    }
    
    public int getCalories() {
        return 150;
    }
}

abstract class Topping extends Pizza {
    private Pizza wrap;
    
    public Topping(Pizza wrap) {
        this.wrap = wrap;
    }
    
    public String getDescription() {
        return wrap.getDescription();
    }
    
    public int getCalories() {
        return wrap.getCalories();
    }
}

class OliveOilAndGarlic extends Topping {

    public OliveOilAndGarlic(Pizza pizza) {
        super(pizza);
    }
    
    public String getDescription() {
        return super.getDescription() + ", Olive Oil and Garlic";
    }
    
    public int getCalories() {
        return super.getCalories() + 35;
    }
}