package edu.pet.vkazakov.mapper;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DateMapper {
    public Date map(String value) {
    if(value == null || value == ""){return null;}
        return  Date.valueOf(value);
    }

}
