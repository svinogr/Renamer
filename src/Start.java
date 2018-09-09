import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Start {
  static String nameOfNewFolder = "C:/test2/";
  static String nameOfInputFolder = "C:/test/";
  static String nameOfBase = "gmssb";



    public static void main(String[] args) {
        String folder = nameOfInputFolder + nameOfBase + "/";
        File inputFolder = new File(folder );
        String[] fileList = inputFolder.list();


        for (String nameString: fileList){
            System.out.println(nameString);
            File file = new File(folder + nameString);
            System.out.println(file.getAbsolutePath());
            File folderToCopy = new File(nameOfNewFolder + nameOfBase);
            File newFile = new File(nameOfNewFolder + nameOfBase + "/" + nameOfBase + "_" + nameString );

            if(!folderToCopy.exists()){
                folderToCopy.mkdir();
            }

            System.out.println(newFile.getAbsolutePath());
            try {

               Files.copy(file.toPath(), newFile.toPath());

            } catch (IOException e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }

        }


    }

}
