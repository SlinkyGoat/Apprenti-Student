public class LoanPaymentCalculator {

    public static void main(String[] args) {
        //Declare and initialize variables:
        double loanAmount = 25000.00;
        double annualInterestRate = 5.5;
        int loanTermYears = 5;
        double monthlyPayment;

//        Calculate Monthly Payment using the Formula
//        monthlyPayment = (loanAmount×(interestRate/100)/12)
        monthlyPayment = (loanAmount * (annualInterestRate / 100) / 12);
//        1. Use Assignment Operators:
//             Increase loanAmount by $5,000 (+=).
//             Reduce the annualInterestRate by 1% (-=).
//             Increase loanTermYears by 1 (++).
        loanAmount += 5000;
        annualInterestRate -= 1.0;
        loanTermYears++;

//         2. Use Comparison Operators:
//             Check if the loanAmount exceeds $30,000.
//             Check if the monthlyPayment is more than $500.
        boolean isLargeLoan = loanAmount > 30000;
        boolean isLargeMonthly = monthlyPayment > 500;

//          3. Use Logical Operators:
//            Determine if the loan is affordable (monthly payment is below $500 AND
//                    term is over 3 years).
        boolean isAffordable = !isLargeMonthly && loanTermYears > 3;
//            Determine if the loan is expensive (monthly payment is above $700 OR
//                    interest rate is over 6%).
        boolean isExpensive = isLargeMonthly || annualInterestRate > 6.0;

//           4. Print all results.
        System.out.println("The loan amount exceeds $30,000: " + isLargeLoan);
        System.out.println("The monthly loan payment exceeds $500: " + isLargeMonthly);
        System.out.println("The loan is affordable: " + isAffordable);
        System.out.println("The loan is expensive: " + isExpensive);


    }

}
