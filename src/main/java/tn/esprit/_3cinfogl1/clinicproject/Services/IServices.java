package tn.esprit._3cinfogl1.clinicproject.Services;

import tn.esprit._3cinfogl1.clinicproject.DAO.Entities.*;

import java.util.Date;
import java.util.List;

public interface IServices {

       public Clinique addClinique(Clinique clinique);
       public Medecin addMedecinAndAssignToClinique(Medecin medecin,Long cliniqueId);
       public Patient addPatient(Patient patient);
       public void addRDVAndAssignMedAndPatient(RendezVous rdv,Long idMedecin,Long idPatient);

       public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idCliniquee, Specialite specialite);

        public int getNbrRendezVousMedecin(Long idMedecin);
        public int getRevenuMedecin(Long idMedecin, Date startDate,Date endDate);
        public void retrieveRendezVous();

















}
