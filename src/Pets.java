/**Class: Advanced Programming
 * @author Gabe Sosa
 * @version 1.0
 * Course: ITEC 3150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class hold the Pet attributes
 */





public abstract class Pets {
    private String name;

    private String ownerName;

    private int age;

    private String type;

    public Pets(String name, String ownerName, int age, String type) {
        this.name = name;
        this.ownerName = ownerName;
        this.age = age;
        this.type = type;
    }

    public String toString() { //String printed for each pets with no type.
        return String.format("Name: %s\r\nOwner: %s\r\nAge: %d\r\n", name, ownerName, age);
    }

    public String tableString(){ //similar to toString() but for the table print in the created text file
        return "\"--------------------------------%n" +
                "\" Vet Clinic Client Sheet       %n" +
                "\"--------------------------------%n";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
