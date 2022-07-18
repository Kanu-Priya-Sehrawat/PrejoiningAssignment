package beans;

import interfaces.Mammals;

public class Rat extends Animal implements Mammals {

    public Rat() {
    }

    public Rat(Integer id, String name, Donor donor, Integer cageNumber) {
        super(id, name, donor, cageNumber);
    }

    @Override
    public String getType() {
        return Constants.RAT;
    }
    @Override
    public String getSound() {
        return Constants.CHOO;
    }
}
