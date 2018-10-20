
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.round


class PaymentCalculator {

    /**
     * Calculates monthly repayable amount on loan using conformal method
     * ref: https://stackoverflow.com/questions/7827352/excel-pmt-function-in-java/42552043#42552043
     * @param amount :Double - the amount of loan requested
     * @param interestRate :Double - the interest rate per year
     * @param numberOfYears :Double - the term of the loan in years
     * @param calculationPeriod : Int
     *
     */
    fun calculateMonthlyRepayment(amount: Double, interestRate: Double, numberOfYears: Double, calculationPeriod: Int): Double {
        val paymentsPerYear = 12.0 / (numberOfYears * 12.0) * (numberOfYears * 12.0) / calculationPeriod
        val period = 1 / paymentsPerYear

        val interest = Math.pow(1 + interestRate, period) - 1
        val decursiveFactor = 1 + interest
        val annuityCalc = Math.pow(decursiveFactor, numberOfYears * 12) * (decursiveFactor - 1) / (Math.pow(decursiveFactor, numberOfYears * 12) - 1)
        return Math.round(amount * annuityCalc * 100.0) / 100.0
    }

    /**
     * Calculates total repayable amount after interest
     * @param amount:Double  - requested Loan amount
     * @param interestRate: Double - interest Rate payable on loan per year
     * @param numberOfMonths: Double - total number of months for whole period, eg 36.0 for 3 years
     * @param calculationPeriod: Int
     */
    fun calculateTotalAmount(amount: Double, interestRate: Double, numberOfMonths: Double, calculationPeriod: Int): Double{
        return calculateMonthlyRepayment(amount, interestRate, numberOfMonths/12, calculationPeriod)*numberOfMonths;

    }


    /**
     * Rounds to 2 decimal places
     * @param x: Double  - the value we want to round
     * ref: https://stackoverflow.com/questions/7124448/how-does-java-math-roundingmode-work
     */
    fun roundIt(x: Double?, scale: Int): Double? {
        if(x!= null) {
            val bd  = BigDecimal.valueOf(x);
            val rounded = bd.setScale(scale, RoundingMode.HALF_UP);
            return rounded.toDouble();

        }
        return null;
    }

    /**
     * Rounds the rate value provided in format '0.07' to one decimal, eg '7.0'
     * @param x: Double  - the value to be rounded
     */
    fun roundRate(rate: Double) :Double? {
        return roundIt((rate * 10000)/100, 1);
    }


}