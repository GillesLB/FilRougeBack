package co.simplon.filrouge.modele;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
@Table(name = "police_case")
@EntityListeners(AuditingEntityListener.class)
public class PoliceCase implements Serializable {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private StatusCase statusCase;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "event_date" )
    private Date dateEvent;

    @CreationTimestamp
    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "creating_date" )
    private Date dateCreation;

    @UpdateTimestamp
    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "update_date" )
    private Date dateModification;

    //many to many

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "police_case_people",
            joinColumns = { @JoinColumn(name = "police_case_id") },
            inverseJoinColumns = { @JoinColumn(name = "people_id") })
    private Set<People> people = new HashSet<> ();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "police_case_user",
            joinColumns = { @JoinColumn(name = "police_case_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> user = new HashSet<> ();


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "police_case_vehicule",
            joinColumns = { @JoinColumn(name = "police_case_id") },
            inverseJoinColumns = { @JoinColumn(name = "vehicule_id") })
    private Set<Vehicule> vehicule = new HashSet<> ();


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "police_case_photo",
            joinColumns = { @JoinColumn(name = "police_case_id") },
            inverseJoinColumns = { @JoinColumn(name = "photo_id") })
    private Set<Photo> photo = new HashSet<> ();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "police_case_weapon",
            joinColumns = { @JoinColumn(name = "police_case_id") },
            inverseJoinColumns = { @JoinColumn(name = "weapon_id") })
    private Set<Weapon> weapon = new HashSet<> ();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "police_case_piece_of_evidence",
            joinColumns = { @JoinColumn(name = "police_case_id") },
            inverseJoinColumns = { @JoinColumn(name = "piece_of_evidence_id") })
    private Set<PieceOfEvidence> pieceOfEvidence = new HashSet<> ();





    // Constructeurs


}