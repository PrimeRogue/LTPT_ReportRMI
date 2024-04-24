package rmi;
import java.rmi.Naming;
public class RMIClient {

    private static final String SERVER_URL = "rmi://DESKTOP-O9GK1BR:8989/";
    private RMIClient() {
    }

    public static <T> T lookup(String serviceName, Class<T> clazz) {
        try {
            return clazz.cast(Naming.lookup(SERVER_URL + serviceName));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
