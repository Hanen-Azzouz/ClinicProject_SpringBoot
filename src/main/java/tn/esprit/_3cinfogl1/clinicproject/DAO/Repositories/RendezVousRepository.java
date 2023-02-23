package tn.esprit._3cinfogl1.clinicproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.clinicproject.DAO.Entities.Medecin;
import tn.esprit._3cinfogl1.clinicproject.DAO.Entities.RendezVous;
import tn.esprit._3cinfogl1.clinicproject.DAO.Entities.Specialite;

import java.util.Date;
import java.util.List;

@Repository
public interface RendezVousRepository extends CrudRepository<RendezVous,Long> {


    @Query("select rdv from RendezVous rdv JOIN rdv.medecin.clinic cl WHERE cl.idClinique=?1 AND rdv.medecin.specialite=?2")
    List<RendezVous> getRendezVousParCliniqueEtSpecialiteJPQL(Long idClinique, Specialite specialite);

       // Premiére méthode avec SQL
    @Query(value = "select count(*) from rendez_vous rdv where rdv.medecin_id_medecin =?1 ",nativeQuery = true)
    int nbrRdvMedecin(Long idMedecin);

    // Deuxiéme méthode avec Keywords
    List<RendezVous> findRendezVousByMedecinIdMedecin(Long idMedecin);



    List<RendezVous> findRendezVousByMedecinIdMedecinAndDateRDVBetween(Long idMedecin,Date startDate, Date endDate);



  List<RendezVous> findRendezVousByDateRDVIsAfter(Date d);


}
