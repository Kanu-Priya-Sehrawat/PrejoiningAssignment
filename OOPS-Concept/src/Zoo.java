import beans.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zoo {

    private static Map<Integer, Animal> idToAnimalMap = new HashMap<>();

    public static Integer globalId = 0;

    public static void main(String[] args) {
        loadDetails();
        int a;
        do {
            System.out.println("Welcome to the Zoo!");
            System.out.println("Choose from the options : ");
            System.out.println("1. Enter data for an animal ");
            System.out.println("2. Enter id to see details for an animal ");
            System.out.println("3. Show details for all animals ");
            System.out.println("4. Exit ");
            Scanner sc = new Scanner(System.in);
            a = sc.nextInt();
            switch (a) {
                case 1:
                    Animal animal = getAnimal();
                    System.out.println("1. To enter donor details");
                    System.out.println("2. To skip donor details");
                    int op = sc.nextInt();
                    if (op == 1) {
                        Donor donor = getDonor();
                        animal.setDonor(donor);
                    }
                    idToAnimalMap.put(animal.getId(), animal);
                    System.out.println("Id for the animal is : " + animal.getId());
                    break;
                case 2:
                    System.out.println("Enter animal id : ");
                    int id = sc.nextInt();
                    printAnimalDetails(id);
                    break;
                case 3:
                    System.out.println("Details for all animals ");
                    for (Integer key : idToAnimalMap.keySet()) {
                        printAnimalDetails(key);
                    }
            }
        } while (a != 4);


        System.out.println("Goodbye.");
    }

    public static Animal getAnimal() {
        System.out.println(" Enter animal type :");
        Scanner sc = new Scanner(System.in);
        String type = sc.next();
        Animal animal = null;
        if (type.equalsIgnoreCase(Constants.DOG)) {
            animal = new Dog();
        } else if (type.equalsIgnoreCase(Constants.CAT)) {
            animal = new Cat();
        } else if (type.equalsIgnoreCase(Constants.RAT)) {
            animal = new Rat();
        } else if (type.equalsIgnoreCase(Constants.PARROT)) {
            animal = new Parrot();
        } else if (type.equalsIgnoreCase(Constants.PEACOCK)) {
            animal = new Peacock();
        }
        System.out.println(" Enter name :");
        String name = sc.next();
        animal.setName(name);
        System.out.println(" Enter cage number :");
        int cageNumber = sc.nextInt();
        animal.setId(globalId);
        globalId++;
        animal.setCageNumber(cageNumber);
        return animal;
    }
    public static Donor getDonor() {
        Donor donor = new Donor();
        System.out.println(" Enter donor details :");
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Enter donor's name ");
        String name = sc.next();
        System.out.println("2. Enter donor's address ");
        String address = sc.next();
        System.out.println("3. Enter donor's mobile number ");
        String mobileNumber = sc.next();
        donor.setName(name);
        donor.setAddress(address);
        donor.setMobileNumber(mobileNumber);
        return donor;
    }

    public static void printAnimalDetails(Integer id) {
        if (!idToAnimalMap.containsKey(id)) {
            System.out.println("Invalid id.");
        } else {
            Animal animal = idToAnimalMap.get(id);
            System.out.println("Id : " + animal.getId());
            System.out.println("Name : " + animal.getName());
            System.out.println("Sound : " + animal.getSound());
            System.out.println("CageNumber : " + animal.getCageNumber());
            System.out.println("Type : " + animal.getType());
            if (animal.getDonor() != null) {
                printDonorDetails(animal.getDonor());
            }
        }
    }

    public static void printDonorDetails(Donor donor) {
        System.out.println("Donor name : " + donor.getName());
        System.out.println("Donor address : " + donor.getAddress());
        System.out.println("Donor mobile number : " + donor.getMobileNumber());
    }

    public static void loadDetails(){
        Donor d1 = new Donor("Kanu", "Roorkee","123");
        Donor d2 = new Donor("Tanu", "Roorkee","456");
        Animal a1 = new Cat(globalId++,"Lucy",d1,4);
        Animal a2 = new Dog(globalId++,"Rocky",d1,5);
        Animal a3 = new Parrot(globalId++,"Jack",d2,6);
        Animal a4 = new Peacock(globalId++,"Jill",null,7);
        idToAnimalMap.put(a1.getId(), a1);
        idToAnimalMap.put(a2.getId(), a2);
        idToAnimalMap.put(a3.getId(), a3);
        idToAnimalMap.put(a4.getId(), a4);
    }
}