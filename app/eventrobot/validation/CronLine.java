package eventrobot.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CronLineValidator.class)
@play.data.Form.Display(name = "Cron format")
public @interface CronLine {
	String message() default CronLineValidator.message;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
