package validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import entity.ServicePortfolioConfiguration;
import validation.annotation.IsValidateSPCF;

public class SPCValidator implements ConstraintValidator<IsValidateSPCF, ServicePortfolioConfiguration> {

	@Override
	public void initialize(IsValidateSPCF arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(ServicePortfolioConfiguration spcf, ConstraintValidatorContext constraintValidatorContext) {
		constraintValidatorContext.disableDefaultConstraintViolation();
		if (spcf.getName().equals("")) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("対象科目を選択してください").addConstraintViolation();
			return false;
		} else if (spcf.getName().length() > 32) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("最大32文字まで入力可能とする").addConstraintViolation();
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}

}
