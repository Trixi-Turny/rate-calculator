import kotlin.math.round
import java.math.RoundingMode
import java.text.DecimalFormat


data class Loan(val lender: String, var rate:Double, var availableAmount:Double) {

    //ref: https://stackoverflow.com/questions/7827352/excel-pmt-function-in-java/42552043#42552043

    fun calculateMonthlyRepayment(amount: Double, interestRate: Double, numberOfYears: Double, calculationPeriod: Int): Double {
        val paymentsPerYear = 12.0 / (numberOfYears * 12.0) * (numberOfYears * 12.0) / calculationPeriod
        val period = 1 / paymentsPerYear

        val interest = Math.pow(1 + interestRate, period) - 1
        val decursiveFactor = 1 + interest
        val annuityCalc = Math.pow(decursiveFactor, numberOfYears * 12) * (decursiveFactor - 1) / (Math.pow(decursiveFactor, numberOfYears * 12) - 1)
        return Math.round(amount * annuityCalc * 100.0) / 100.0
    }

    fun calculateTotalAmount(amount: Double, interestRate: Double, numberOfMonths: Double, calculationPeriod: Int): Double{
        return calculateMonthlyRepayment(amount, interestRate, numberOfMonths/12, calculationPeriod)*numberOfMonths;

    }



    fun roundItToTwo(x: Double?): Double? {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        if(x!= null) {
            return df.format(x).toDouble();
        }
        return null;
    }

    fun roundItToOne    (x: Double) :Double? {
        if (x != null) {
            return round(x * 1000) / 10
        }
        return null;
    }



}