package co.simplon.filrouge.repository;

import co.simplon.filrouge.modele.PoliceCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CaseByPieceJDBC {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private DataSource datasource;
    private EntityManager em;
    private Long pieceId;


    public PoliceCase getCaseByPiece(Long pieceId) {

        TypedQuery<PoliceCase> query = em.createQuery(
                "SELECT c.id\n" +
                        "FROM piece_of_evidence AS p\n" +
                        "LEFT JOIN police_case_piece_of_evidence AS cp ON cp.piece_of_evidence  = p.id \n" +
                        "LEFT JOIN police_case AS c ON cp.police_case_id  = c.id \n" +
                        "WHERE p.id = ?", PoliceCase.class);
        System.out.println("test : " +query.setParameter(1, 1).getSingleResult());
        return query.setParameter(1, pieceId).getSingleResult();
    }
}