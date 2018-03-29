package co.simplon.filrouge.controleur;



import co.simplon.filrouge.modele.Photo;
import co.simplon.filrouge.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PhotoControleur {

    @Autowired
    private PhotoRepository photoRepository;

    // Consulter toutes les Photo
    @GetMapping("/photo")
    public List<Photo> getAllPhoto() {
        return photoRepository.findAll();
    }

    // Creer une nouvelle Photo
    @PostMapping("/photo")
    public Photo createPhoto(@Valid @RequestBody Photo photo) {
        return photoRepository.save ( photo );
    }

    // Consulter une seule Photo
    @GetMapping("/photo/{id}")
    public ResponseEntity<Photo> getPhotoById(@PathVariable(value = "id") Long photoId) {
        Photo photo = photoRepository.findOne (photoId);
        if(photo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(photo);
    }

    // Mise à jour d'une Photo
    @PutMapping("/photo/{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable(value = "id") Long photoId,
                                                  @Valid @RequestBody Photo photoDetail) {
        Photo photo = photoRepository.findOne(photoId);
        if(photo == null) {
            return ResponseEntity.notFound().build();
        }
        photo.setBig (photoDetail.getBig ());
        photo.setMedium (photoDetail.getMedium ());
        photo.setSmall (photoDetail.getSmall ());
        photo.setPoliceCase(photo.getPoliceCase());

        Photo updatedPhoto = photoRepository.save(photo);
        return ResponseEntity.ok(updatedPhoto);
    }


    // Efface une Photo
    @DeleteMapping("/photo/{id}")
    public ResponseEntity<Photo> deletePhoto(@PathVariable(value = "id") Long photoId) {
        Photo photo = photoRepository.findOne(photoId);
        if(photo == null) {
            return ResponseEntity.notFound().build();
        }

        photoRepository.delete(photo);
        return ResponseEntity.ok().build();
    }
}