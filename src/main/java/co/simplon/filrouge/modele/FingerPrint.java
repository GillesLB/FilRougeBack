package co.simplon.filrouge.modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder

// va générer un constructeur sans paramètre
@NoArgsConstructor

// crée un constructeur avec 1 avec 1 param dans chaque champ de la classe
@AllArgsConstructor

// déclare la classe comme un entity bean (ie une classe POJO persistante)
@Entity

// permet de définir le nom de la table, du catalogue et du schéma pour le mapping de votre entity bean
@Table(name = "fingerprint")

// ...
@EntityListeners(AuditingEntityListener.class)

public class FingerPrint implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fingerprint")
    private String fingerprint;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date uptdateDate;

    //création de la table de jointure pour Many to One entre Personnes et Empreintes
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "people_id")
    @JsonBackReference // evite la récurcivite dans le JSON
    private People people;


}






