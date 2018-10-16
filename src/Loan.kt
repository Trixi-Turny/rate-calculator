import kotlin.math.round
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow


data class Loan(val lender: String, var rate:Double, var availableAmount:Double) {

    fun calculateMonthlyRepayment(amount:Double, rate:Double, noOfMonths:Int):Double{

        val yearlyInterest = amount*rate *12;
        if(Validator.isNotNull(rate)|| Validator.isNotNull(noOfMonths)){
            return ;
        }
        throw  IllegalArgumentException("amount or rate can not be null");

    }
    fun calculateTotalAmount(amount:Double, rate:Double, noOfMonths:Int): Double{
        if(Validator.isNotNull(rate)|| Validator.isNotNull(noOfMonths)) {
            return calculateMonthlyRepayment (amount, rate, noOfMonths)* noOfMonths;
        }else{
            println("in total");
            throw IllegalArgumentException("amount or rate can not be null");
        }

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