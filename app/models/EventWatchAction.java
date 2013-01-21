package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class EventWatchAction {
	@Id
	public Long id;

	@ManyToOne()
	@JoinColumn(referencedColumnName="id", name="action_id")
	public EventAction action;
	
	@ManyToOne()
	@JoinColumn(referencedColumnName="id", name="event_id")
	public EventWatch event;
}
