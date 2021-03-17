package pl.coderslab.whereismystuff.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.whereismystuff.security.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("select r from Role r where r.name like 'ROLE_USER'")
    Role getRoleUser();

}