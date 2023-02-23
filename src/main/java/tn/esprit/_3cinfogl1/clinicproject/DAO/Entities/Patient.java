package tn.esprit._3cinfogl1.clinicproject.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPatient;
    String nomPatient;
    int telephone;
    Date dateNaissance;

    //3 eme relation  Patient est le child de RendezVous ManyToOne
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    List<RendezVous>  lstrdv;

















}
