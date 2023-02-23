package tn.esprit._3cinfogl1.clinicproject.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.clinicproject.DAO.Entities.*;
import tn.esprit._3cinfogl1.clinicproject.Services.IServices;

import java.util.Date;
import java.util.List;

@RequestMapping("Clinic")
@RestController
public class RestControllers {

    @Autowired
    private IServices clinicRest;
    @PostMapping("addClinique")
    Clinique addClinique(@RequestBody Clinique clinique){
    return clinicRest.addClinique(clinique);

    }
    @PostMapping("AddMedecinAndAssignToClinique")
    Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @RequestParam Long cliniqueId){
        return clinicRest.addMedecinAndAssignToClinique(medecin,cliniqueId);
    }
   @PostMapping("AddPatient")
    Patient addPatient(@RequestBody Patient patient){
        return clinicRest.addPatient(patient);

    }
    @PostMapping("addRDVAndAssignMedAndPatient")
    void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv,@RequestParam Long idMedecin, @RequestParam Long idPatient){
        clinicRest.addRDVAndAssignMedAndPatient(rdv,idMedecin,idPatient);

    }



    @GetMapping("GetRendezVousByCliniqueAndSpecialite")
    List<RendezVous> getRendezVousByCliniqueAndSpecialite(@RequestParam Long idClinique, @RequestParam Specialite specialite){
       return clinicRest.getRendezVousByCliniqueAndSpecialite(idClinique,specialite);


    }
  @GetMapping("NbrRendezVousMedecin")
    int getNbrRendezVousMedecin(@RequestParam Long idMedecin){
        return clinicRest.getNbrRendezVousMedecin(idMedecin);

    }
    @GetMapping("getRevenuMedecin/{idMedecin}/{startDate}/{endDate}")
    int getRevenuMedecin(@PathVariable("idMedecin") Long idMedecin,
                         @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                         @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate){


        return clinicRest.getRevenuMedecin(idMedecin,startDate,endDate);
    }

















}
