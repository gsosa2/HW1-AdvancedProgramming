/**Class: Advanced Programming
 * @author Gabe Sosa
 * @version 1.0
 * Course: ITEC 3150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class hold the Dog attributes and methods
 */
public class Dog extends Pets {
    private String breed;
    private String color;

    /**
     * Method: Dog
     * Constructor for Dog class
     * @param petName: name for dog
     * @param owner: name for dog owner
     * @param age: age of dog
     * @param type: dog type
     * @param breed: breed of dog
     * @param color: color of dog
     */
    public Dog(String petName, String owner, int age, String type, String breed, String color) {
        super(petName, owner, age, type);
        this.breed = breed;
        this.color = color;
    }

    /**
     * Method: toString
     * Override toString for the dog method
     * @return the formatted string for the dog object
     */
    @Override
    public String toString(){//String printed for each dog type
        return String.format("| %-10s | %-18s | %4s | %-3s | %-15s| %-18s |",getName(),getOwnerName(),getType(),getAge(),getBreed(), getColor());
    }

    /**
     * Method: tableString
     * Override table head for the dog objects
     * @return the formatted string showing the dog attribute in client friendly format
     */
    @Override
    public String tableString() {//similar to toString() but for the table print in the created text file
        return String.format("| %-10s | %-18s | %4s | %-3s | %-15s| %-18s |", "PET NAME", "OWNER NAME", "TYPE", "AGE","BREED","COLOR");
    }

    /**
     * Method: getBreed
     * Getter
     * @return the breed of the dog
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Method: setBreed
     * Setter
     * @param breed: the breed of the dog
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Method: getColor
     * Getter
     * @return the color of the dog
     */
    public String getColor() {
        return color;
    }

    /**
     * Method: setColor
     * Setter
     * @param color: the color of the dog
     */
    public void setColor(String color) {
        this.color = color;
    }
}
