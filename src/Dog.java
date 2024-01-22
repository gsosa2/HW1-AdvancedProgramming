public class Dog extends Pets {
    private String breed;
    private String color;

    @Override
    public String toString(){//String printed for each dog type
        return String.format("| %-10s | %-18s | %4s | %-3s | %-15s| %-18s |",getName(),getOwnerName(),getType(),getAge(),getBreed(), getColor());
    }

    @Override
    public String tableString() {//similar to toString() but for the table print in the created text file
        return String.format("| %-10s | %-18s | %4s | %-3s | %-15s| %-18s |", "PET NAME", "OWNER NAME", "TYPE", "AGE","BREED","COLOR");
    }

    public Dog(String petName, String owner, int age, String type) {
        super(petName, owner, age, type);
    }

    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
