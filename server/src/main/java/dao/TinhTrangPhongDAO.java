package dao;

import db.Connection;
import entities.Phong;
import entities.TinhTrangPhong;
import entities.TrangThaiPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

public class TinhTrangPhongDAO {
    private EntityManager em;

    public TinhTrangPhongDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public List<TinhTrangPhong> findAll() {
        TypedQuery<TinhTrangPhong> query = em.createQuery("SELECT t FROM TinhTrangPhong t", TinhTrangPhong.class);
        return query.getResultList();
    }

}
