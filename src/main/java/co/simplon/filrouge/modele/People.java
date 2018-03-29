package co.simplon.filrouge.modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
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
@Table(name = "people")
@EntityListeners(AuditingEntityListener.class)
public class People implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String nickName;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String region;

    @Column
    @Pattern(regexp = "^[0-9]{5}$")
    private String postalZip;

    @Column
    private String adress;

    @Column
    private String tatoo;

    @Column
    private String skinColor;

    @Column
    private String eyeColor;

    @Column
    private String hairColor;

    @Column
    private String hairStyle;

    @Column
    private double size;

    @Column
    private double weight;

    @Column
    private String comment;

    @Column
    private String dna;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Status status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date uptdateDate;

    //création de la table de jointure pour Many to Many entre PoliceCase et people
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "people")
    @JsonBackReference // evite la récurcivite dans le JSON
    private Set<PoliceCase> policeCase = new HashSet<> ();

    //création de la table de jointure pour One to Many entre People et FingerPrint

    @OneToMany(fetch = FetchType.EAGER,mappedBy="people",cascade = CascadeType.ALL)
    private Set<FingerPrint> fingerPrint;






}