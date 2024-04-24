package dao;
import db.Connection;
import entities.LoaiPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LoaiPhongDAO {
    private EntityManager em;

    public LoaiPhongDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public List<LoaiPhong> getListLoaiPhong() {
        TypedQuery<LoaiPhong> query = em.createQuery("SELECT lp FROM LoaiPhong lp", LoaiPhong.class);
        return query.getResultList();
    }

    public boolean addLoaiPhong(LoaiPhong loaiPhong) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(loaiPhong);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean updateLoaiPhong(LoaiPhong loaiPhong) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(loaiPhong);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }
}
