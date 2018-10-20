class Main {

    val filePath: String = "loan_files/";
    val fileName: String = "market.csv";

    val amountRequested :Int  = 1000;
    val noOfMonths = 36;

    val file = File(filePath, fileName);

    fun startProcess(filePath: String, fileName: String) {

        try {
            val mime: String
            val fileProcessorFactory: FileProcessorFactory? = FileProcessorFactory();
            mime = this.file.getMimeType()
            if (Validator.isValidEnum(mime)) {
                val fileProcessor: FileProcessor? = fileProcessorFactory?.getFileProcessor(this.file.getFileTypeName(mime));

                val loans: ArrayList<Loan>? = fileProcessor?.processFile(this.file.filePath + this.file.fileName);
                if (loans != null) {
                    val bestLoan = getBestLoan(this.amountRequested, noOfMonths, loans);
                    println(bestLoan.toString())
                    if(bestLoan!=null) {
                        val paymentCalculator = PaymentCalculator();
                        val monthlyRepayable = paymentCalculator.calculateMonthlyRepayment(amountRequested.toDouble(), bestLoan.rate, noOfMonths.toDouble() / 12, 1);
                        val totalRepayable = paymentCalculator.calculateTotalAmount(amountRequested.toDouble(), bestLoan.rate, noOfMonths.toDouble(), 1);

                        val quote = Quote(this.amountRequested, paymentCalculator.roundRate(bestLoan.rate), monthlyRepayable, paymentCalculator.roundIt(totalRepayable, 2));
                        println(quote.toString());
                    }
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
                ("It is not possible to provide a quote at this time.");

            }
            return bestLoan;

    }

}



    fun main(args: Array<String>) {
        val init: Main = Main();
        init.startProcess(init.filePath, init.fileName);

    }