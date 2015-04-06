package hedin.stuff.progg.data.organisation;

import java.util.LinkedList;
import java.util.List;

public class Enterprise {
	String id;
	String name;
	String description;
	List<BusinessUnit> businesUnits;
	
	public Enterprise(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.businesUnits = new LinkedList<BusinessUnit>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void clearBusinesUnits(){
		this.businesUnits.clear();
	}
	public void addBusinessUnits(List<BusinessUnit> units){
		this.businesUnits.addAll(units);
	}
}
