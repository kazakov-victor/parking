package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.PersonDTO;
import edu.pet.vkazakov.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper extends EntityMapper<PersonDTO, Person>{
     PersonDTO toDto(Person person);

     @Mapping(target = "contracts", ignore = true)
     Person toEntity(PersonDTO personDTO);
}
