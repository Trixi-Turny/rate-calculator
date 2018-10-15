import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.ArrayList


class CsvProcessor : FileProcessor {

    private val lenderIndex = 0
    private val rateIndex = 1
    private val amountIndex = 2



    val commaDelimiter = ',';
    override fun processFile(path:String): ArrayList<Loan>? {

        var fileReader: BufferedReader? = null
        try {
            val loans = ArrayList<Loan>() ;
            var line: String?

            fileReader = BufferedReader(FileReader(path))

            // Read CSV header
            fileReader.readLine()
            line = fileReader.readLine()
            while (line != null) {
                val tokens = line.split(commaDelimiter)
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

// Print the new customer list
            for (loan in loans) {
                println(loan)
            }
        } catch (e: Exception) {
            println("Reading CSV Error!")
            e.printStackTrace()
        } finally {
            try {
                fileReader!!.close()
                return null
            } catch (e: IOException) {
                println("Closing fileReader Error!")
                e.printStackTrace()
            }
        }
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}