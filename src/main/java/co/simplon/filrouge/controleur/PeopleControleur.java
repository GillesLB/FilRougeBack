package co.simplon.filrouge.controleur;


import co.simplon.filrouge.modele.People;
import co.simplon.filrouge.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PeopleControleur {

    @Autowired
    private PeopleRepository peopleRepository;

    // Consulter tous les People
    @GetMapping("/people")
    public List<People> getAllPeople() {
        return peopleRepository.findAll();
    }

    // Creer un nouveau People
    @PostMapping("/people")
    public People createPeople(@Valid @RequestBody People people) {
        return peopleRepository.save ( people );
    }

    // Consulter un seul People
    @GetMapping("/people/{id}")
    public ResponseEntity<People> getPeopleById(@PathVariable(value = "id") Long peopleId) {
        People people = peopleRepository.findOne (peopleId);
        if(people == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(people);
    }

    // Mise à jour d'un People
    @PutMapping("/people/{id}")
    public ResponseEntity<People> updatePeople(@PathVariable(value = "id") Long peopleId,
                                                  @Valid @RequestBody People peopleDetail) {
        People people = peopleRepository.findOne(peopleId);
        if(people == null) {
            return ResponseEntity.notFound().build();
        }
        people.setFirstName (peopleDetail.getFirstName ());
        people.setLastName (peopleDetail.getLastName ());
        people.setNickName (peopleDetail.getNickName ());
        people.setAdress (peopleDetail.getAdress ());
        people.setCity (peopleDetail.getCity ());
        people.setCountry (peopleDetail.getCountry ());
        people.setPostalZip (peopleDetail.getPostalZip ());
        people.setEyeColor (peopleDetail.getEyeColor ());
        people.setDna (peopleDetail.getDna ());
        people.setFingerPrint (peopleDetail.getFingerPrint ());
        people.setHairColor (peopleDetail.getHairColor ());
        people.setPoliceCase (people.getPoliceCase());

        People updatedPeople = peopleRepository.save(people);
        return ResponseEntity.ok(updatedPeople);
    }


    // Efface un People
    @DeleteMapping("/people/{id}")
    public ResponseEntity<People> deletePeople(@PathVariable(value = "id") Long peopleId) {
        People people = peopleRepository.findOne(peopleId);
        if(people == null) {
            return ResponseEntity.notFound().build();
        }

        peopleRepository.delete(people);
        return ResponseEntity.ok().build();
    }
}