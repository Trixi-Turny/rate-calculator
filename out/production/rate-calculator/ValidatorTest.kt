import org.junit.Assert.*
import org.junit.Test


class ValidatorTest{

    @Test
    fun returnsTrueForValidEnum(){
        val mime = "text/csv";
        val bool = Validator.isValidEnum(mime);
        assertEquals(true, bool);
    }

    @Test
    fun returnsFalseForInValidEnum(){
        val mime = "text/something";
        val bool = Validator.isValidEnum(mime);
        assertEquals(false, bool);
    }

    @Test
    fun returnsFalseForDecimalValuesOtherThanZero(){
        val loan = 1000.87
        val bool = Validator.isValidLoanAmount(loan, 100);
        assertEquals(false, bool);
    }

    @Test
    fun returnsTrueForDecimalValuesWhenTheyAreZeroButAmountIsLargerThanDevider(){
        val loan = 1000.00
        val bool = Validator.isValidLoanAmount(loan, 100);
        assertEquals(true, bool);
    }


    @Test
    fun returnsFalseForAmountsLessThanDivider(){
        val loan = 10.00;
        val bool = Validator.isValidLoanAmount(loan, 100);
        assertEquals(false, bool);
    }


    @Test
    fun returnsFalseIfNAN(){
        val loan: String = "ol";
        val bool = Validator.canBeConvertedToDouble(loan);
        assertEquals(false, bool);
    }

    @Test
    fun returnsTrueIfCanBeConverted(){
        val loan: String = "12";
        val bool = Validator.canBeConvertedToDouble(loan);
        assertEquals(true, bool);
    }

}