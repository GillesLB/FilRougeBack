package co.simplon.filrouge.repository;

import co.simplon.filrouge.dao.PeopleLinkDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class JdbcPeopleDAO implements PeopleLinkDAO {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private DataSource datasource;


    @Autowired
    public JdbcPeopleDAO(JdbcTemplate jdbcTemplate) {
        this.datasource = jdbcTemplate.getDataSource();
    }

    @Override
    public void deleteLinkPeople(Long idCase, Long idPeople) throws Exception {

        String sql = "DELETE FROM police_case_people WHERE police_case_id = ? AND people_id = ?";

        try (Connection connection = this.datasource.getConnection()) {

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                try {
                    pstmt.setLong(1, idCase);
                    pstmt.setLong(2, idPeople);

                    // Log info
                    logSQL(pstmt);

                    // Run the the update query
                    int result = pstmt.executeUpdate();
                    if (result != 1) {
                        throw new Exception("id not found !");
                    }
                } catch (SQLException e) {
                    LoggerFactory.getLogger("SQL Error !:" + pstmt.toString() + e);
                    throw e;

                }
            }

        }
    }

    private void logSQL(PreparedStatement pstmt) {
        String sql;

        if (pstmt == null)
            return;

        sql = pstmt.toString().substring(pstmt.toString().indexOf(':') + 2);
        log.debug(sql);
    }


}

