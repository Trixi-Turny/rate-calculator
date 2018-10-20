object Validator {

    //String validator for filename
    //file exists
    //amount validator


    fun isValidString(s: String): Boolean = s!=null || !s.equals("") ;
    fun isValidLoanAmount(n:Double, divider: Int):Boolean = n.rem(divider).equals(0.00)
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