import org.junit.Test

import org.junit.Assert.*


class FileTest {



    @Test
    fun getMimeTypeOfCsv_shouldReturn_text_csv() {
        val filePath = "loan_files/";
        val fileName = "market.csv";
        val mime = File(filePath, fileName).getMimeType();
        assertEquals("text/csv", mime);
    }



    @Test
    fun getMimeTypeOfTxt_shouldReturn_text_plain() {
        val filePath = "loan_files/";
        val fileName = "market.txt";
        val mime = File(filePath, fileName).getMimeType();
        assertEquals("text/plain", mime);
    }


    @Test
    fun getFileTypeName_shouldReturnCSVWhenMime_Is_text_csv() {
        val filePath = "loan_files/";
        val fileName = "market.csv";
        val mime = File(filePath, fileName).getMimeType();
        val fileTypeName: FileType = File(filePath, fileName).getFileTypeName(mime);
        assertEquals(FileType.CSV, fileTypeName);

    }

    @Test
    fun getFileTypeName_shouldReturnTXTWhenMime_Is_text_plain() {
        val filePath = "loan_files/";
        val fileName = "market.txt";
        val mime = File(filePath, fileName).getMimeType();
        val fileTypeName: FileType = File(filePath, fileName).getFileTypeName(mime);
        assertEquals(FileType.TXT, fileTypeName);


    }

    @Test
    fun itShouldThrowExceptionWhenNoSuchFile() {
        val filePath = "loan_files/";
        val fileName = "fakeFileName";
        val mime = File(filePath, fileName).getMimeType();
        assertEquals("Could not find file with name: "+fileName,  mime);

    }




}