package co.simplon.filrouge.controleur;


import co.simplon.filrouge.modele.Vehicule;
import co.simplon.filrouge.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class VehiculeControleur {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    // Consulter tous les Vehicule
    @GetMapping("/vehicule")
    public List<Vehicule> getAllVehicule() {
        return vehiculeRepository.findAll();
    }

    // Creer un nouveau Vehicule
    @PostMapping("/vehicule")
    public Vehicule createVehicule(@Valid @RequestBody Vehicule vehicule) {
        return vehiculeRepository.save ( vehicule );
    }

    // Consulter un seul Vehicule
    @GetMapping("/vehicule/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable(value = "id") Long vehiculeId) {
        Vehicule vehicule = vehiculeRepository.findOne (vehiculeId);
        if(vehicule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(vehicule);
    }

    // Mise à jour d'un Vehicule
    @PutMapping("/vehicule/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable(value = "id") Long vehiculeId,
                                                  @Valid @RequestBody Vehicule vehiculeDetail) {
        Vehicule vehicule = vehiculeRepository.findOne(vehiculeId);
        if(vehicule == null) {
            return ResponseEntity.notFound().build();
        }
        vehicule.setMarque (vehiculeDetail.getMarque ());

        Vehicule updatedVehicule = vehiculeRepository.save(vehicule);
        return ResponseEntity.ok(updatedVehicule);
    }


    // Efface un Vehicule
    @DeleteMapping("/vehicule/{id}")
    public ResponseEntity<Vehicule> deleteVehicule(@PathVariable(value = "id") Long vehiculeId) {
        Vehicule vehicule = vehiculeRepository.findOne(vehiculeId);
        if(vehicule == null) {
            return ResponseEntity.notFound().build();
        }

        vehiculeRepository.delete(vehicule);
        return ResponseEntity.ok().build();
    }


}