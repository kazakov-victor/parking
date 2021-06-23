package edu.pet.vkazakov.config;


import edu.pet.vkazakov.entity.Basis;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class BasisConverter implements AttributeConverter<Basis, String> {

    @Override
    public String convertToDatabaseColumn(Basis basis) {
        if (basis == null) {
            return null;
        }
        return basis.getCode();
    }

    @Override
    public Basis convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Basis.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}