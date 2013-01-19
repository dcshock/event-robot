package eventrobot.validation;

import java.text.ParseException;

import javax.validation.ConstraintValidator;

import org.quartz.CronExpression;

import play.data.validation.Constraints.Validator;

public class CronLineValidator extends Validator<String> 
  implements ConstraintValidator<CronLine, String> {
	static final String message = "Invalid cron line";
	
	private boolean required = true;
	
	@Override
	public boolean isValid(String arg0) {
		if (!required && (arg0 == null || arg0.length() == 0))
			return true;
		
		try {
			new CronExpression(arg0);
			return true;
		} catch (ParseException e) {
		}
		return false;
	}

	@Override
	public void initialize(CronLine a) {
		required = a.required();
	}
}
