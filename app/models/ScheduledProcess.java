package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class ScheduledProcess extends Model {
	private static final long serialVersionUID = 6627006720962292887L;

	@Id
	public Long id;
	
	public String name;
	public String command;
}
