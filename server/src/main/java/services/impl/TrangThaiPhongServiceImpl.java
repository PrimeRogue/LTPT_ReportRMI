package services.impl;

import dao.TrangThaiPhongDAO;
import entities.TrangThaiPhong;
import services.TrangThaiPhongService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TrangThaiPhongServiceImpl extends UnicastRemoteObject implements TrangThaiPhongService {
    private static final long serialVersionUID = 1L;
    private TrangThaiPhongDAO trangThaiPhongDAO;

    public TrangThaiPhongServiceImpl() throws RemoteException {
        super();
        this.trangThaiPhongDAO = new TrangThaiPhongDAO();
    }

    @Override
    public List<TrangThaiPhong> findAll() throws RemoteException {
        return trangThaiPhongDAO.findAll();
    }
}
