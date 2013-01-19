package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table
public class EventWatch extends Model {
	@Id
	public Long id;
	
	@Required
	public String event;
	
	public String desc;
	
	public String does;
	
	public static Finder<Long, EventWatch> find = new Finder<Long, EventWatch>(
	    Long.class, EventWatch.class);
	
	public static void delete(Long id) {
		find.ref(id).delete();
	}
}
