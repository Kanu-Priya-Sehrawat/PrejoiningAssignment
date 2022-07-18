package beans;

public class Animal {

    Integer id;
    String name;

    String sound;

    Donor donor;

    String type;

    Integer cageNumber;

    public Animal() {

    }

    public Animal(Integer id, String name, Donor donor, Integer cageNumber) {
        this.id = id;
        this.name = name;
        this.donor = donor;
        this.cageNumber = cageNumber;
    }

    public Integer getCageNumber() {
        return cageNumber;
    }

    public void setCageNumber(Integer cageNumber) {
        this.cageNumber = cageNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public Donor getDonor() {
        return donor;
    }
}
