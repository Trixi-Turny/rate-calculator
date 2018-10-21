/**
 * Handling loan quotations
 */

class Quote( val amount: Int, val rate:Double?, val monthlyAmount:Double?, val totalAmount:Double?) {
    override fun toString(): String{
        val quote ="Requested Amount: £"+amount +"\nRate: "+ rate+ "\nMonthly repayment: £" + monthlyAmount + "\nTotal repayment: £"+ totalAmount;
        return quote;
    }
}