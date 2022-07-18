package beans;

import interfaces.Birds;

public class Peacock extends Animal implements Birds {
    public Peacock() {
    }

    public Peacock(Integer id, String name, Donor donor, Integer cageNumber) {
        super(id, name, donor, cageNumber);
    }

    @Override
    public String getType() {
        return Constants.PEACOCK;
    }
    @Override
    public String getSound() {
        return Constants.PIHOO;
    }
}
