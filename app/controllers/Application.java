package controllers;

import models.ScheduledProcess;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.avaje.ebean.Ebean;


public class Application extends Controller {
	public static Result index() {
		Ebean.find(ScheduledProcess.class, 1L);
		return ok(index.render("Your new application is ready."));
	}
}