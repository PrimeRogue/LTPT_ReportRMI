package services.impl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.List;

import dao.PhongDAO;
import entities.NhanVien;
import entities.Phong;
import services.PhongService;

public class PhongServiceImpl extends UnicastRemoteObject implements PhongService {
    private static final long serialVersionUID = 1L;
    private PhongDAO phongDAO;

    public PhongServiceImpl() throws RemoteException {
        super();
        this.phongDAO = new PhongDAO();
    }

    @Override
    public boolean themPhong(Phong phong) throws RemoteException {
        return phongDAO.themPhong(phong);
    }

    @Override
    public boolean capNhatPhong(Phong phong) throws RemoteException {
        return phongDAO.capNhatPhong(phong);
    }

    @Override
    public boolean xoaPhong(int maPhong) throws RemoteException {
        return phongDAO.xoaPhong(maPhong);
    }

    @Override
    public Phong findOne(int maPhong) throws RemoteException {
        return phongDAO.findOne(maPhong);
    }

    @Override
    public List<Phong> getListPhong()  {
        return phongDAO.findAll();
    }

    @Override
    public boolean capNhapTrangThaiPhong(int maPhong, int maTrangThaiPhong) throws RemoteException {
        return phongDAO.capNhapTrangThaiPhong(maPhong, maTrangThaiPhong);
    }

    @Override
    public String getTrangThai(int maPhong) throws RemoteException {
        return phongDAO.getTrangThai(maPhong);
    }
}
