/**Class: Advanced Programming
 * @author Gabe Sosa
 * @version 1.0
 * Course: ITEC 3150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class hold the Snake attributes
 */
public class Snake extends Pets{
    private String breed;
    private String venomous;

    /**
     * Method: Snake
     * Constructor
     * @param petName: name of the snake
     * @param owner: name of the snake owner
     * @param age: age of the snake
     * @param type: snake type
     * @param breed: breed of snake
     * @param venomous: if snake is venomous or not
     */
    public Snake(String petName, String owner, int age, String type, String breed, String venomous) {
        super(petName, owner, age, type);
        this.breed = breed;
        this.venomous = venomous;
    }

    /**
     * Method: toString
     * Override toString for the snake method
     * @return the formatted string showing the snake attribute in client friendly format
     */
    @Override
    public String toString() { //String printed for each snake type
        return String.format("| %-10s | %-18s | %5s | %-3s | %-15s| %-17s |",getName(),getOwnerName(),getType(),getAge(),getBreed(), getVenomous());
    }

    /**
     * Method: tableString
     * Override tableString for snake class
     * @return the formatted table head for the snake objects
     */
    @Override
    public String tableString() {//similar to toString() but for the table print in the created text file
        return String.format("| %-10s | %-18s | %5s | %-3s | %-15s| %-17s |", "PET NAME", "OWNER NAME", "TYPE", "AGE","BREED","VENOMOUS");
    }

    /**
     * Method: getBreed
     * Getter
     * @return the breed of snake
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Method: setBreed
     * Setter
     * @param breed: the breed of snake
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Method: getVenomous
     * Getter
     * @return if snake is Venomous or NonVenomous
     */
    public String getVenomous() {
        return venomous;
    }

    /**
     * Method: setVenomous
     * Setter
     * @param venomous: venomous state of snake
     */
    public void setVenomous(String venomous) {
        this.venomous = venomous;
    }
}
