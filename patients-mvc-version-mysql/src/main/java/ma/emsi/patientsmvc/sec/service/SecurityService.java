package ma.emsi.patientsmvc.sec.service;

import ma.emsi.patientsmvc.sec.entities.AppRole;
import ma.emsi.patientsmvc.sec.entities.AppUser;

public interface SecurityService {
        AppUser saveUser(String username, String password, String rePassword);
        AppRole saveRole(String roleName, String description);
        void addRoleToUser(String username, String roleName);
        void removeRoleFromUser(String username, String roleName);
        AppUser loadUserByUserName(String username);
}
