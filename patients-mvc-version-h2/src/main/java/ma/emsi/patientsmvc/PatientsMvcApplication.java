package ma.emsi.patientsmvc;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositorie.PatientRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }


    @Bean
    CommandLineRunner commandeLineRunner(PatientRepositorie patientRepositorie){
        return args -> {
            patientRepositorie.save(new Patient(null,"hassan",new Date(),false,50));

            patientRepositorie.save(new Patient(null,"wiam",new Date(),false,12));

            patientRepositorie.save(new Patient(null,"kawtar",new Date(),false,20));

            patientRepositorie.save(new Patient(null,"salah",new Date(),true,4));

            patientRepositorie.findAll().forEach(patient -> {
                System.out.println(patient.getNom());
                    }
            );
        };
    }

}
