package models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model.Finder;

@Entity
@Table
public class EventAction {
	@Id 
	public Long id;
	
	public String desc;
	
	public static Finder<Long, EventAction> find = new Finder<Long, EventAction>(
	    Long.class, EventAction.class);
	
	public static Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		for (EventAction action : find.all())
			map.put(action.id.toString(), action.desc);
		return map;
	}
}
