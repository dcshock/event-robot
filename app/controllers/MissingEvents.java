package controllers;

import models.MissingEventWatch;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class MissingEvents extends Controller {
	static Form<MissingEventWatch> missingForm = form(MissingEventWatch.class);
	
	public static Result create() {
		return ok(views.html.missingEvent.render(missingForm));
	}
	
	public static Result list() {
		return ok(views.html.missingEvents.render(MissingEventWatch.find.all()));
	}
	
	public static Result save() {
		Form<MissingEventWatch> f = missingForm.bindFromRequest();
		
		if (f.hasErrors()) {
			return badRequest(
				views.html.missingEvent.render(f)
			);
		} else {
			f.get().save();
		}

		return redirect(routes.MissingEvents.list());
	}
	
	public static Result delete(Long id) {
		MissingEventWatch.delete(id);
		return redirect(routes.MissingEvents.list());
	}
}
