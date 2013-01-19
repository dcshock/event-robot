package controllers;

import models.EventReg;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Events extends Controller {
	static Form<EventReg> eventForm = form(EventReg.class);
	public static Result events() {
		return ok(views.html.events.render(
			EventReg.find.all(), eventForm));
	}
	
	public static Result newForm() {
		return ok(views.html.eventreg.render(
			EventReg.find.all(), eventForm));
	}
	
	public static Result newEvent() {
		Form<EventReg> f = eventForm.bindFromRequest();
		
		
		if (f.hasErrors()) {
			return badRequest(
				views.html.eventreg.render(EventReg.find.all(), f)
			);
		} else {
			f.get().save();
		}

		return redirect(routes.Events.events());
	}
	
	public static Result delete(Long id) {
		EventReg.delete(id);
		return redirect(routes.Events.events());
	}
}
