package hedin.stuff.progg.data.menu;

import java.util.List;


public class Menu {
	
	private String font;
	private int fontSize;
	private List<MenuSection> categories;
	
	
	public List<MenuSection> getCategories(){
		return categories;
	}
	
	public int getFontSise(){
		return this.fontSize;
	}
	
	public String getFont(){
		return this.font;
	}
	
	public static Menu getMenu(String id){
		return new Menu();
	}

}
