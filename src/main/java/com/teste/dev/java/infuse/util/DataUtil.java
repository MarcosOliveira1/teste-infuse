package com.teste.dev.java.infuse.util;

import com.teste.dev.java.infuse.exception.NegocioException;
import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class DataUtil {

    private static final String REGEX_DATA = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}";

    public Date formatarData(String data) throws ParseException {
        if (data != null && !"".equals(data)) {
            if (!data.matches(REGEX_DATA)) {
                throw new NegocioException("Formato de data incorreto usar: dd-MM-yyyy");
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            return formatter.parse(data);
        }
        return null;
    }
}
