import org.junit.Test

import org.junit.Assert.*

class MainTest {

    @Test
    fun getBestLoanFor1000() {

        val mainProcess = Main();
        val loans = arrayListOf<Loan>(
                Loan("trixi", 0.09, 130.0),
                Loan("judy", 0.08, 2000.0),
                Loan("fred", 0.06, 100.0)
        );

        assertEquals(loans[1], mainProcess.getBestLoan(1000, 36, loans));

    }

    @Test
    fun getBestLoanShouldBeNullWhenNoLoanAvailable() {

        val mainProcess = Main();
        val loans = arrayListOf<Loan>(
                Loan("trixi", 0.09, 130.0),
                Loan("judy", 0.08, 2000.0),
                Loan("fred", 0.06, 100.0)
        );

        assertEquals(null, mainProcess.getBestLoan(3000, 36, loans));

    }

//    @Test
//    fun processFileShouldThrowException(){
//        val filePath = "../../loan_files"
//        val fileName = "market.jpg"
//        val mainProcess = Main();
//        mainProcess.startProcess(filePath, fileName)
//    }

}