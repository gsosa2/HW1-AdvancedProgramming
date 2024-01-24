/**Class: Advanced Programming
 * @author Gabe Sosa
 * @version 1.0
 * Course: ITEC 3150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class hold the Cat attributes
 */
public class Cat extends Pets {
    private String hair;
    private String claws;
    private String color;

    public Cat(String name, String owner, int age, String type){
        super(name, owner, age, type);
    }

    @Override
    public String toString(){//String printed for each snake type
        return String.format("| %-10s | %-18s | %4s | %-3s | %-5s| %-9s| %-18s|",getName(),getOwnerName(),getType(),getAge(), getHair(), getClaws(), getColor());

    }

    @Override
    public String tableString() { //similar to toString() but for the table print in the created text file
        return String.format("| %-10s | %-18s | %4s | %-3s | %-5s| %-9s| %-18s|", "PET NAME", "OWNER NAME", "TYPE", "AGE", "HAIR", "CLAWS", "COLORS");
    }

    public String getHair() {
        return hair;
    }
    public void setHair(String hair) {
        this.hair = hair;
    }
    public String getClaws() {
        return claws;
    }
    public void setClaws(String claws) {
        this.claws = claws;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
