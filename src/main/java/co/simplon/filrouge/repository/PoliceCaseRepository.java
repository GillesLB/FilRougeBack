package co.simplon.filrouge.repository;

import co.simplon.filrouge.modele.PoliceCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliceCaseRepository extends JpaRepository<PoliceCase, Long>, JpaSpecificationExecutor<PoliceCase> {}
