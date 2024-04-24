package services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.List;

import entities.Phong;

public interface PhongService extends Remote {

    public boolean themPhong(Phong phong) throws RemoteException;

    public boolean capNhatPhong(Phong phong) throws RemoteException;

    public boolean xoaPhong(int maPhong) throws RemoteException;

    public Phong findOne(int maPhong) throws RemoteException;

    public List<Phong> getListPhong() throws RemoteException;

    public boolean capNhapTrangThaiPhong(int maPhong, int maTrangThaiPhong) throws RemoteException;

    public String getTrangThai(int maPhong) throws RemoteException;
}
