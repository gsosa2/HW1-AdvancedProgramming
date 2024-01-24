/**Class: Advanced Programming
 * @author Gabe Sosa
 * @version 1.0
 * Course: ITEC 3150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class hold the main code for displaying,finding,deleting, and adding new pets.
 */

import java.io.*;
import java.util.*;

public class PetTester {

    /**
     * Method: filePrinter
     * @param petlist: arraylist of pet objects
     */
    public void filePrinter(ArrayList<Pets> petlist){ //prints the petlist into the ClientData text file.
        //sorts the petlist array by the object class
        petlist.sort((p1, p2) -> p1.getType().compareTo(p2.getType()));

        HashSet<Class<?>> tmp = new HashSet<>();//A temporary to check for the first appearance of each object class

        try(
        FileWriter fileWriter = new FileWriter("ClientData.txt"); //writes to the .txt file
        BufferedWriter writer = new BufferedWriter(fileWriter)//more efficient way of writing to .txt file
        ){
            writer.write(String.format("--------------------------------%n"));
            writer.write(String.format(" Vet Clinic Client Sheet         %n"));
            writer.write(String.format("--------------------------------%n"));

            for (Pets pet : petlist) { //print out the pet list toString in a table format
                if (tmp.add(pet.getClass())) {
                    writer.write("--------------------------------------------------------------------------------------" + "\n");
                    writer.write(String.format(pet.tableString()) + "\n"); //adds the table row for pet type
                }
                writer.write(String.format(pet.toString()) + "\n");//toString for each pet
            }
        } catch (IOException e) {
            System.out.println("Could not write to file");
        }
    }

