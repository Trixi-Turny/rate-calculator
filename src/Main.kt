import java.nio.file.FileSystems
import java.nio.file.Files;
import java.nio.file.Path;


class Main {

    val filePath: String = "loan_files/";
    val fileName: String = "market.csv";

    val amount = 400;
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
                println(loans.toString());
                if (loans != null) {
                    val bestLoan = getBestLoan(amount, noOfMonths, loans);
                }

            } else {
                throw  IllegalArgumentException();
            }
        } catch (e: IllegalArgumentException) {
            println("Unsupported File Type: " + mime + ". Currently supported files are :")
            FileType.values().forEach { println(it.name) };
        }

    }

    fun getBestLoan(amount: Int, noOfMonths: Int, loans: ArrayList<Loan>): Loan? {


            val bestLoan = loans.filter({ it.availableAmount > amount }).minBy { it.rate };

            if(bestLoan!=null){
                println(bestLoan).toString()
                return bestLoan

            }
            println("It is not possible to provide a quote at this time.");
            return null;

    }


//    fun calculateInterest()
//    fun createQuote()
}



    fun main(args: Array<String>) {
        val init: Main = Main();
        init.startProcess(init.filePath, init.fileName);
    }