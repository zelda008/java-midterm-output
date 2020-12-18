import java.util.*;

public class PatientLIst {

    //AddEntry 
    public static void Add(ArrayList<PatientInfo> patientData){
        Scanner scanner = new Scanner(System.in);
        PatientInfo patientInfo = new PatientInfo(null,null);
        System.out.print("Enter name: ");
        patientInfo.setName(scanner.next());
        System.out.print("Enter age: ");
        patientInfo.setAge(scanner.next());

        patientData.add(patientInfo);

        System.out.println("Would you like to add again?");
        System.out.println("Press 1 to add. Press 0 to go back to Menu.");
        int option = scanner.nextInt();
        switch(option){
            case 1:
                Add(patientData);
            case 0:
                Menu(patientData);
        }

        Menu(patientData);
    }

    //Remove
    public static void Remove(ArrayList<PatientInfo> patientData){
        Scanner input = new Scanner(System.in);
        int i = 0;
        for (PatientInfo patient : patientData ){
            System.out.println(i+1 + ". ");
            System.out.println(patient.getName() + " is " + patient.getAge());
            //System.out.println("Name: " + patient.getName());
            //System.out.println("Age: " + patient.getAge());
            System.out.println();
            i++;
        }
        
        System.out.println("Enter number to delete: ");
        int position = input.nextInt();

        patientData.remove(position - 1);

        Menu(patientData);

    }

    //View
    public static void View(ArrayList<PatientInfo> patientData){
        int i = 0;
        for(PatientInfo patient : patientData){
            System.out.print(i+1 + ".");
            System.out.println(patient.getName() + " is " + patient.getAge());
            //System.out.println("Name: " + patient.getName());
            //System.out.println("Age: " + patient.getAge());
            i++;

            }

            System.out.println();

            Menu(patientData);
        }

    //Update
    public static void Update(ArrayList<PatientInfo> patientData){
        Scanner input = new Scanner(System.in);

        int i = 0;
        for(PatientInfo patient : patientData){
            System.out.println(i+1 + ". ");
            System.out.println("Name: " + patient.getName());
            System.out.println("Age: " + patient.getAge());
            i++;
        }

        System.out.println("Enter number to update: ");
        int index = input.nextInt() - 1;
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("What will you update?");
        int update = input.nextInt();
        switch(update){
            case 1:
            System.out.println("Enter new name: ");
            patientData.get(index).setName(input.next());
            break;
            case 2:
            System.out.println("Enter new age: ");
            patientData.get(index).setAge(input.next());
            break;

        }
        
        Menu(patientData);
    }



    public static void main(String[] args) {
        ArrayList<PatientInfo> patientData = new ArrayList<PatientInfo>(1000);
        Menu(patientData);
        
    }

    public static void Menu(ArrayList<PatientInfo> patientData){
        Scanner scanner = new Scanner(System.in);
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. View");
            System.out.println("4. Update");
            System.out.println("5. Exit");
            System.out.println("Select Option: ");
            int option = scanner.nextInt();
            switch(option){
                case 1:
                    Add(patientData);
                    break;
                case 2:
                    Remove(patientData);
                    break;
                case 3:
                    View(patientData);
                    break;
                case 4:
                    Update(patientData);
                    break;
                case 5:
                    System.out.print("Exiting...");
                    Runtime.getRuntime().exit(0);

            }

        }
    }


class PatientInfo{
    private String name;
    private String age;

    public PatientInfo(String name, String age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge(){
        return age;
    }

    public void setAge(String age){
        this.age = age;
    }
}
