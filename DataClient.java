import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class DataClient {
    public static void main (String[] args) throws Exception {
        if (args.length != 1)
            throw new IllegalArgumentException ("Syntax: DataClient <hostname>");

        try {
            DataRemote dataServer = (DataRemote) Naming.lookup("rmi://" + args[0] + "/DataRemote1");
            DataRemote dataServer2 = (DataRemote) Naming.lookup("rmi://" + args[0] + "/DataRemote2");
            Scanner scanner = new Scanner(System.in);

                int choice;
                System.out.println("*****press '1' to fill Frankfurt City*****\n" +
                        "*****Press '2' to fill Berlin City*****\n");
                choice = scanner.nextInt();

            while(true) {


                int input;
                System.out.println("**** press '1' to add an inhabitant **** \n **** press '2' to get data of all inhabitants ****" +
                        "\n **** press '3' to search for an inhabitant **** \n **** press '4' to change data of inhabitant ****" +
                        "\n**** press '5' to get the name of the city ****" + "\n **** press '0' to exit ****");
                input = scanner.nextInt();

                    if (choice==1) {

                        if (input == 1) {
                            System.out.println("Enter the name: ");
                            String name = scanner.next();
                            System.out.println("Enter the Date of birth: ");
                            String dateOfBirth = scanner.next();
                            System.out.println("Enter the Marital status: ");
                            String maritalStatus = scanner.next();
                            dataServer.addInhabitant(name, dateOfBirth, maritalStatus);
                        }

                        if (input == 2) {
                            List<DataInhabitantRemote> inhabitants;
                            inhabitants = dataServer.getInhabitants();
                            int counter1 = 1;
                            int counter2 = 0;
                            System.out.println("\nList of all inhabitants: \n");
                            for (DataInhabitantRemote inhabitant : inhabitants) {
                                System.out.println(counter1 + ": " + inhabitant.getName()
                                        + " " + inhabitant.getDateOfBirth()
                                        + " " + inhabitant.getMaritalStatus() +
                                        "\n*************************");
                                counter1++;
                                if(!inhabitant.getMaritalStatus().equals("married")){
                                    counter2++;
                                }

                            }

                            System.out.println("The number of all unmarried inhabitants is:" + counter2);
                            System.out.println("\n");
                        }

                        if (input == 3) {
                            DataInhabitantRemote inhabitant;
                            System.out.println("Enter the name of inhabitant");
                            String name = scanner.next();
                            if ((dataServer.searchForInhabitant(name) != null)) {
                                inhabitant = dataServer.searchForInhabitant(name);
                                System.out.println("*************************\n" + "Name: " + inhabitant.getName() +
                                        "\nDate of Birth: " + inhabitant.getDateOfBirth() +
                                        "\nMarital Status: " + inhabitant.getMaritalStatus() +
                                        "\n*************************" + "\n");
                            } else {
                                System.out.println("Inhabitant not found!\n");
                            }
                        }

                        if (input == 4) {
                            DataInhabitantRemote inhabitant;
                            System.out.println("Enter the name of inhabitant");
                            String name = scanner.next();
                            if ((dataServer.searchForInhabitant(name) != null)) {
                                inhabitant = dataServer.searchForInhabitant(name);
                                System.out.println("Enter the new marital Status: ");
                                String NewMaritalStatus = scanner.next();
                                inhabitant.changeMaritalStatus(NewMaritalStatus);
                                System.out.println("The marital status changed to: " + NewMaritalStatus + "!\n");

                            } else {
                                System.out.println("Inhabitant not found!\n");
                            }
                        }

                        if (input == 5) {
                            System.out.println("The city is: " + dataServer.getNameOfCity() + "\n");
                        }

                        if (input == 0) {
                            break;
                        }

                    }


                    if(choice ==2){

                        if (input == 1) {
                            System.out.println("Enter the name: ");
                            String name = scanner.next();
                            System.out.println("Enter the Date of birth: ");
                            String dateOfBirth = scanner.next();
                            System.out.println("Enter the Marital status: ");
                            String maritalStatus = scanner.next();
                            dataServer2.addInhabitant(name, dateOfBirth, maritalStatus);
                        }

                        if (input == 2) {
                            List<DataInhabitantRemote> inhabitants;
                            inhabitants = dataServer2.getInhabitants();
                            int count = 1;
                            System.out.println("\nList of all inhabitants: \n");
                            for (DataInhabitantRemote inhabitant : inhabitants) {
                                System.out.println(count + ": " + inhabitant.getName()
                                        + " " + inhabitant.getDateOfBirth()
                                        + " " + inhabitant.getMaritalStatus() +
                                        "\n*************************");
                                count++;
                            }
                            System.out.println("\n");
                        }

                        if (input == 3) {
                            DataInhabitantRemote inhabitant;
                            System.out.println("Enter the name of inhabitant");
                            String name = scanner.next();
                            if ((dataServer2.searchForInhabitant(name) != null)) {
                                inhabitant = dataServer2.searchForInhabitant(name);
                                System.out.println("*************************\n" + "Name: " + inhabitant.getName() +
                                        "\nDate of Birth: " + inhabitant.getDateOfBirth() +
                                        "\nMarital Status: " + inhabitant.getMaritalStatus() +
                                        "\n*************************" + "\n");
                            } else {
                                System.out.println("Inhabitant not found!\n");
                            }
                        }

                        if (input == 4) {
                            DataInhabitantRemote inhabitant;
                            System.out.println("Enter the name of inhabitant");
                            String name = scanner.next();
                            if ((dataServer2.searchForInhabitant(name) != null)) {
                                inhabitant = dataServer2.searchForInhabitant(name);
                                System.out.println("Enter the new marital Status: ");
                                String NewMaritalStatus = scanner.next();
                                inhabitant.changeMaritalStatus(NewMaritalStatus);
                                System.out.println("The marital status changed to: " + NewMaritalStatus + "!\n");

                            } else {
                                System.out.println("Inhabitant not found!\n");
                            }
                        }

                        if (input == 5) {
                            System.out.println("The city is: " + dataServer2.getNameOfCity() + "\n");
                        }

                        if (input == 0) {
                            break;
                        }


                    }
            }


        } catch (Exception e) {
            System.out.println("DataClient: " + e.getMessage());
            e.printStackTrace();
        }

    }
}