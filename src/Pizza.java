public class Pizza {
    private int price;
    private boolean veg;
    private int extraCheesePrice = 100;
    private int extraToppingsPrice = 150;
    private int backPackPrice = 20;
    private int basePizzaPrice;
    //instance boolean variable to check the extras are added or not

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isOptedForTakeAway = false;

    //constructor
    //we are initializing the value here
    public Pizza(Boolean veg) {
        this.veg = veg;
        //the price of pizza changes according to the boolean value
        if (this.veg) {
            this.price = 300;
        } else {
            //this sets the base price of non veg pizza to 400 as this is constructor and we are initializing the variable
            this.price = 400;
        }
        basePizzaPrice = this.price;
    }

    //method to add extra cheese
    public void addExtraCheese() {
        isExtraCheeseAdded = true;
        this.price += extraCheesePrice;

    }

    //method to add extra topping
    public void addExtraToppings() {
        isExtraToppingsAdded = true;
        this.price += extraToppingsPrice;

    }

    //method for pizza takeaway
    public void takeAway() {
        isOptedForTakeAway = true;
        this.price += backPackPrice;

    }

    public void getBill() {
        String bill = "";
        System.out.println("Pizza: " + basePizzaPrice);

        if (isExtraCheeseAdded) {
            bill += "Extra cheese added: " + extraCheesePrice + "\n";
        }
        if (isExtraToppingsAdded) {
            bill += "Extra toppings added: " + extraToppingsPrice + "\n";
        }
        if (isOptedForTakeAway) {
            bill += "Take away: " + backPackPrice + "\n";
        }
        bill+="Bill: " + this.price + "\n";
        System.out.println(bill);


    }
    //end of class
}
