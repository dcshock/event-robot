

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import play.Application;
import play.GlobalSettings;
import play.Logger;

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
