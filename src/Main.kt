import java.nio.file.FileSystems
import java.nio.file.Files;
import java.nio.file.Path;


class Main {

    val filePath: String = "loan_files/";
    val fileName: String = "market.csv";

    val amountRequested :Int  = 1000;
    val noOfMonths = 36;
    fun getMimeType(filePath: String, fileName: String): String {
        var mime: String = "";

        try {
            val path: Path = FileSystems.getDefault().getPath(filePath, fileName)
            mime = Files.probeContentType(path);

        } catch (e: IllegalStateException) {
            println("Could not found file with name: " + fileName);
        }
        return mime
    }

    fun getFileTypeName(mime: String): FileType {
        return FileType.values().filter({ it.fileType == mime })[0];
    }

    fun startProcess(filePath: String, fileName: String) {
        var mime = "";
        try {
            val fileProcessorFactory: FileProcessorFactory? = FileProcessorFactory();
            mime = this.getMimeType(filePath, fileName)
            if (Validator.isValidEnum(mime)) {
                val fileProcessor: FileProcessor? = fileProcessorFactory?.getFileProcessor(this.getFileTypeName(mime));
                val loans: ArrayList<Loan>? = fileProcessor?.processFile(filePath + fileName);
                if (loans != null) {
                    val bestLoan = getBestLoan(this.amountRequested, noOfMonths, loans);
                    println(bestLoan.toString())


                    val monthlyRepayable = bestLoan?.calculateMonthlyRepayment(amountRequested.toDouble(), bestLoan?.rate, noOfMonths.toDouble()/12, 1);
                    val totalRepayable = bestLoan?.calculateTotalAmount(amountRequested.toDouble(), bestLoan?.rate, noOfMonths.toDouble(), 1);

                    val quote = Quote(this.amountRequested, bestLoan?.roundItToOne(bestLoan?.rate), monthlyRepayable, bestLoan?.roundItToTwo(totalRepayable));
                    println(quote.toString());
                }

            } else {
                throw  IllegalArgumentException("Unsupported File Type: " + mime+FileType.values().forEach { println(it.name) });
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)

        }

    }

    fun getBestLoan(amount: Int, noOfMonths: Int, loans: ArrayList<Loan>): Loan? {
            val bestLoan = loans.filter({ it.availableAmount > amount }).minBy { it.rate };

            if(bestLoan == null){
                println("It is not possible to provide a quote at this time.");

            }
            return bestLoan;

    }

}



    fun main(args: Array<String>) {
        val init: Main = Main();
        init.startProcess(init.filePath, init.fileName);

    }