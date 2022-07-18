package beans;

import interfaces.Mammals;

public class Dog extends Animal implements Mammals {


    public Dog() {
    }

    public Dog(Integer id, String name, Donor donor, Integer cageNumber) {
        super(id, name, donor, cageNumber);
    }

    @Override
    public String getType() {
        return Constants.DOG;
    }
    @Override
    public String getSound() {
        return Constants.BHO;
    }
}
