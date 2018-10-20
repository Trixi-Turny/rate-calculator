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


}