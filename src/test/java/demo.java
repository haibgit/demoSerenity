import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class demo {
    public static void main(String[] args) throws IOException {
        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setLanguage("vie");
//            tesseract.setDatapath(System.getenv("TESSDATA_PREFIX"));
            tesseract.setDatapath("/usr/local/Cellar/tesseract/4.1.1/share/tessdata/");


            // the path of your tess data folder
            // inside the extracted file
            String text = tesseract.doOCR(new File(System.getProperty("user.dir") + "/demo2.png"));

            // path of your image file
            System.out.print(text);
//            if (text.contains("Invalid username or password!"))
//                System.out.println("pass");
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }

    public static Boolean readImageAndVerifyContain(String expected) throws IOException {
        String path = System.getProperty("user.dir");
        Runtime.getRuntime().exec("cd " + path);
        Runtime.getRuntime().exec("tesseract demo.png out");

        String fileName = path + "/out.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> stringList = new ArrayList<>();
        boolean status = false;
        while ((line = br.readLine()) != null) {
            stringList.add(line);
        }
        for (String index : stringList) {
            if (index.contains(expected)) {
                status = true;
                break;
            }
        }
        return status;
    }


}
