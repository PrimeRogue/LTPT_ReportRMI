package services;
import entities.LoaiPhong;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LoaiPhongService extends Remote {
    List<LoaiPhong> getListLoaiPhong() throws RemoteException;
    boolean addLoaiPhong(LoaiPhong loaiPhong) throws RemoteException;
    boolean updateLoaiPhong(LoaiPhong loaiPhong) throws RemoteException;
}
