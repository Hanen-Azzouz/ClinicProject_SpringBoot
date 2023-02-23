package tn.esprit._3cinfogl1.clinicproject.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.clinicproject.DAO.Entities.Clinique;
@Repository
public interface CliniqueRepository extends CrudRepository<Clinique,Long> {
}
