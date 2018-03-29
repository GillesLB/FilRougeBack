package co.simplon.filrouge.service;

import co.simplon.filrouge.dao.VehiculeLinkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculeLinkService {

    @Autowired
    private VehiculeLinkDAO dao;

    public void deleteLinkVehicule(Long idCase, Long idVehicule) throws Exception {
        dao.deleteLinkVehicule(idCase, idVehicule);
    }
}
