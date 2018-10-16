class Quote( val amount: Double, val rate:Double?, val monthlyAmount:Double?, val totalAmount:Double?) {
    override fun toString(): String{
        val s ="Requested Amount: £"+amount +"\nRate:"+ rate+ "\nMonthly repayment: £" + monthlyAmount + "\nTotal repayment: £"+ totalAmount;
        return s;
    }
}