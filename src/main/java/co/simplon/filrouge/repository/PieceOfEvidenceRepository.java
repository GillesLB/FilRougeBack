package co.simplon.filrouge.repository;

import co.simplon.filrouge.modele.PieceOfEvidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PieceOfEvidenceRepository extends JpaRepository<PieceOfEvidence, Long>, JpaSpecificationExecutor<PieceOfEvidence> {


}
