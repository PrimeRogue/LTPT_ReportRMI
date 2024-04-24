package dao;
import db.Connection;
import entities.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TaiKhoanDAO {
    private EntityManager em;

    public TaiKhoanDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public List<TaiKhoan> getListNV() {
        TypedQuery<TaiKhoan> query = em.createQuery("SELECT nv FROM TaiKhoan nv", TaiKhoan.class);
        return query.getResultList();
    }

    public boolean addNV(TaiKhoan taiKhoan) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(taiKhoan);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean updateNV(TaiKhoan taiKhoan) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(taiKhoan);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }
}