    /**
     * Method: search
     * Gives the user the option of finding, deleting, or adding a pet
     * @param petlist: arraylist of pet objects
     */
    public void search(ArrayList<Pets> petlist){
        Set<String> petHash = new HashSet<>();//creates a new HashSet to help check for duplicate names
        Set<String> petHashDuplicates = new HashSet<>();//the HashSet that will contain the duplicate names

        for (Pets pet : petlist) { //finds any duplicate pet names and puts them in a hashset
            if(!petHash.add(pet.getName())){
                petHashDuplicates.add(pet.getName().toLowerCase());
            }
        }
        //opens a scanner to read user input
        Scanner input = new Scanner(System.in);
        boolean check = false;

        System.out.println("Choose an option:");
        System.out.println("1. Find a Pet by name");
        System.out.println("2. Delete a Pet by name");
        System.out.println("3. Add a new Pet");
        System.out.println("4. Exit");
        int option = input.nextInt();
        input.nextLine();
        switch (option) { //switch case for the options above.
            case 1: { //Find the pet by the name
                System.out.println("Enter the pet's name: ");
                String petName = input.nextLine().toLowerCase();
                //if the pet name is in the duplicate hash it runs this line of coe below
                if(petHashDuplicates.contains(petName.toLowerCase())) {
                    System.out.println("What type of pet is it");
                    String response = input.nextLine().toLowerCase();
                    for (Pets pet : petlist) {
                        //checks for the correct pet type and name
                        if (pet.getType().equalsIgnoreCase(response) && pet.getName().equalsIgnoreCase(petName)) {
                            System.out.println("Your pet " + pet.getName() + " is a " + pet.getType() + " and has been found \n");
                            check = true;
                        }
                    }
                }else{
                    //if no duplicate finds the pet by name it runs for loop to find the pet by name
                    for (Pets pet : petlist) {
                        if (pet.getName().equalsIgnoreCase(petName)) {
                            System.out.println("Your pet " + pet.getName() + " is a " + pet.getType() + " and has been found \n");
                            check = true;
                        }
                    }
                    //if check is false the means that no conditions have been met so the pet was not found.
                    if(!check){
                        System.out.println("Pet not found try again \n");
                        search(petlist);
                    }
                }
                break;

            } case 2: { //deletes the pet by name
                System.out.println("Enter the pet's name: ");
                String petName = input.nextLine().toLowerCase();

                if (petHashDuplicates.contains(petName.toLowerCase())) { //if duplicate separates by pet type.
                    System.out.println("What type of pet is it");
                    String response = input.nextLine().toLowerCase();

                    for (Pets pet : petlist) {
                        if (pet.getType().equalsIgnoreCase(response) && pet.getName().equalsIgnoreCase(petName)) {
                            System.out.println("Pet has been deleted" + "\n");
                            petlist.remove(pet);
                            filePrinter(petlist);
                            check = true;
                        }
                    }

                }
                else{
                    //for loop iterates through the petlist
                    for(int i=0; i < petlist.size(); i++) {
                        //if no duplicates this will delete the pet by its name
                        if (petlist.get(i).getName().equalsIgnoreCase(petName)) {
                            System.out.println(petlist.get(i).getName() + " has been deleted" + "\n");
                            petlist.remove(petlist.get(i));
                            filePrinter(petlist);
                            check = true;
                        }
                    }

                }
                if(!check){
                    System.out.println("Pet not found try again \n");
                    search(petlist);
                }
                break;
            //When adding pet it ask the user the basic pet questions followed by a switch case
            //depending on the type of pet
            } case 3:{
                System.out.print("Enter pet name: ");
                String petName = input.nextLine();

                System.out.print("Enter owner's name: ");
                String owner = input.nextLine();

                System.out.print("Enter pet age: ");
                int age = input.nextInt();
                input.nextLine();

                System.out.print("Enter pet type (Dog, Cat, Snake: ");
                String type = input.nextLine().toLowerCase();

                switch (type) { //depending on the type of pet the questions asked will change to reflect the pet type
                    case "cat" -> {
                        System.out.print("Enter Cat hair(Short or Long): ");
                        String hair = input.nextLine();
                        System.out.print("Enter Cat claws(Clawed or Declawed): ");
                        String claws = input.nextLine();
                        System.out.print("Enter Cat color: ");
                        String color = input.nextLine();
                        Cat kitty = new Cat(petName, owner, age, type, hair,claws,color);
                        petlist.add(kitty);
                        check = true;
                        filePrinter(petlist);
                        System.out.println("\n Pet added to database \n");
                    }
                    case "dog" -> {
                        System.out.print("Enter dog breed: ");
                        String breed = input.nextLine();
                        System.out.print("Enter dog color: ");
                        String color = input.nextLine();
                        Dog doggy = new Dog(petName, owner, age, type, breed, color);
                        petlist.add(doggy);
                        check = true;
                        filePrinter(petlist);
                        System.out.println("\n Pet added to database \n");
                    }
                    case "snake" -> {
                        System.out.print("Enter snake breed: ");
                        String breed = input.nextLine();
                        System.out.print("Enter if snake is venomous(Venomous or NonVenomous: ");
                        String venomous = input.nextLine();
                        Snake snake = new Snake(petName, owner, age, type, breed, venomous);
                        petlist.add(snake);
                        check = true;
                        filePrinter(petlist);
                        System.out.println("\n Pet added to database \n");
                    }
                    default -> {
                        System.out.println("\n Not a valid pet type try again \n");
                        search(petlist);
                    }
                }
            } case 4:{ //stops the code from running
                System.out.println("Code Exited");
                break;
            }
        }

        if (!check) {
            System.out.println("Code Exited");
        } else search(petlist);

        input.close();
    } //searches for the pet you are looking for.

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("src/Clients.txt")); //Scans the input file
        input.useDelimiter("-|\n");//separates each token by the hyphen dash

        ArrayList<Pets> petlist = new ArrayList<>();//Arraylist for all pets
        while(input.hasNext()) {//while the text file has text it will continue adding onto the arraylist and change the type of animal depending on the switch case.
            String petName = input.next();
            String owner = input.next();
            String type = input.next();
            int age = input.nextInt();
            switch (type) { //depending on type of pet it changes the way text file is scanned.
                case "Cat" -> {
                    String hair = input.next();
                    String claws = input.next();
                    String color = input.next();
                    Cat kitty = new Cat(petName, owner, age, type, hair, claws, color);
                    petlist.add(kitty);
                }
                case "Dog" -> {
                    String breed = input.next();
                    String color = input.next();
                    Dog doggy = new Dog(petName, owner, age, type, breed, color);
                    petlist.add(doggy);
                }
                case "Snake" -> {
                    String breed = input.next();
                    String venomous = input.next();
                    Snake snake = new Snake(petName, owner, age, type, breed, venomous);
                    petlist.add(snake);
                }
            }
        }
        input.close(); //closes the scanner

        PetTester pet = new PetTester(); //instance of PetTester to run methods outside of main program
        pet.filePrinter(petlist); //prints the pets
        pet.search(petlist); //initiates the search method which gives the prompt


}
}
