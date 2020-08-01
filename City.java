import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class City2 extends UnicastRemoteObject implements DataRemote{
    private String name;
    private List<DataInhabitantRemote> inhabitants = new ArrayList<>();


    public City2(String name) throws RemoteException {
        super();
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public List<DataInhabitantRemote> getInhabitants() {
        return inhabitants;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addInhabitant(String name, String dateOfBirth, String maritalStatus) throws RemoteException {
        Inhabitant2 inhabitant= new Inhabitant2(name, dateOfBirth, maritalStatus);
        inhabitants.add(inhabitant);
    }

    @Override
    public DataInhabitantRemote searchForInhabitant(String name) throws RemoteException {
        for (DataInhabitantRemote inhabitant: inhabitants) {
            if (inhabitant.getName().equals(name)) {
                return inhabitant;
            }
        } return null;
    }

    @Override
    public String getNameOfCity() {
        return this.name;
    }



}