
import org.junit.Assert
import org.junit.Test
//import java.lang.IllegalArgumentException
import Main

class RateCalculatorTest {

    val fileName = "test1.jpeg"


    @Test
    fun it_returns_text_plain_when_passed_a_txt_file(){
        val main = Main();

        val mime = main.startProcess(main.filePath, this.fileName);
        Assert.assertEquals("image/jpeg", mime)

    }
    @Test(expected = IllegalArgumentException::class)
    fun when_using_jpeg_file_should_get_file_type_not_supported()
    {
        val main = Main();
        main.startProcess(main.filePath, this.fileName);
    }

    }
    // input validation
    // valid file
    // valid amount
    // it should give back the correct rates
    // it should say no rates available when there are no loans
    // it should give error message when amount is higher than allowed
    // it should give error message if file does not exist or is empty
    // it should give error message if any other file issue occurs





//}

