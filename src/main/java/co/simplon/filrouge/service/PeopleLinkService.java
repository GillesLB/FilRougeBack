package co.simplon.filrouge.service;

import co.simplon.filrouge.dao.PeopleLinkDAO;
import co.simplon.filrouge.dao.VehiculeLinkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleLinkService {

    @Autowired
    private PeopleLinkDAO dao;

    public void deleteLinkPeople(Long idCase, Long idPeople) throws Exception {
        dao.deleteLinkPeople(idCase,idPeople );
    }
}
