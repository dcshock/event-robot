package models;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.quartz.CronExpression;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import eventrobot.validation.CronLine;

@Entity
@Table
public class LackOfEventWatch extends Model {
	@Id
	public Long id;
	
	@Required
	public String event;
	
	public String desc;
	
	@Required
	public String doesnt;
	
	@CronLine(required=true)
	public String timing;
	
	@Transient
	public String getNextRun() {
		try {
			return new CronExpression(timing)
				.getNextValidTimeAfter(new Date()).toString();
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Finder<Long, LackOfEventWatch> find = new Finder<Long, LackOfEventWatch>(
	    Long.class, LackOfEventWatch.class);
	
	public static void delete(Long id) {
		find.ref(id).delete();
	}
}
