package beans;

import interfaces.Birds;

public class Parrot extends Animal implements Birds {
    public Parrot() {
    }

    public Parrot(Integer id, String name, Donor donor, Integer cageNumber) {
        super(id, name, donor, cageNumber);
    }

    @Override
    public String getType() {
        return Constants.PARROT;
    }
    @Override
    public String getSound() {
        return Constants.TALK;
    }
}
