package tn.esprit._3cinfogl1.clinicproject.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Clinique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClinique;
    String nomClinique;
    String adresse;
    int telephone;

    //1ere relation  many to manyavec medecin :  clinique est le parent de medecin
   @JsonIgnore
    @ManyToMany
    List<Medecin> docteur;


}
