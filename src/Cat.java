/**Class: Advanced Programming
 * @author Gabe Sosa
 * @version 1.0
 * Course: ITEC 3150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class hold the Cat attributes and methods
 */
public class Cat extends Pets {
    private String hair;
    private String claws;
    private String color;

    /**
     * Method: Cat
     * Constructor
     * @param name: name of the cat
     * @param owner: owner of the cat
     * @param age: age of the cat
     * @param type: type of pet
     * @param hair: short or long hair
     * @param claws: clawed or declawed cat
     * @param color: color of the cat
     */
    public Cat(String name, String owner, int age, String type, String hair, String claws, String color) {
        super(name, owner, age, type);
        this.hair = hair;
        this.claws = claws;
        this.color = color;
    }

    /**
     * Method: toString
     * The formatted output for any cat
     * @return the formatted string showing the cat attribute in client friendly format
     */
    @Override
    public String toString(){//String printed for each snake type
        return String.format("| %-10s | %-18s | %4s | %-3s | %-5s| %-9s| %-18s|",getName(),getOwnerName(),getType(),getAge(), getHair(), getClaws(), getColor());

    }

    /**
     * Method: tableString
     * The table head for the cat class
     * @return the formatted table row for the cat class
     */
    @Override
    public String tableString() { //similar to toString() but for the table print in the created text file
        return String.format("| %-10s | %-18s | %4s | %-3s | %-5s| %-9s| %-18s|", "PET NAME", "OWNER NAME", "TYPE", "AGE", "HAIR", "CLAWS", "COLORS");
    }

    /**
     * Method: getHair
     * Getter
     * @return the cat's hair
     */
    public String getHair() {
        return hair;
    }

    /**
     * Method: setHair
     * Setter
     * @param hair: short or long hair for cat
     */
    public void setHair(String hair) {
        this.hair = hair;
    }

    /**
     * Method: getClaws
     * Getter
     * @return either Clawed or Declawed depending on cat
     */
    public String getClaws() {
        return claws;
    }

    /**
     * Method: setClaws
     * Setter
     * @param claws: Claws for cat
     */
    public void setClaws(String claws) {
        this.claws = claws;
    }

    /**
     * Method: getColor
     * Getter
     * @return the color the cat
     */
    public String getColor() {
        return color;
    }

    /**
     * Method: setColor
     * Setter
     * @param color: color for cat
     */
    public void setColor(String color) {
        this.color = color;
    }
}
