package dao;

import db.Connection;
import entities.TrangThaiPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TrangThaiPhongDAO {
    private EntityManager em;

    public TrangThaiPhongDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public List<TrangThaiPhong> findAll() {
        TypedQuery<TrangThaiPhong> query = em.createQuery("SELECT t FROM TrangThaiPhong t", TrangThaiPhong.class);
        return query.getResultList();
    }

}
