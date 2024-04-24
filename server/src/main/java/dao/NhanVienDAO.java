package dao;
import db.Connection;
import entities.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class NhanVienDAO {
    private EntityManager em;

    public NhanVienDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public List<NhanVien> getListNV() {
        TypedQuery<NhanVien> query = em.createQuery("SELECT nv FROM NhanVien nv", NhanVien.class);
        return query.getResultList();
    }

    public boolean addNV(NhanVien nhanVien) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(nhanVien);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean updateNV(NhanVien nhanVien) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(nhanVien);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }
}
