package co.simplon.filrouge.controleur;


import co.simplon.filrouge.modele.User;
import co.simplon.filrouge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserControleur {

    @Autowired
    private UserRepository userRepository;

    // Consulter tous les User
    @GetMapping("/user")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    // Creer un nouveau User
    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save ( user );
    }

    // Consulter un seul User
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findOne (userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    // Mise à jour d'un User
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                                  @Valid @RequestBody User userDetail) {
        User user = userRepository.findOne(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setFirstName (userDetail.getFirstName ());
        user.setLastName (user.getLastName ());

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }


    // Efface un User
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findOne(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}