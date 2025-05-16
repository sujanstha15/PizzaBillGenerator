import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PizzaOrderUI {

    public static void launch() {
        JFrame frame = new JFrame("Pizza Ordering System");
        frame.setSize(400, 500);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JCheckBox vegCheck = new JCheckBox("Veg Pizza");
        JCheckBox cheeseCheck = new JCheckBox("Add Extra Cheese (+100)");
        JCheckBox toppingCheck = new JCheckBox("Add Extra Toppings (+150)");
        JCheckBox takeawayCheck = new JCheckBox("Takeaway (+20)");
        JCheckBox deluxeCheck = new JCheckBox("Delux Pizza (Auto cheese + toppings)");

        JButton orderButton = new JButton("Place Order");
        JTextArea billArea = new JTextArea(10, 30);
        billArea.setEditable(false);

        frame.add(vegCheck);
        frame.add(cheeseCheck);
        frame.add(toppingCheck);
        frame.add(takeawayCheck);
        frame.add(deluxeCheck);
        frame.add(orderButton);
        frame.add(new JScrollPane(billArea));

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isVeg = vegCheck.isSelected();
                Pizza pizza;

                if (deluxeCheck.isSelected()) {
                    pizza = new DeluxPizza(isVeg);
                } else {
                    pizza = new Pizza(isVeg);
                    if (cheeseCheck.isSelected()) {
                        pizza.addExtraCheese();
                    }
                    if (toppingCheck.isSelected()) {
                        pizza.addExtraToppings();
                    }
                }

                if (takeawayCheck.isSelected()) {
                    pizza.takeAway();
                }

                String bill = getBillAsText(pizza);
                billArea.setText(bill);
            }
        });

        frame.setVisible(true);
    }

    // Helper method to capture System.out.println() output from getBill()
    private static String getBillAsText(Pizza pizza) {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        java.io.PrintStream ps = new java.io.PrintStream(out);
        java.io.PrintStream old = System.out;
        System.setOut(ps);
        pizza.getBill();
        System.out.flush();
        System.setOut(old);
        return out.toString();
    }
}