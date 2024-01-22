public class Snake extends Pets{
    private String breed;
    private String venomous;

    public Snake(String petName, String owner, int age, String type) {
        super(petName, owner, age, type);
    }

    @Override
    public String toString() { //String printed for each snake type
        return String.format("| %-10s | %-18s | %5s | %-3s | %-15s| %-17s |",getName(),getOwnerName(),getType(),getAge(),getBreed(), getVenomous());
    }

    @Override
    public String tableString() {//similar to toString() but for the table print in the created text file
        return String.format("| %-10s | %-18s | %5s | %-3s | %-15s| %-17s |", "PET NAME", "OWNER NAME", "TYPE", "AGE","BREED","VENOMOUS");
    }


    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getVenomous() {
        return venomous;
    }

    public void setVenomous(String venomous) {
        this.venomous = venomous;
    }
}
