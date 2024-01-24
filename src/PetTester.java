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

    public void filePrinter(ArrayList<Pets> petlist) throws IOException { //prints the petlist into the ClientData text file.
        petlist.sort(new Comparator<Pets>() {
            public int compare(Pets p1, Pets p2) {
                return p1.getType().compareTo(p2.getType());
            }
        });

        HashSet<Class<?>> tmp = new HashSet<>();

        FileWriter fileWriter = new FileWriter("ClientData.txt");
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(String.format("--------------------------------%n"));
        writer.write(String.format(" Vet Clinic Client Sheet         %n"));
        writer.write(String.format("--------------------------------%n"));

        for(Pets pet : petlist){ //print out the pet list toString in a table format
            if (tmp.add(pet.getClass())) {
                writer.write("--------------------------------------------------------------------------------------" + "\n");
                writer.write(String.format(pet.tableString()) + "\n"); //adds the table row for pet type
            }
            writer.write(String.format(pet.toString()) + "\n");//toString for each pet
        }
        writer.close();}//prints out the pet list input in a sorted manner

    public void search(ArrayList<Pets> petlist) throws IOException {
        Set<String> petHash = new HashSet<String>();
        Set<String> petHashDuplicates = new HashSet<String>();

        for (Pets pet : petlist) { //finds any duplicate pet names and puts them in a hashset
            if(!petHash.add(pet.getName())){
                petHashDuplicates.add(pet.getName().toLowerCase());;
            }
        }
        Scanner scanner = new Scanner(System.in);
        boolean check = false;

        System.out.println("Choose an option:");
        System.out.println("1. Find a Pet by name");
        System.out.println("2. Delete a Pet by name");
        System.out.println("3. Add a new Pet");
        System.out.println("4. Exit");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) { //switch case for the options above.
            case 1: { //Find the pet by the name
                System.out.println("Enter the pet's name: ");
                String petName = scanner.nextLine().toLowerCase();
                if (petHashDuplicates.contains(petName.toLowerCase())) { //if duplicate name separates by pet type
                    System.out.println("What type of pet is it");
                    String response = scanner.nextLine().toLowerCase();
                    for (Pets pet : petlist) {
                        if (pet.getType().equalsIgnoreCase(response) && pet.getName().equalsIgnoreCase(petName)) {
                            System.out.println("Your pet " + pet.getName() + " is a " + pet.getType() + " and has been found \n");
                            check = true;
                            break;
                        }
                    }
                    break;
                }else{
                    for (Pets pet : petlist) { //if no duplicate finds the pet by name
                        if (pet.getName().equalsIgnoreCase(petName)) {
                            System.out.println("Your pet " + pet.getName() + " is a " + pet.getType() + " and has been found \n");
                            check = true;
                            break;
                        }
                    }
                    if(!check){ //check if found and if not uses recursive to try again
                        System.out.println("Pet not found try again \n");
                        search(petlist);
                    }
                }
                break;

            } case 2: { //deletes the pet by name
                System.out.println("Enter the pet's name: ");
                String petName = scanner.nextLine().toLowerCase();
                if (petHashDuplicates.contains(petName.toLowerCase())) { //if duplicate separates by pet type.
                    System.out.println("What type of pet is it");
                    String response = scanner.nextLine().toLowerCase();
                    for (Pets pet : petlist) {
                        if (pet.getType().equalsIgnoreCase(response) && pet.getName().equalsIgnoreCase(petName)) {
                            System.out.println("Pet has been deleted" + "\n");
                            petlist.remove(pet);
                            filePrinter(petlist);
                            break;
                        }
                    }

                }
                else{
                    for(Pets pet : petlist)
                        if (pet.getName().equalsIgnoreCase(petName)){ //if no duplicate it deletes the pet by name
                            System.out.println(pet.getName() + " has been deleted" +  "\n");
                            petlist.remove(pet);
                            filePrinter(petlist);
                            break;
                    }

                }
                search(petlist);
            } case 3:{ //if adding new pet this ask you the basic Pet class fields.
                System.out.print("Enter pet name: ");
                String petName = scanner.nextLine();

                System.out.print("Enter owner's name: ");
                String owner = scanner.nextLine();

                System.out.print("Enter pet age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter pet type (Dog, Cat, Snake - this is case sensitive): ");
                String type = scanner.nextLine();

                switch (type) { //depending on the type of pet the questions asked will change to reflect the pet type
                    case "Cat" -> {
                        Cat kitty = new Cat(petName, owner, age, type);
                        System.out.print("Enter Cat hair(Short or Long): ");
                        String hair = scanner.nextLine();
                        System.out.print("Enter Cat claws(Clawed or Declawed): ");
                        String claws = scanner.nextLine();
                        System.out.print("Enter Cat color: ");
                        String color = scanner.nextLine();
                        kitty.setHair(hair);
                        kitty.setClaws(claws);
                        kitty.setColor(color);
                        petlist.add(kitty);
                        check = true;
                        filePrinter(petlist);
                        System.out.println("Pet added to database \n");
                    }
                    case "Dog" -> {
                        Dog doggy = new Dog(petName, owner, age, type);
                        System.out.print("Enter dog breed: ");
                        String breed = scanner.nextLine();
                        System.out.print("Enter dog color: ");
                        String color = scanner.nextLine();
                        doggy.setBreed(breed);
                        doggy.setColor(color);
                        petlist.add(doggy);
                        check = true;
                        filePrinter(petlist);
                        System.out.println("Pet added to database \n");
                    }
                    case "Snake" -> {
                        Snake snake = new Snake(petName, owner, age, type);
                        System.out.print("Enter snake breed: ");
                        String breed = scanner.nextLine();
                        System.out.print("Enter if snake is venomous(Venomous or NonVenomous: ");
                        String venomous = scanner.nextLine();
                        snake.setBreed(breed);
                        snake.setVenomous(venomous);
                        petlist.add(snake);
                        check = true;
                        filePrinter(petlist);
                        System.out.println("Pet added to database \n");
                    }
                }
            } case 4:{ //stops the code from running
                System.out.println("Code Exited");
                break;
            }
        }

        if (!check) {
            System.out.println("Pet was not found/Code ended");
        } else search(petlist);

        scanner.close();
    } //searches for the pet you are looking for.

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("src/Clients.txt")); //Scans the input file
        input.useDelimiter("-|\n");//separates each token by the hyphen dash

        ArrayList<Pets> petlist = new ArrayList<>();//Arraylist for all pets
        while(input.hasNext()) {
            String petName = input.next();
            String owner = input.next();
            String type = input.next();
            int age = input.nextInt();
            switch (type) { //depending on type of pet it changed the way text file is read and inputed.
                case "Cat" -> {
                    Cat kitty = new Cat(petName, owner, age, type);
                    String hair = input.next();
                    String claws = input.next();
                    String color = input.next();
                    kitty.setHair(hair);
                    kitty.setClaws(claws);
                    kitty.setColor(color);
                    petlist.add(kitty);
                }
                case "Dog" -> {
                    Dog doggy = new Dog(petName, owner, age, type);
                    String breed = input.next();
                    String color = input.next();
                    doggy.setBreed(breed);
                    doggy.setColor(color);
                    petlist.add(doggy);
                }
                case "Snake" -> {
                    Snake snake = new Snake(petName, owner, age, type);
                    String breed = input.next();
                    String venomous = input.next();
                    snake.setBreed(breed);
                    snake.setVenomous(venomous);
                    petlist.add(snake);
                }
            }
        } //while the text file has text it will continue adding onto the arraylist and change the type of animal depending on the switch case.
        input.close();

        PetTester pet = new PetTester(); //instance of PetTester to run methods outside of main program
        pet.filePrinter(petlist);
        pet.search(petlist);


}
}
