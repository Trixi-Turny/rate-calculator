import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path

/**
 * store information about a File
 */
data class File(val filePath: String, val fileName: String) {


    /**
     * gets the mime type information of this file
     */
    fun getMimeType(): String {
        var mime: String = "";

        try {
            val path: Path = FileSystems.getDefault().getPath(this.filePath, this.fileName)
            mime = Files.probeContentType(path);

        } catch (e: IllegalStateException) {
            throw  IllegalArgumentException("Could not find file with name: " + this.fileName);
        }
        return mime
    }


    fun getFileTypeName(mime: String): FileType {
        return FileType.values().filter({ it.fileType == mime })[0];
    }
}