package services.impl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.List;

import dao.TinhTrangPhongDAO;
import entities.TaiKhoan;
import entities.TinhTrangPhong;
import services.TinhTrangPhongService;

public class TinhTrangPhongServiceImpl extends UnicastRemoteObject implements TinhTrangPhongService {

    private static final long serialVersionUID = 1L;
    private TinhTrangPhongDAO tinhTrangPhongDAO;

    public TinhTrangPhongServiceImpl() throws RemoteException {
        super();
        this.tinhTrangPhongDAO = new TinhTrangPhongDAO();
    }
    @Override
    public List<TinhTrangPhong> getListTTP() throws RemoteException {
        return tinhTrangPhongDAO.findAll();
    }
}
