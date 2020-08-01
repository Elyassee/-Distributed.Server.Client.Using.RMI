import org.omg.CORBA.PUBLIC_MEMBER;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DataRemote extends Remote{


        public DataInhabitantRemote searchForInhabitant(String name)throws RemoteException;
        public void addInhabitant(String name, String dateOfBirth, String maritalStatus) throws RemoteException;
        public List<DataInhabitantRemote> getInhabitants() throws RemoteException;
        public String getNameOfCity() throws RemoteException;

    }
