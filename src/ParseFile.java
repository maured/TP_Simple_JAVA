import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ParseFile {

    public static void list(String path, String filter){
        listOfFilesByExtension(path, filter);
    }

    //Je créé un tableau de sting contenant l'ensemble des fichiers d'un Dir. Le chemin sera choisi par l'utilisateur
    // je regarde grace à endsWith tous les fichiers correspondant à mon filtre utilisateur puis j'affiche
    // sinon je renvoie une erreur.
    private static void listOfFilesByExtension(String path, String filter)
    {
        String [] s = new File(path).list();

        int i;

        try{
            for(i = 0; i < s.length; i++)
            {
                if(s[i].endsWith(filter) == true)
                    System.out.println(s[i].substring(0,s[i].length()- filter.length()));// on choisit la sous chaine - les x derniers caracteres
            }
        }
        catch (PatternSyntaxException pse) {
            pse.printStackTrace();
        }
    }
}
