package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "event")
	public List<EventWatchAction> todos = new ArrayList<EventWatchAction>();
	
	public static Finder<Long, EventWatch> find = new Finder<Long, EventWatch>(
	    Long.class, EventWatch.class);
	
	public static void delete(Long id) {
		find.ref(id).delete();
	}
}
