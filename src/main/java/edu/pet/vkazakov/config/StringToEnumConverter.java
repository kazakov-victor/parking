package edu.pet.vkazakov.config;

import edu.pet.vkazakov.entity.Basis;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Basis> {
    @Override
    public Basis convert(String source) {
        return Basis.valueOf(source.toUpperCase());
    }
}