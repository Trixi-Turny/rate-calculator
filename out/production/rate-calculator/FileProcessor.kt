
import java.io.File

interface FileProcessor {
    fun processFile(file: File): ArrayList <Loan>
}