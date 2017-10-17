import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez le type de recherche que vous voulez effectuer : ");
        System.out.println("Tapez 1 : Recherchez n'importe quel fichier / dossier");
        System.out.println("Tapez 2 : Recherchez des fichiers par son extension");
        System.out.println("Tapez 3 : Vérifiez si le chemin existe ; Si oui dire si c'est un fichier ou un dossier");
        System.out.println("Tapez 4 : Sauvegardez dans un fichier tout ce que vous écrirez");
        System.out.println("Tapez 5 : Copiez le contenu d'un fichier dans un autre fichier");
        System.out.println("Tapez 6 : Copiez le contenu d'une image sur internet dans un fichier");
        int user_choice = sc.nextInt();

        switch (user_choice)
        {
            case 1 :
                Scanner path = new Scanner(System.in);
                System.out.println("Rentrez le chemin du dossier à parcourir");
                String my_path = path.nextLine();
                CheckFile checkFile = new CheckFile(my_path, true);
                checkFile.list();
                break;

            case 2 :
                System.out.println("Rentrez le chemin du dossier à parcourir");
                Scanner scan = new Scanner(System.in);
                String dirPath = scan.nextLine();

                System.out.println("Rentrez le filtre que vous voulez appliquer");
                Scanner scanner = new Scanner(System.in);
                String filter = scanner.next();

                ParseFile.list(dirPath, filter);
                break;

            case 3:
                System.out.println("Rentrez le chemin à parcourir");
                Scanner correctPath = new Scanner(System.in);
                String pathCorrect = correctPath.nextLine();
                CorrectPath.CheckPath(pathCorrect);
                break;

            case 4 :
                System.out.println("Rentrez le chemin du fichier à parcourir");
                System.out.println("Si vous souhaitez créer un fichier, rentrez le PATH puis rajoutez \\nom_de_votre_fichier");

                Scanner filePath = new Scanner(System.in);
                String pathFile = filePath.nextLine();

                EcritureFichier.ecritureFichier(pathFile);
                break;

            case 5 :

                System.out.println("Veuillez saisir le PATH vers votre 1er fichier : \\nom_de_votre_img.jpg");
                Scanner fileIn = new Scanner(System.in);
                String inFile = fileIn.nextLine();

                System.out.println("Veuillez saisir le PATH vers votre 2nd fichier : \\nom_de_votre_img.jpg");
                Scanner fileOut = new Scanner(System.in);
                String outFile = fileOut.nextLine();
                JavaFileCopier.copier(inFile,outFile);
                break;

            case 6 :
                String imageUrl = "https://www.w3schools.com/css/img_fjords.jpg";

                System.out.println("Veuillez saisir le PATH vers votre destination de stockage puis tapez : \\nom_de_votre_img.jpg");
                Scanner destinationImage = new Scanner(System.in);
                String destinationFile = destinationImage.nextLine();

                SaveImageFromUrl.saveImage(imageUrl, destinationFile);
        }
    }
}