package modsChecker;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Checker {
    //We obtain the user folder
    String home = System.getProperty("user.home");
    //With the user folder, we manage to go to the mods directory.
    Path modsDir = Paths.get(home).resolve("Documents/Euro Truck Simulator 2/mod");
    public static final String RESET = "\u001B[00m";

    //Method to check if the mods folder exists.
    public void CheckModsDir() {
        if (Files.exists(modsDir)) {
            System.out.println("Accesing: " + modsDir.toAbsolutePath());
        } else {
            System.out.println("ERROR, the folder does not exist.");
        }
    }


    public void CheckExtension() {
        File[] modsListNames = modsDir.toFile().listFiles();
        int modsZip = 0;
        int modsScs = 0;
        ArrayList<String> zipModsList = new ArrayList<>();
        if (modsListNames != null) {
            for (File modFile : modsListNames) {
                //We only process if its a file and we save the file.
                if (modFile.isFile()) {
                    String fullName = modFile.getName(); //We save the name of each file.

                    //We get the extension of the file.
                    String extension = "";
                    int i = fullName.lastIndexOf('.');
                    if (i > 0) {
                        extension = fullName.substring(i + 1).toLowerCase();
                    }
                    //Depening on the extension, we increment the number of the mods with x extension.
                    if (extension.equals("scs")){
                        modsScs ++;
                    } else if (extension.equals("zip")) {
                        modsZip++;
                        zipModsList.add(fullName); //We save the name of the file that is .zip
                    }

                }
            }
        }
        System.out.println("\u001B[32m" + "Files with .scs extension: " + modsScs + RESET);
        if (modsZip>0){
            System.out.println("\u001B[31m" + "Files with .zip extesion (probably won't work): " + modsZip + RESET + "\nList of the files with the .zip extenion: " + zipModsList);
            System.out.println("Make sure you know this file needs to be with the .zip extension in order to work.");
        }else {
            System.out.println("You don't have .zip files :) Nice!");
        }

    }


}
