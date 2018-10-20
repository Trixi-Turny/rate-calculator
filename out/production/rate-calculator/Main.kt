class Main {

    val filePath: String = System.getProperty("user.dir")+"/src/loan_files/";
//    val fileName: String = "market.csv";
//
//    val amountRequested :Int  = 1000;
    val noOfMonths = 36;



    fun startProcess(filePath: String, fileName: String, amountRequested: Int) {
        val file = File(filePath, fileName);

        try {
            val mime: String
            val fileProcessorFactory: FileProcessorFactory? = FileProcessorFactory();
            mime = file.getMimeType()
            if (Validator.isValidEnum(mime)) {
                val fileProcessor: FileProcessor? = fileProcessorFactory?.getFileProcessor(file.getFileTypeName(mime));

                val loans: ArrayList<Loan>? = fileProcessor?.processFile(file.filePath + file.fileName);
                if (loans != null) {
                    val bestLoan = getBestLoan(amountRequested, noOfMonths, loans);
                    if(bestLoan!=null) {
                        val paymentCalculator = PaymentCalculator();
                        val monthlyRepayable = paymentCalculator.calculateMonthlyRepayment(amountRequested.toDouble(), bestLoan.rate, noOfMonths.toDouble() / 12, 1);
                        val totalRepayable = paymentCalculator.calculateTotalAmount(amountRequested.toDouble(), bestLoan.rate, noOfMonths.toDouble(), 1);

                        val quote = Quote(amountRequested, paymentCalculator.roundRate(bestLoan.rate), monthlyRepayable, paymentCalculator.roundIt(totalRepayable, 2));
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
                println("It is not possible to provide a quote at this time.");

            }
            return bestLoan;

    }

}



    fun main(args: Array<String>) {
        var fileName:String ="";
        var amountRequested:Double;
        if(args.size > 0){
            for(i:Int in 0..args.size-1){
                if(Validator.isValidString(args[i])){
                    if(i==0){
                        fileName = args[i];
                    }
                    else if(i==1){
                        try{
                            val divider = 100;
                            amountRequested = args[1].toDouble();
                            if(Validator.isValidLoanAmount(amountRequested, divider)){
                                val init: Main = Main();
                                init.startProcess(init.filePath, fileName, amountRequested.toInt() );



                            }else{
                                println("Unfortunately the number entered is not a valid loan amount. Loans have to be egzact multiples of "+ divider)
                            }
                        }catch(e: IllegalArgumentException){
                            println("amount can not be converted to a number.")
                        }

                    }
                }

            }
        }

    }