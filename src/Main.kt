import java.nio.file.FileSystems
import java.nio.file.Files;
import java.nio.file.Path;


class Main {

    val filePath: String = "../loan_files";
    val fileName: String = "market";

    fun getMimeType(filePath: String, fileName: String): String {
        var mime :String = "";

        try {
            val path: Path = FileSystems.getDefault().getPath(filePath, fileName)
            mime = Files.probeContentType(path);

        } catch (e: IllegalStateException) {
            println("Could not found file with name: "+fileName);
        }
        return mime
    }

    fun startProcess(filePath: String, fileName: String) {
        var mime = "";
        try {
            val fileProcessorFactory: FileProcessorFactory? = FileProcessorFactory();
            mime = this.getMimeType(filePath, fileName)
            println(mime);
            if(Validator.isValidEnum(mime)){
                val fileProcessor: FileProcessor? = fileProcessorFactory?.getFileProcessor(FileType.valueOf(mime));
                val loans : ArrayList<Loan> = fileProcessor.processFile(filePath+"/"+fileName);
            }
            else{
                throw  IllegalArgumentException();
            }
        } catch (e: IllegalArgumentException) {
            println("Unsupported File Type: "+ mime +". Currently supported files are :" )
            FileType.values().forEach{println(it.name)};
        }

    }
}

    fun main(args: Array<String>) {
        val init: Main = Main();
        init.startProcess(init.filePath, init.fileName);
    }