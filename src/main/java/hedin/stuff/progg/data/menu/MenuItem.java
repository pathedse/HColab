package hedin.stuff.progg.data.menu;

public abstract class MenuItem {

	private String name;
	private String description;
	private double price;
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public double getPrice(){
		return price;
	}
	
}
