/**Class: Advanced Programming
 * @author Gabe Sosa
 * @version 2.0
 * Course: ITEC 3150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class holds the common attributes and methods for the pet class.
 */
public abstract class Pets {
    private String name;

    private String ownerName;

    private int age;

    private String type;
    /**
        Method Pets
        Constructor
     * @param name: Name of the pet
     * @param ownerName: Name of the owner
     * @param age: age og the pet
     * @param type: type of the pet
     */
    public Pets(String name, String ownerName, int age, String type) {
        this.name = name;
        this.ownerName = ownerName;
        this.age = age;
        this.type = type;
    }
    /**
     * Method: toString
     * This is the toString for pet objects
     * @return the name, owner's name, and pet age
     */
    public String toString() { //String printed for each pets with no type.
        return String.format("Name: %s\r\nOwner: %s\r\nAge: %d\r\n", name, ownerName, age);
    }
    /**
    Method tableString
    This prints the title for the table in the resulting text file.
     * @return the title for the table/spreadsheet of pets
     */
    public String tableString(){ //similar to toString() but for the table print in the created text file
        return "\"--------------------------------%n" +
                "\" Vet Clinic Client Sheet       %n" +
                "\"--------------------------------%n";
    }
    /**
    Method getName
    getter
     * @return the pet name
     */
    public String getName() {
        return name;
    }
    /**
    Method setName
    Setter
     * @param name: the pet name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
    method getOwnerName
    Getter
     * @return the owner name
     */
    public String getOwnerName() {
        return ownerName;
    }
    /**
    Method: setOwnerName
    Setter
     * @param ownerName: the owner name
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Method: getAge
     * Getter
     * @return the pet's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Method: setAge
     * Setter
     * @param age: the pet's age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Method: getType
     * Getter
     * @return the pet's type
     */
    public String getType() {
        return type;
    }

    /**
     * Method: setType
     * Setter
     * @param type: the type of pet
     */
    public void setType(String type) {
        this.type = type;
    }
}
