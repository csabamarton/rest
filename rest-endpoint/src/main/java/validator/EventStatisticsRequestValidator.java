package validator;

import dto.EventStatisticsRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EventStatisticsRequestValidator implements ConstraintValidator<EventStatisticsConstraint, EventStatisticsRequest> {

    public void initialize(EventStatisticsConstraint constraintAnnotation)
    {

    }

    public boolean isValid(EventStatisticsRequest value, ConstraintValidatorContext context)
    {
        boolean isValid = true;

        if (value == null) {
            return false;
        }

        if (value.getStartDate() != null && value.getEndDate() != null) {
            if (value.getStartDate().after(value.getEndDate())) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Wrong request date order")
                        .addConstraintViolation();

                isValid = false;
            }
        } else {
            if (value.getStartDate() == null) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Wrong startDate")
                        .addConstraintViolation();

                isValid = false;
            }
            if (value.getEndDate() == null) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Wrong endDate")
                        .addConstraintViolation();

                isValid = false;
            }
        }

        if (value.getEventType() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Wrong eventType")
                    .addConstraintViolation();

            isValid = false;
        }

        return isValid;
    }
}