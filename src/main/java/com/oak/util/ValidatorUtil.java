package com.oak.util;

import com.oak.exception.ParamException;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidatorUtil {

    private static final Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static void validate(Object object) {
        // 如果集合不为空表示校验失败
        Set<ConstraintViolation<Object>> violations = validator.validate(object);

        if(!CollectionUtils.isEmpty(violations)) {
            String errorMsg = violations.stream()
                    .map(violation -> violation.getMessage())
                    .collect(Collectors.joining(";"));

            throw new ParamException(errorMsg);
        }
    }
}
