package tn.esprit._3cinfogl1.clinicproject.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfogl1.clinicproject.DAO.Entities.*;
import tn.esprit._3cinfogl1.clinicproject.DAO.Repositories.CliniqueRepository;
import tn.esprit._3cinfogl1.clinicproject.DAO.Repositories.MedecinRepository;
import tn.esprit._3cinfogl1.clinicproject.DAO.Repositories.PatientRepository;
import tn.esprit._3cinfogl1.clinicproject.DAO.Repositories.RendezVousRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class Services implements IServices {

    @Autowired
    private CliniqueRepository clinicRepo;
    @Autowired
    private MedecinRepository medecinRepo;
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private RendezVousRepository rdvRepo;


    @Override
    public Clinique addClinique(Clinique clinique) {


        return clinicRepo.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique clincaffecte=clinicRepo.findById(cliniqueId).get();
        medecinRepo.save(medecin);
        clincaffecte.getDocteur().add(medecin);
        clinicRepo.save(clincaffecte);
        return medecin;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {

        Medecin medecinaffecte=medecinRepo.findById(idMedecin).get();
        Patient patientaffecte=patientRepo.findById(idPatient).get();
        rdv.setPatient(patientaffecte);
        rdv.setMedecin(medecinaffecte);
        rdvRepo.save(rdv);


    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {

        //return rdvRepo.getRendezVousParCliniqueEtSpecialiteSQL(idClinique,specialite);
        return rdvRepo.getRendezVousParCliniqueEtSpecialiteJPQL(idClinique,specialite);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        // Avec SQL
       // return rdvRepo.nbrRdvMedecin(idMedecin);


        //Avec keywords
        return rdvRepo.findRendezVousByMedecinIdMedecin(idMedecin).size();
    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
        Medecin medecin=medecinRepo.findById(idMedecin).get();
        return (rdvRepo.findRendezVousByMedecinIdMedecinAndDateRDVBetween(idMedecin,startDate,endDate).size())*medecin.getPrixConsultation();
    }
//@Scheduled(cron = "30 * * * * *")
    @Override
    public void retrieveRendezVous() {

        List<RendezVous> rdvs=new ArrayList<RendezVous>();
        rdvs=rdvRepo.findRendezVousByDateRDVIsAfter(new Date());
                //(List<RendezVous>) rdvRepo.findAll();
    for (RendezVous rdv:rdvs)
    {
                log.info("Rendez vous "+rdv.getDateRDV()+" : "+"Medecin"+":"+rdv.getMedecin().getNomMedecin()
                        +"Patient"+" : "+rdv.getPatient().getNomPatient());
            }

    }



}
