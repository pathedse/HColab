package hedin.stuff.progg.data.organisation;

import hedin.stuff.progg.data.menu.Menu;

import java.util.LinkedList;
import java.util.List;

public class Restaurant extends BusinessUnit {

	private final List<Menu> menus;
	
	public Restaurant(String id, String name, String description, String parentOrgId){
		super(id, name,description, parentOrgId);
		this.menus = new LinkedList<Menu>();	
	}
	
	public void clearMenus(){
		this.menus.clear();
	}
	
	public void removeMenu(Menu menu){
		this.menus.remove(menu);
	}
	public void removeMenuItem(int menu){
		this.menus.remove(menu);
	}
	
	public void addMenu(Menu menu){
		this.menus.add(menu);
	}
	public void addMenu(int index, Menu menu){
		this.menus.add(index, menu);
	}
	
	
}
