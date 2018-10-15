import java.io.File
import java.nio.file.FileSystems
import javax.swing.filechooser.FileNameExtensionFilter
import java.nio.file.Files;
import java.nio.file.Path;

class Main {

    val filePath :String  = "./loan_files/market.csv";

    val path: Path = FileSystems.getDefault().getPath("../loan_files", "market.csv");

    val file: String = Files.probeContentType(path);

    fun printIt() {
        println(file);
    }

    fun main(args : Array<String>) {
        printIt();
    }

    }

