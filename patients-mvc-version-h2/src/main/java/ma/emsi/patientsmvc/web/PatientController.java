package ma.emsi.patientsmvc.web;

import lombok.AllArgsConstructor;
import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositorie.PatientRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepositorie patientRepositorie;
    @GetMapping (path = "/index")
    public String patient(Model model){
        List<Patient> patients=patientRepositorie.findAll();
        model.addAttribute("listPatient",patients);
        return "patiens";
    }

}
