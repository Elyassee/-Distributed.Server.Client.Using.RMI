import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataInhabitantRemote extends Remote{

    public String getName() throws RemoteException;
    public String getDateOfBirth() throws RemoteException;
    public String getMaritalStatus() throws RemoteException;
    public void changeMaritalStatus(String newMaritalStatus) throws RemoteException;

}
