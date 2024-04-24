package services.impl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.KhachHangDAO;
import entities.KhachHang;
import services.KhachHangService;

public class KhachHangServiceImpl extends UnicastRemoteObject implements KhachHangService {
    private KhachHangDAO khachHangDAO;

    public KhachHangServiceImpl() throws RemoteException {
        super();
        this.khachHangDAO = new KhachHangDAO();
    }

    @Override
    public List<KhachHang> getListKH() {
        return khachHangDAO.getListKH();
    }

    @Override
    public boolean themKhachHang(KhachHang khachHang) throws RemoteException {
        return khachHangDAO.addKH(khachHang);
    }

    @Override
    public boolean capNhatKhachHang(KhachHang khachHang) throws RemoteException {
        return khachHangDAO.updateKH(khachHang);
    }
}
