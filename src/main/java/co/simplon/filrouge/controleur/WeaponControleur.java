package co.simplon.filrouge.controleur;



import co.simplon.filrouge.modele.Weapon;
import co.simplon.filrouge.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class WeaponControleur {

    @Autowired
    WeaponRepository weaponRepository;

    // Consulter toutes les Weapon
    @GetMapping("/weapon")
    public List<Weapon> getAllWeapon() {
        return weaponRepository.findAll();
    }

    // Creer une nouvelle Weapon
    @PostMapping("/weapon")
    public Weapon createWeapon(@Valid @RequestBody Weapon weapon) {
        return weaponRepository.save ( weapon );
    }

    // Consulter une seule Weapon
    @GetMapping("/weapon/{id}")
    public ResponseEntity<Weapon> getWeaponById(@PathVariable(value = "id") Long weaponId) {
        Weapon weapon = weaponRepository.findOne (weaponId);
        if(weapon == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(weapon);
    }

    // Mise à jour d'une Weapon
    @PutMapping("/weapon/{id}")
    public ResponseEntity<Weapon> updateWeapon(@PathVariable(value = "id") Long weaponId,
                                                  @Valid @RequestBody Weapon weaponDetail) {
        Weapon weapon = weaponRepository.findOne(weaponId);
        if(weapon == null) {
            return ResponseEntity.notFound().build();
        }
        weapon.setModele (weaponDetail.getModele ());
        weapon.setType       (weaponDetail.getType());

        Weapon updateWeapon = weaponRepository.save(weapon);
        return ResponseEntity.ok(updateWeapon);
    }


    // Efface une Weapon
    @DeleteMapping("/weapon/{id}")
    public ResponseEntity<Weapon> deleteWeapon(@PathVariable(value = "id") Long weaponId) {
        Weapon weapon = weaponRepository.findOne(weaponId);
        if(weapon == null) {
            return ResponseEntity.notFound().build();
        }

        weaponRepository.delete(weapon);
        return ResponseEntity.ok().build();
    }
}