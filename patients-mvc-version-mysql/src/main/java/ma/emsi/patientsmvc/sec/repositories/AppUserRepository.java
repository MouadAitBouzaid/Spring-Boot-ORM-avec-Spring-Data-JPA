package ma.emsi.patientsmvc.sec.repositories;

import ma.emsi.patientsmvc.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository  extends JpaRepository<AppUser,String> {
}
