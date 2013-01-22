package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model.Finder;

@Entity
@Table
public class EventAction {
	@Id 
	public Long id;
	
	@Required
	public String desc;
	
	public List<Param> parameters = new ArrayList<Param>();
	
	public static Finder<Long, EventAction> find = new Finder<Long, EventAction>(
	    Long.class, EventAction.class);
	
	public static Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		for (EventAction action : find.all())
			map.put(action.id.toString(), action.desc);
		return map;
	}
	
	public static class Param {
		@Required
		public String name;
	}
}
