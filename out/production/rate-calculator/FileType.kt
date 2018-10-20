/**
 * Facilitates different types of files according to their mime types
 */
enum class FileType(val fileType: String) {
    CSV("text/csv"), PDF("application/pdf"), TXT("text/plain");
}