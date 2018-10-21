
import javax.swing.text.html.parser.DTDConstants.CURRENT

/**
 * Factory for various file processor types
 */
class FileProcessorFactory() {
    final val csvProcessor: FileProcessor = CsvProcessor();
    final val txtProcessor: FileProcessor = TxtProcessor();

    fun getFileProcessor(fileType: FileType): FileProcessor? {
        when (fileType) {
            FileType.CSV -> return csvProcessor
            FileType.TXT -> return txtProcessor
            else -> return null
        }
    }
}