import GUI.frmMenuMain;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainApplication {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        frmMenuMain frmTC = new frmMenuMain();
        frmTC.setVisible(true);
    }
}
