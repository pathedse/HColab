package hedin.stuff.progg.dao;

import hedin.stuff.progg.data.organisation.BusinessUnit;
import hedin.stuff.progg.data.organisation.Enterprise;
import hedin.stuff.progg.data.organisation.Restaurant;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EnterpriseDao {

	
	public Enterprise getEnterprise(String id){
		if(id.equals("1")){
			return  new Enterprise(id, "My Restaurant Corporation", "Restaurant chain serving Italian cuisine with focus on Toscany reigon. ");	
		}else if(id.equals("23")){
			return new Enterprise("23", "BurgarKedjan", "Fokuserad på att skapa smaskiga burgare");
		}else{
			throw new RuntimeException("Organisation not found");
		}
		
	}
	
	public boolean saveEnterprise(Enterprise organisation){
		//TODO: implement save
		return true;
	}
	
	public List<Enterprise> getAllEnterprisesForUser(String userId){
		//TODO: get a list of all organisation accociated with the provided userId.
		return new LinkedList<Enterprise>();
	}
	
	public List<BusinessUnit> getBusinesUnitsForEnterprise(String enterpriseId){
		List<BusinessUnit> units = new LinkedList<BusinessUnit>();
		if(enterpriseId.equals("1")){
			units.add(new Restaurant("R-1", "Litle Italy", "Small genuine italian resturant that gives a feeling of a small family Toscany vilage restaurant.",enterpriseId));
			units.add(new Restaurant("R-2", "Isola d'Elba", "Family restaurant with a cuisine inspired from the island Elba and its sea food.",enterpriseId));			
		}else if(enterpriseId.equals("23")){
			units.add(new Restaurant("R-3", "Kalles färska burgare", "Located at Gamla stan",enterpriseId));
			units.add(new Restaurant("R-4", "Bennys Burger", "Located at Vasastan.",enterpriseId));
		}
		return units;
		
		
	}
	
}
