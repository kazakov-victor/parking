package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.entity.Basis;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnumMapper {
    public List<String> map(Basis basis) {
        List<String> result = new ArrayList<>();
        for (Basis b : Basis.values()) {
            result.add(basis.name());
        }
        return result;
    }
}
