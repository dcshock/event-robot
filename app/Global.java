

import java.util.List;
import java.util.Map;

import models.EventAction;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Yaml;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings {
	public static Scheduler sched;
	
	@Override
	public void onStart(Application app) {
		super.onStart(app);

		SchedulerFactory sf = new StdSchedulerFactory();
		try {
			Logger.info("Starting quartz");
			sched = sf.getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	
		if (Ebean.find(EventAction.class).findRowCount() == 0) {
			Map<String,List<Object>> all = 
				(Map<String,List<Object>>)Yaml.load("test_data.yml");
			Logger.info(all.get("actions").toString());
			Ebean.save(all.get("actions"));
		}
	}
	
	@Override
	public void onStop(Application app) {
		super.onStop(app);
		try {
			sched.shutdown(true);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
