package co.simplon.filrouge.modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weapon")
@EntityListeners(AuditingEntityListener.class)
public class Weapon implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String type;

    @NotBlank
    private String modele;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    // @ManyToMany : l'entité esclave doit préciser un champ retour par une annotation
    // fetch : permet de surcharger le type de récupération pour une requête particulière
    // cascade : Cascade attribute is mandatory, when ever we apply relationship
    // between objects, cascade attribute transfers operations done on one object onto its related child objects
    // mappedBy : référence le champ qui porte la relation côté maître
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "weapon")
    @JsonBackReference // evite la récurcivite dans le JSON
    private Set<PoliceCase> policeCase = new HashSet<> ();




}