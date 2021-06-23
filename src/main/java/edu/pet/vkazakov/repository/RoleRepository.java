package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.Role;
import edu.pet.vkazakov.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
    @Query(value = "INSERT INTO roles(id, name) VALUES(1, 'ROLE_ADMIN');\n" +
            "INSERT INTO roles(id, name) VALUES(2, 'ROLE_PM');\n" +
            "INSERT INTO roles(id, name) VALUES(3, 'ROLE_USER');",
            nativeQuery = true)
    List<Long> saveByRole();

}

