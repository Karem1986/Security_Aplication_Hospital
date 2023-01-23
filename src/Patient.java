//Nested classes: outer class using an inner class to add more security to the application, also called Encapsulation
public class Patient {
    private int patientIdNumber;
    private String name;
    private long insuranceNmr;
    private static String description; //if the inner class is static, it can only access static members like description.
    String favFood = null;

    Patient(String name, int idNmr, long insNmr, String description, String favFood) {
        this.patientIdNumber = idNmr;
        this.name = name;
        this.insuranceNmr = insNmr;
        this.description = description;
        this.favFood = favFood;

    }
    //inner Class to protect sensitive information: Patient outer class is the only one with access to PatientData class's info.
    class PatientData {
       String favFood = "standard patient meal"; //if patient does not have a fav food, the default is the standard patient meal.
        boolean choosingFavFood = false;
        //method to create patient:
        void createPatientInSystem(){
           System.out.println("Patient has been created in the system with ID number: " + patientIdNumber);
           System.out.println("Patient has been created in the system with name: " + name);
            System.out.println("Patient description: " + description);
           System.out.println("Patient has been created in the system with insurance number: " + insuranceNmr);
            System.out.println("Patient food choice: " + Patient.this.favFood );//Illustrating Shadowing/overlapping: favFood default from outer class
            if(Patient.this.favFood == null) { //If the patient does not have a choice for food, he gets the standard meal.
                System.out.println("Patient food: " + favFood);
            }
        }
    }

    public static void main(String... args) {
        //Instantiate an object of the outer class
        Patient one = new Patient("Robert", 1, 4002567861L, "young male", null);
        //Instantiate an object of the inner class
        Patient.PatientData pdata = one.new PatientData();
        pdata.createPatientInSystem();

        //Patient two
        Patient two = new Patient("Kermit", 2, 300450780, "mature cat", "pizza");
        Patient.PatientData p2data = two.new PatientData();
        p2data.createPatientInSystem();

    }
}
