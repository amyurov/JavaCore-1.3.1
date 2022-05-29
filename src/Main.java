import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder log = new StringBuilder();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss.SS");
        File root = new File("F://Game");

        File srcDir = new File(root, "src");
        File resDir = new File(root, "res");
        File savegamesDir = new File(root, "savegames");
        File tempDir = new File(root, "temp");
        File mainDir = new File(srcDir, "main");
        File testDir = new File(srcDir, "test");
        File drawablesDir = new File(resDir, "drawables");
        File vectorsDir = new File(resDir, "vectors");
        File iconsDir = new File(resDir, "icons");

        File mainJava = new File(mainDir, "Main.java");
        File utilsJava = new File(mainDir, "Utils.java");
        File tempTxt = new File(tempDir, "temp.txt");

        File[] directoriesArray = {srcDir, resDir, savegamesDir, tempDir, mainDir,
                testDir, drawablesDir, vectorsDir, iconsDir};

        for (File file : directoriesArray) {
            if (file.mkdir()) {
                log.append(formatForDateNow.format(dateNow));
                log.append(" Директория ");
                log.append(file.getName());
                log.append(" создана\n");
            } else {
                log.append("Ошибка создания директории ");
                log.append(file.getName());
                log.append("\n");
            }
        }

        File[] filesAray = {mainJava, utilsJava, tempTxt};
        for (File file : filesAray) {
            if (file.createNewFile()) {
                log.append("Файл ");
                log.append(file.getName());
                log.append(" создан\n");
            } else {
                log.append("Ошибка создания файла ");
                log.append(file.getName());
                log.append("\n");
            }
        }

        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(tempTxt))) {
            logWriter.write(log.toString());
            logWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
