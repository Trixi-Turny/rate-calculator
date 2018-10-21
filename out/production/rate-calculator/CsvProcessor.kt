import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.ArrayList


/**
 * Facilitates the processing of CSV files
 */

class CsvProcessor : FileProcessor {

    private val lenderIndex = 0
    private val rateIndex = 1
    private val amountIndex = 2

    val commaDelimiter = ',';

    override fun processFile(path:String): ArrayList<Loan>? {
        val loans = ArrayList<Loan>() ;

        var fileReader: BufferedReader? = null
        try {

            var line: String?
            
            fileReader = BufferedReader(FileReader(path))

            // Read CSV header
            fileReader.readLine()
            line = fileReader.readLine()
            while (line != null) {
                val tokens = line.split(this.commaDelimiter)
                if (tokens.size > 0) {
                    val loan = Loan(
                            tokens[lenderIndex],
                            tokens[rateIndex].toDouble(),
                            tokens[amountIndex].toDouble()
                            );
                    loans.add(loan)
                }

                line = fileReader.readLine()
            }
            return loans;
        } catch (e: Exception) {
            println("There was an error reading the file.")
            e.printStackTrace()
        } finally {
            try {
                fileReader!!.close();
            } catch (e: IOException) {
                println("There was an error closing the file. ")
                e.printStackTrace()
            }
        }

        return loans;

    }

}