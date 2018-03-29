package co.simplon.filrouge.modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "vehicule")
@EntityListeners(AuditingEntityListener.class)
public class Vehicule implements Serializable {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @Column
    private String marque;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private String licensePlate;

    @CreationTimestamp
    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "create_date" )
    private Date createDate;

    @UpdateTimestamp
    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "update_date" )


    private Date upDateDate;


   
    @ManyToMany( fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "vehicule" )
    @JsonBackReference // evite la récurcivite dans le JSON
    private Set <PoliceCase> policeCase = new HashSet <> ();



}


