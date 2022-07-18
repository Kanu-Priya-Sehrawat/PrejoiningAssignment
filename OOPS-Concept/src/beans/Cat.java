package beans;

import interfaces.Mammals;

public class Cat extends Animal implements Mammals {
    public Cat() {

    }

    public Cat(Integer id, String name, Donor donor, Integer cageNumber) {
        super(id, name, donor, cageNumber);
    }

    @Override
    public String getType() {
        return Constants.CAT;
    }
    @Override
    public String getSound() {
        return Constants.MEOW;
    }
}
