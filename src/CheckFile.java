import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;

public class CheckFile {
    private String firstPath = "";
    private boolean recursivePath = false;

    //Ici je créé un constructeur
    public CheckFile(String path, Boolean subFolder)
    {
        super();
        this.firstPath = path;
        this.recursivePath = subFolder;
    }

    //methode plus simple à appeler
    public void list(){
        this.listOfDirectory(this.firstPath);
    }

    //methode principale qui prend le chemin en paramètre.
    // J'instancie une classe File qui prendra mon PATH en paramètre
    // Je créer un tableau de la classe File et je le parcours
    // Et tant qu'il y a des fichier / dossier je continue de le parcourir puis je les affiches au fur et à mesure.

    private void listOfDirectory(String dir)
    {
        File file = new File(dir);
        File [] files = file.listFiles();
        if (files != null)
        {
            for (int i = 0; i <files.length; i++)
            {
                if (files[i].isDirectory() == true)
                    System.out.println("Dossier: " + files[i].getAbsolutePath());
                else
                    System.out.println("Fichier : " + files[i].getName());

                if (files[i].isDirectory() == true && this.recursivePath == true)
                    this.listOfDirectory(files[i].getAbsolutePath());
            }
        }
    }
}

