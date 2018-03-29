package co.simplon.filrouge.controleur;


import co.simplon.filrouge.modele.PoliceCase;
import co.simplon.filrouge.repository.PoliceCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PoliceCaseControleur {

    @Autowired
    private PoliceCaseRepository policeCaseRepository;

    // Consulter toutes les PoliceCase
    @GetMapping("/case")
    public List<PoliceCase> getAllPoliceCase() {
        return policeCaseRepository.findAll();
    }

    // Creer une nouvelle PoliceCase
    @PostMapping("/case")
    public PoliceCase createPoliceCase(@Valid @RequestBody PoliceCase policeCase) {
        return policeCaseRepository.save ( policeCase );
    }

    // Consulter une seule PoliceCase
    @GetMapping("/case/{id}")
    public ResponseEntity<PoliceCase> getPoliceCaseById(@PathVariable(value = "id") Long policeCaseId) {
        PoliceCase policeCase = policeCaseRepository.findOne (policeCaseId);
        if(policeCase == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(policeCase);
    }

    // Mise à jour d'une PoliceCase
    @PutMapping("/case/{id}")
    public ResponseEntity<PoliceCase> updatePoliceCase(@PathVariable(value = "id") Long policeCaseId,
                                                  @Valid @RequestBody PoliceCase policeCaseDetail) {
        PoliceCase policeCase = policeCaseRepository.findOne(policeCaseId);
        if(policeCase == null) {
            return ResponseEntity.notFound().build();
        }
        policeCase.setName (policeCaseDetail.getName ());
        policeCase.setDescription (policeCaseDetail.getDescription ());

        PoliceCase updatedAffaire = policeCaseRepository.save(policeCase);
        return ResponseEntity.ok(updatedAffaire);
    }


    // Efface une PoliceCase
    @DeleteMapping("/case/{id}")
    public ResponseEntity<PoliceCase> deletePoliceCase(@PathVariable(value = "id") Long policeCaseId) {
        PoliceCase policeCase = policeCaseRepository.findOne(policeCaseId);
        if(policeCase == null) {
            return ResponseEntity.notFound().build();
        }

        policeCaseRepository.delete(policeCase);
        return ResponseEntity.ok().build();
    }
}