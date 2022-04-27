package ma.emsi.patientsmvc.sec.repositories;

import ma.emsi.patientsmvc.sec.entities.AppRole;
import ma.emsi.patientsmvc.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppUser,Long> {
    AppRole findByRoleName(String roleName);

}
