package services.impl;

import dao.LoaiPhongDAO;
import entities.LoaiPhong;
import services.LoaiPhongService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.LinkedHashMap;

public class LoaiPhongServiceImpl extends UnicastRemoteObject implements LoaiPhongService {
    private static final long serialVersionUID = 1L;
    private LoaiPhongDAO loaiPhongDAO;

    public LoaiPhongServiceImpl() throws RemoteException {
        super();
        this.loaiPhongDAO = new LoaiPhongDAO();
    }

    @Override
    public List<LoaiPhong> getListLoaiPhong() {
        return loaiPhongDAO.getListLoaiPhong();
    }

    @Override
    public boolean addLoaiPhong(LoaiPhong loaiPhong) throws RemoteException {
        return loaiPhongDAO.addLoaiPhong(loaiPhong);
    }

    @Override
    public boolean updateLoaiPhong(LoaiPhong loaiPhong) throws RemoteException {
        return loaiPhongDAO.updateLoaiPhong(loaiPhong);
    }
}

