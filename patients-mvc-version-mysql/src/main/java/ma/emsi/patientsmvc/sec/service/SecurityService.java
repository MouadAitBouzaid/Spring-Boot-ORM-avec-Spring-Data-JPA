package ma.emsi.patientsmvc.sec.service;

import ma.emsi.patientsmvc.sec.entities.AppRole;
import ma.emsi.patientsmvc.sec.entities.AppUser;

public interface SecurityService {
        AppUser saveNewUser(String username, String password, String rePassword);
        AppRole saveNewRole(String roleName, String description);
        void addRoleToUser(String username, String roleName);
        void removeRoleToUser(String username, String roleName);
        AppUser loadUserByUserName(String username);
}