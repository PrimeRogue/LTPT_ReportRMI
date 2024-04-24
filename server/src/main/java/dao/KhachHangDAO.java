package dao;
import db.Connection;
import entities.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class KhachHangDAO {
    private EntityManager em;

    public KhachHangDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public List<KhachHang> getListKH() {
        TypedQuery<KhachHang> query = em.createQuery("SELECT kh FROM KhachHang kh", KhachHang.class);
        return query.getResultList();
    }

    public boolean addKH(KhachHang khachHang) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(khachHang);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean updateKH(KhachHang khachHang) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(khachHang);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }
}
