//***********************************************************************************************************
//Zun Lin
//MediaList
//This program is to create a datebase of different digital media with different size and name.
//************************************************************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class MediaList {
    public static void main(String args[])
    {
        try
        {
            try {
                printHeading(2, "Media List");
                // Check and read command line argument for file name
                String fileName;
                if (args.length > 0) {
                    fileName = args[0];
                } else                //when run the program. and there is there is no command line argument.
                {
                    fileName = promptForFileName();
                }
                Scanner fileReader = openFile(fileName);    //Scanner for the file.
                //declare variables:
                String name = "";
                String artist = "";
                String album = "";
                String firstString = "";
                String line = "";
                int width = 0;
                int height = 0;
                long size = 0;
                ArrayList<DigitalMedia> medias = new ArrayList<DigitalMedia>();
                ArrayList<Image> images = new ArrayList<Image>();
                ArrayList<Song> songs = new ArrayList<Song>();
                while (fileReader.hasNext()) {

                    line = fileReader.nextLine();
                    String[] parts = line.split(":");             //split the line into different parts
                    firstString = parts[0].trim();
                    if (firstString.toLowerCase().equals("s")) {
                        name = parts[1].trim();
                        artist = parts[2].trim();
                        album = parts[3].trim();
                        size = Long.parseLong(parts[4].trim());
                        songs.add(new Song(name, size, artist, album));
                        Collections.sort(songs);

                    }
                    if (firstString.toLowerCase().equals("i")) {
                        name = parts[1].trim();
                        width = Integer.parseInt(parts[2].trim());
                        height = Integer.parseInt(parts[3].trim());
                        size = Long.parseLong(parts[4].trim());
                        images.add(new Image(name, size, width, height));
                        Collections.sort(images);
                    }
                    medias.addAll(images);                     //add image to medias arrayList
                    medias.addAll(songs);                              //add song to medias arrayList
                }
                boolean run = true;
                while (run) {
                    Scanner pick = new Scanner(System.in);             //scanner for input
                    System.out.println("");                    //system output.
                    System.out.println("Enter S to see all the Songs in the Digital Media.");
                    System.out.println("Enter I to see all the Songs in the Digital Media.");
                    System.out.println("Enter Q to Exit the program.");
                    String n = pick.next().toLowerCase();
                    if (n.equals("s")) {
                        for (DigitalMedia each : songs) {
                            System.out.println(each);               //print songs
                        }
                    }
                    if (n.equals("i")) {
                        for (DigitalMedia each : images) {
                            System.out.println(each);               //print images
                        }
                    }
                    if (n.equals("q")) {                              //quit the program
                        System.out.println("Exit the program");
                        run = false;
                    }
                }
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }catch(FileNotFoundException e)
            {
                System.out.println("No file was found.try again.");
            }

    }

    //************************************************************************************************************

    //************************************************************************************************************
    //file validation, make sure the user enter the right file or if there is a file.
    public static Scanner openFile(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        while(!file.exists())
        {
            file = new File(promptForFileName());
        }
        return new Scanner(file);
    }
    //************************************************************************************************************
    //Scanner to scan in the file.
    public static String promptForFileName()
    {
        System.out.println("Enter the file name: ");
        Scanner keyIn = new Scanner(System.in);
        return keyIn.next();
    }
    //************************************************************************************************************
    public static void printHeading(int projectNum, String projectName)   //Header for this program.
    {
        System.out.println("Zun Lin");
        System.out.println("CMSC 256 Spring 2017");
        System.out.println("Programming Project " + projectNum);
        System.out.println(projectName);
        System.out.println();
    }
}
