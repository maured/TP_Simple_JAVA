import java.io.*;
import java.util.Scanner;

public class EcritureFichier {

    //ici je créé une méthode qui prend en paramètre le PATH d'un fichier
    // Je check si le fichier existe ou pas et selon le resultat je le créé ou j'écris directement dedans

    public static void ecritureFichier(String path)
    {
        File file = new File(path);
        FileWriter fileW;

        try
        {
            if (file.createNewFile())
            {
                fileW = new FileWriter(file);
                System.out.println("File created");
                Scanner sc = new Scanner(System.in);
                String str = "";

                System.out.println("Veuillez écrire le mot \"quit\" pour arreter l'écriture dans le fichier");
                while (!str.equalsIgnoreCase("quit"))
                {
                    str = sc.nextLine();
                    fileW.write(str);
                }
                fileW.close();
            }
            else
            {
                fileW = new FileWriter(file);
                Scanner sc = new Scanner(System.in);
                String str = "";

                System.out.println("Veuillez écrire le mot \"quit\" pour arreter l'écriture dans le fichier");
                while (!str.equalsIgnoreCase("quit"))
                {
                    str = sc.nextLine();
                    fileW.write(str);
                }
                fileW.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
