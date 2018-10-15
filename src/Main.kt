import java.io.File
import java.nio.file.FileSystems
import java.nio.file.Files;
import java.nio.file.Path;

class Main {

    val filePath: String = "../loan_files";

    val path: Path = FileSystems.getDefault().getPath(filePath, "market.txt");

    val file: String = Files.probeContentType(path);

    fun printIt() {
        println(file);
    }
}

fun main (args : Array<String>) {
    val init: Main = Main();
    init.printIt();
}