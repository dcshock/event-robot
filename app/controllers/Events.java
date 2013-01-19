package controllers;

import models.EventWatch;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Events extends Controller {
	static Form<EventWatch> eventForm = form(EventWatch.class);
	
	public static Result list() {
		return ok(views.html.events.render(EventWatch.find.all()));
	}
	
	public static Result create() {
		return ok(views.html.event.render(eventForm));
	}
	
	public static Result save() {
		Form<EventWatch> f = eventForm.bindFromRequest();
		
		
		if (f.hasErrors()) {
			return badRequest(
				views.html.event.render(f)
			);
		} else {
			f.get().save();
		}

		return redirect(routes.Events.list());
	}
	
	public static Result delete(Long id) {
		EventWatch.delete(id);
		return redirect(routes.Events.list());
	}
}
