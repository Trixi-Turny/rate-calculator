import org.junit.Test
//import org.junit.Assert.*
import kotlin.test.assertEquals

class PaymentCalculatorTest() {


    @Test
    fun calculateMonthlyRepayment() {
        val loanAmount = 1000.0
        val rate = 0.07
        val noOfYears = 3.0
        val calcPeriod = 1
        val calculator = PaymentCalculator();
        val monthly = calculator.calculateMonthlyRepayment(loanAmount, rate, noOfYears, calcPeriod);
        assertEquals(30.78, monthly);
    }

    @Test
    fun calculateTotalAmount() {
        val loanAmount = 1000.0
        val rate = 0.07
        val noOfYears = 3.0
        val calcPeriod = 1
        val calculator = PaymentCalculator();
        val total = calculator.calculateTotalAmount(loanAmount, rate, 36.00, calcPeriod);
        assertEquals(1108.08, total);



    }

    @Test
    fun roundItTo_66_WhenItEndsWith_65765() {
        val value = 1200.65765
        val calculator = PaymentCalculator();
        val rounded = calculator.roundIt(value, 2);
        assertEquals(1200.66, rounded);

    }

    @Test
    fun roundItTo_66_WhenItEndsWith_655() {
        val value = 1200.655
        val calculator = PaymentCalculator();
        val rounded = calculator.roundIt(value, 2);
        assertEquals(1200.66, rounded);

    }

    @Test
    fun roundItTo_65_WhenItEndsWith_654() {
        val value = 1200.653
        val calculator = PaymentCalculator();
        val rounded = calculator.roundIt(value, 2);
        assertEquals(1200.65, rounded);

    }



    @Test
    fun roundRateTo_9dot9_WhenItEndsWith_0987() {
        val rate = 0.0987;
        val calculator = PaymentCalculator();
        val rounded = calculator.roundRate(rate);
        assertEquals(9.9, rounded);
    }

    @Test
    fun roundRateTo_9dot8_WhenItEndsWith_0984() {
        val rate = 0.0984;
        val calculator = PaymentCalculator();
        val rounded = calculator.roundRate(rate);
        assertEquals(9.8, rounded);
    }

    @Test
    fun roundRateTo_9dot9_WhenItEndsWith_0985() {
        val rate = 0.0985;
        val calculator = PaymentCalculator();
        val rounded = calculator.roundRate(rate);
        assertEquals(9.9, rounded);
    }


    @Test
    fun roundRateTo_7dot0_WhenItEndsWith_07() {
        val rate = 0.07;
        val calculator = PaymentCalculator();
        val rounded = calculator.roundRate(rate);
        assertEquals(7.0, rounded);
    }




}