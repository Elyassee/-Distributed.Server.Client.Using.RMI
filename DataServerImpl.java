import java.rmi.*;
import java.rmi.server.*;
import java.util.List;

public class DataServerImpl {

        public static void main (String[] args) {

            try {
                City2 dataCityServer = new City2 ("Frankfurt");
                City2 dataCityServer2 = new City2("Berlin");
                Naming.rebind ("DataRemote1", dataCityServer);
                Naming.rebind ("DataRemote2", dataCityServer2);
                System.out.println("The server is up");

            } catch (Exception e) {
                System.out.println("DataServerImpl: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }