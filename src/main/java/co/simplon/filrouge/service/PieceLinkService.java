package co.simplon.filrouge.service;

import co.simplon.filrouge.dao.PieceLinkDAO;
import co.simplon.filrouge.dao.WeaponLinkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PieceLinkService {

    @Autowired
    private PieceLinkDAO dao;

    public void deleteLinkPiece(Long idCase, Long idPiece) throws Exception {
        dao.deleteLinkPiece(idCase,idPiece );
    }
}
