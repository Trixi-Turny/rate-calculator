import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path

class File(val filePath: String, val fileName: String) {

    fun getMimeType(): String {
        var mime: String = "";

        try {
            val path: Path = FileSystems.getDefault().getPath(this.filePath, this.fileName)
            mime = Files.probeContentType(path);

        } catch (e: IllegalStateException) {
            mime = "Could not find file with name: " + this.fileName
            println(mime);
            return mime;

        }
        return mime
    }


    fun getFileTypeName(mime: String): FileType {
        return FileType.values().filter({ it.fileType == mime })[0];
    }
}