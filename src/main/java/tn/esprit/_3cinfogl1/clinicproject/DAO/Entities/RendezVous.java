package tn.esprit._3cinfogl1.clinicproject.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRDV;
    @Temporal(TemporalType.DATE)
    Date dateRDV;
    String remarque;

    //2eme relation RendezVous est le parent de Medecin ManyToOne
     @JsonIgnore
     @ManyToOne
    Medecin medecin;

    //3 eme relation RendezVous est le parent de Patient ManyToOne
    @JsonIgnore
     @ManyToOne
     Patient patient ;

}
