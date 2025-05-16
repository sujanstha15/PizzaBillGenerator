public class DeluxPizza extends Pizza {
    public DeluxPizza(Boolean veg) {
        super(veg);
        super.addExtraCheese();
        super.addExtraToppings();
    }

    @Override
    public void addExtraCheese(){
        System.out.println("Extra cheese already added");
    }

    @Override
    public void addExtraToppings(){
        System.out.println("Extra toppings already added");
    }
}
