package com.dashboardbff.utility;

import com.dashboardbff.utility.exception.BadRequest;

import java.lang.reflect.Field;
import java.util.Objects;

public class RequestValidator {

    protected static void validator(Object object) throws BadRequest {
        Class requestClass =  object.getClass();

        Field[] fields = requestClass.getDeclaredFields();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object o = field.get(object);

                if (Objects.isNull(o)) {
                    throw new BadRequest("Invalid " + field.getName());
                }

            }
        } catch (IllegalAccessException e) {
            throw new BadRequest("Invalid " + Object.class.getName());
        }
    }

}
