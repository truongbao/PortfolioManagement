package validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import validation.validator.SPCValidator;

@Documented
@Constraint(validatedBy = SPCValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidateSPCF {
	String message() default "対象科目を選択してください";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
