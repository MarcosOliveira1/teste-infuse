package com.teste.dev.java.infuse.util;

import com.teste.dev.java.infuse.exception.NegocioException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AssertUtils {

    public void assertTrue(boolean expression, String message) {
        if (!expression)
            throw new NegocioException(message);
    }
}
