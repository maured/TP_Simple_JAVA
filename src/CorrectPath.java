import java.io.File;

public class CorrectPath {
    public static void CheckPath(String path)
    {
        File file = new File(path);
        if (file.exists() && file.isDirectory() == true)
            System.out.println("Chemin correct : Vous pointez vers un Dossier");
        else if (file.exists() && file.isFile() == true)
            System.out.println("Chemin correct : Vous pointez vers un Fichier");
        else
            System.out.println("Chemin incorrect");
    }
}
