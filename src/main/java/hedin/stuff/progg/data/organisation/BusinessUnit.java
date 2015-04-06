package hedin.stuff.progg.data.organisation;

public abstract class BusinessUnit {
	
	protected final String id;
	protected final String parentOrgId;
	protected final String name;
	protected final String description;

	public BusinessUnit(String id,String name, String description, String parentOrgId){
		this.id = id;
		this.name = name;
		this.description = description;
		this.parentOrgId = parentOrgId;
	}

	public String getId() {
		return id;
	}

	public String getParentOrgId() {
		return parentOrgId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	
	
}
