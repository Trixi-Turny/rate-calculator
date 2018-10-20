import kotlin.math.round
import java.math.RoundingMode
import java.text.DecimalFormat


data class Loan(val lender: String, var rate:Double, var availableAmount:Double) {

    fun calculateMonthlyRepayment(amount:Int, rate:Double, noOfMonths:Int):Double{
        val monthsInYear = 12;

        //Financial calculation taken from: https://stackoverflow.com/questions/7827352/excel-pmt-function-in-java

        val fv = amount * Math.pow((1 + roundItToFour(rate/monthsInYear)), noOfMonths.toDouble());
        println("fv "+fv);

        println(rate/monthsInYear);





//        val pmt = (fv * roundItToFour(rate/monthsInYear))/(Math.pow((1 + roundItToFour(rate/monthsInYear)), noOfMonths.toDouble())-1);
        val pmt = (amount*(rate/monthsInYear))/(1-Math.pow((1+(rate/monthsInYear)), (-(noOfMonths/monthsInYear)*monthsInYear).toDouble()));
        return pmt;


        val yearlyInterest = amount*rate *12;
        if(Validator.isNotNull(rate) || Validator.isNotNull(noOfMonths)){
//            return ;
        }
        throw  IllegalArgumentException("amount or rate can not be null");

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

    //add exception handling
    fun roundItToFour(x: Double): Double {



            val intValue: Int = Math.round(x * 1000000).toInt();
            val roundedDouble = intValue.toDouble() / 1000000;

            return roundedDouble;


    }


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

//        if(Validator.isNotNull(rate) || Validator.isNotNull(noOfMonths)) {
//            return calculateMonthlyRepayment (amount.toInt(), rate, noOfMonths)* noOfMonths;
//        }else{
//            println("in total");
//            throw IllegalArgumentException("amount or rate can not be null");
//        }

    }


}