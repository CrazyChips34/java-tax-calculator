import java.util.Scanner;
/*
if income is in the following ranges they would pay a certain percentage and/or money as well
* 1-237 100 : 18%
* 237 101 – 370 500 : 42 678 + 26%
*370 501 – 512 800 : 77 362 + 31%
*512 801 – 673 000 : 121 475 + 36%
*673 001 – 857 900 : 179 147 + 39%
*857 901 – 1 817 000: 251 258 + 41%
* 1 817 001 and above : 644 489 + 45%
 * */
public class TaxCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double income = 0.0;
        boolean isValidInput = false;

        //Adding Validation
        while (!isValidInput) {
            System.out.println("Please enter your annual income: ");
            String input = scan.nextLine().trim();

            // Validate the input
            if (input.isEmpty() || input.equals("0") || input.equals(".0")) {
                System.out.println("Invalid input. Please enter a valid income.");
            } else {
                try {
                    income = Double.parseDouble(input);
                    isValidInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid income.");
                }
            }
        }

        //Calculate tax based on income
        double tax = calculateTax(income);

        //Display calculated tax amount
        System.out.println("Your tax amount is: " + tax);

    }

    //Method with tax brackets
    public static double calculateTax(double income) {
        double tax;

        if (income <= 237100) {
            tax = income * 0.18;
        } else if (income <= 370500) {
            tax = 42678 + (income - 237100) * 0.26;
        } else if (income <= 512800) {
            tax = 77362 + (income - 370500) * 0.31;
        } else if (income <= 673000) {
            tax = 121475 + (income - 512800) * 0.36;
        } else if (income <= 857900) {
            tax = 179147 + (income - 673000) * 0.39;
        } else if (income <= 1817000) {
            tax = 251258 + (income - 857900) * 0.41;
        } else {
            tax = 644489 + (income - 1817000) * 0.45;
        }
        return tax;
    }
}