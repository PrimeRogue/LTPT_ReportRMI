package dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.Connection;
import entities.TrangThaiPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import entities.Phong;

public class PhongDAO {
    private EntityManager em;

    public PhongDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    @Transactional
    public boolean themPhong(Phong phong) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(phong);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    @Transactional
    public boolean capNhatPhong(Phong phong) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(phong);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    @Transactional
    public boolean xoaPhong(int maPhong) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Phong phong = em.find(Phong.class, maPhong);
            if (phong != null) {
                em.remove(phong);
                tr.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public Phong findOne(int maPhong) {
        return em.find(Phong.class, maPhong);
    }

    public List<Phong> findAll() {
        TypedQuery<Phong> query = em.createQuery("SELECT p FROM Phong p", Phong.class);
        return query.getResultList();
    }

    @Transactional
    public boolean capNhapTrangThaiPhong(int maPhong, int maTrangThaiPhong) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Phong phong = em.find(Phong.class, maPhong);
            if (phong != null) {
                phong.setTrangThaiPhong(findTrangThaiPhongById(maTrangThaiPhong));
                em.merge(phong);
                tr.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public String getTrangThai(int maPhong) {
        Phong phong = em.find(Phong.class, maPhong);
        if (phong != null && phong.getTrangThaiPhong() != null) {
            return phong.getTrangThaiPhong().getTrangThai(); // Assuming TenTrangThai is the name of the state
        }
        return null;
    }

    private TrangThaiPhong findTrangThaiPhongById(int maTrangThaiPhong) {
        // Assuming TrangThaiPhong is an entity with an appropriate findById method
        return em.find(TrangThaiPhong.class, maTrangThaiPhong);
    }
}
