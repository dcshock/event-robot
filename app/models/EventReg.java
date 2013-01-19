package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table
public class EventReg extends Model {
	@Id
	public Long id;
	
	@Required
	public String event;
	
	public String desc;
	
	public Boolean lackof;
	
	public static Finder<Long, EventReg> find = new Finder<Long, EventReg>(
	    Long.class, EventReg.class);
	
	public static void delete(Long id) {
		find.ref(id).delete();
	}
}
