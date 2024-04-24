package services.impl;

import dao.TaiKhoanDAO;
import entities.TaiKhoan;
import services.TaiKhoanService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TaiKhoanServiceImpl extends UnicastRemoteObject implements TaiKhoanService {
    private static final long serialVersionUID = 1L;
    private TaiKhoanDAO taiKhoanDAO;

    public TaiKhoanServiceImpl() throws RemoteException {
        super();
        this.taiKhoanDAO = new TaiKhoanDAO();
    }

    @Override
    public List<TaiKhoan> getListNV() throws RemoteException {
        return taiKhoanDAO.getListNV();
    }

    @Override
    public boolean addNV(TaiKhoan taiKhoan) throws RemoteException {
        return taiKhoanDAO.addNV(taiKhoan);
    }

    @Override
    public boolean updateNV(TaiKhoan taiKhoan) throws RemoteException {
        return taiKhoanDAO.updateNV(taiKhoan);
    }
}
