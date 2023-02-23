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
public class Medecin  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idMedecin;
    String nomMedecin;
    int telephone;
    int prixConsultation;
    @Enumerated(EnumType.STRING)
    Specialite specialite;

    //1ere relation  many to many avec clinique : medecin  est le child  de clinique
    @JsonIgnore
    @ManyToMany(mappedBy = "docteur",cascade = CascadeType.ALL)
       List<Clinique> clinic;

    //2eme relation  Medecin est le child de RendezVous ManyToOne
    @JsonIgnore
    @OneToMany(mappedBy = "medecin")
    List<RendezVous> rdv;









}