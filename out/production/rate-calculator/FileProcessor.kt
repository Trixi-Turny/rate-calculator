
/**
 * Facilitates Different processor types
 */
interface FileProcessor {
    fun processFile(path: String): ArrayList <Loan> ?
}