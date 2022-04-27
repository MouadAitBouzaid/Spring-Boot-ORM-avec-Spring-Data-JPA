package ma.emsi.patientsmvc.sec.service;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import ma.emsi.patientsmvc.sec.entities.AppRole;
import ma.emsi.patientsmvc.sec.entities.AppUser;
import ma.emsi.patientsmvc.sec.repositories.AppRoleRepository;
import ma.emsi.patientsmvc.sec.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public AppUser saveUser(String username, String password, String rePassword) {
        if(!password.equals(rePassword)) throw new RuntimeException("Password not match");
        String hashedPWD=passwordEncoder.encode((password));
        AppUser appUSer=new  AppUser();
        appUSer.setUserId(UUID.randomUUID().toString());
        appUSer.setUsername(username);
        appUSer.setPassword(hashedPWD);
        appUSer.setActive(true);
        AppUser savedAppUser=appUserRepository.save(appUSer);
        return savedAppUser;
    }

    @Override
    public AppRole saveRole(String roleName, String description) {
        return null;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {

    }

    @Override
    public AppUser loadUserByUserName(String username) {
        return null;
    }
}
