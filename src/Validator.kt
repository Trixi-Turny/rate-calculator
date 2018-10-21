

object Validator {

    //String validator for filename
    //file exists
    //amount validator


    /**
     * Checks is string is not null ot empty
     * @param s : String - the string we are checking
     */
    fun isValidString(s: String): Boolean = s!=null || !s.equals("") ;


    /**
     * Checks if value is a valid loan amount, multiples of divider provided
     * @param n:Double - the number to check
     * @param divider:Int - the number we should be able to divide the loan amount with no remainder
     */
    fun isValidLoanAmount(n:Double, divider: Int):Boolean = n >= divider && n.rem(divider).equals(0.00);



    fun canBeConvertedToDouble(s:String): Boolean {
        try{
            s.toDouble();
            return true;

        }catch(e: java.lang.NumberFormatException){
            println("Value can not be converted to number.")
            return false
        }

    }
    /**
     * Checks if string provided can be translated to a {@FileType}
     * @param s:String - the string to check
     */
    fun isValidEnum(s:String):Boolean   {

        FileType.values().forEach {

                if(it.fileType == s){
                   return true;
                };
        }
        return false;
    };


    fun isNotNull(obj : Any):Boolean = obj != null;
}