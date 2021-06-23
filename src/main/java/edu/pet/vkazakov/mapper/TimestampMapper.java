package edu.pet.vkazakov.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class TimestampMapper {
    public Timestamp map(String value) {
    if(value == null || value == ""){return null;}
        return  Timestamp.valueOf(value+" 00:00:000.000000000");
    }

}
