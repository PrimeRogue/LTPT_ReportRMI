package services.impl;
import dao.NhanVienDAO;
import entities.NhanVien;
import services.NhanVienService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NhanVienServiceImpl extends UnicastRemoteObject implements NhanVienService {
    private static final long serialVersionUID = 1L;
    private NhanVienDAO nhanVienDAO;

    public NhanVienServiceImpl() throws RemoteException {
        super();
        this.nhanVienDAO = new NhanVienDAO();
    }
    @Override
    public List<NhanVien> getListNV() throws RemoteException {
        return nhanVienDAO.getListNV();
    }

    @Override
    public boolean addNV(NhanVien nhanVien) throws RemoteException {
        return nhanVienDAO.addNV(nhanVien);
    }

    @Override
    public boolean updateNV(NhanVien nhanVien) throws RemoteException {
        return nhanVienDAO.updateNV(nhanVien);
    }
}
