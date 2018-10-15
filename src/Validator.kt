object Validator {

    //String validator for filename
    //file exists
    //amount validator

    fun isValidEnum(s:String): Boolean  = s in FileType.values().map{it.name};
    fun isValidString(s: String): Boolean = s!=null;
    fun isValidLoanAmount(n:Double, divider: Int):Boolean = n.rem(divider).equals(0);


}