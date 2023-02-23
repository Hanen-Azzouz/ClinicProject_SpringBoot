package tn.esprit._3cinfogl1.clinicproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.clinicproject.DAO.Entities.Medecin;
@Repository
public interface MedecinRepository extends CrudRepository<Medecin,Long> {


}
