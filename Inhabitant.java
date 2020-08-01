import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Inhabitant2 extends UnicastRemoteObject implements DataInhabitantRemote {


    private String name;
    private String dateOfBirth;
    private String maritalStatus;

    //List<Inhabitant> inhabitants = new ArrayList <Inhabitant>();

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void changeMaritalStatus(String MaritalStatus){
        this.maritalStatus = MaritalStatus;
    }

    public Inhabitant2(String name, String dateOfBirth, String maritalStatus) throws RemoteException {
        super();

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;
    }
}