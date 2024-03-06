import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * ImageHandling
 */

public class ImageHandling {
    //Created a function to convert the URI to URL
    public static URL toURL(String s) throws MalformedURLException {
        URL x = null;
        try {
            x = new URI(s).toURL();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return x;
    }

    //Created a Function to handle Conversiom
    public void ImageConversion(BufferedImage image,int choice,String pathString,String fileName){
        int flag=0;
        String bmpFileName= "/"+fileName+".bmp";
        String gifFileName= "/"+fileName+".gif";
        String jpgFileName= "/"+fileName+".jpg";
        String jpegFileName="/"+fileName+".jpeg";
        String pngFileName= "/"+fileName+".png";

        File dir = new File(pathString);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            if (choice == 1) {
                ImageIO.write(image, "png", new File(dir.getPath() + pngFileName));
            } 
            else if (choice == 2) {
                ImageIO.write(image, "gif", new File(dir.getPath() + gifFileName));
            } 
            else if (choice == 3) {
                ImageIO.write(image, "bmp", new File(dir.getPath() + bmpFileName));
            } 
            else if (choice == 4) {
                ImageIO.write(image, "jpg", new File(dir.getPath() + jpgFileName));
            } 
            else if (choice == 5) {
                ImageIO.write(image, "jpeg", new File(dir.getPath() + jpegFileName));
            } 
            else if (choice == 6) {
                ImageIO.write(image, "png", new File(dir.getPath() + pngFileName));
                ImageIO.write(image, "gif", new File(dir.getPath() + gifFileName));
                ImageIO.write(image, "bmp", new File(dir.getPath() + bmpFileName));
                ImageIO.write(image, "jpg", new File(dir.getPath() + jpgFileName));
                ImageIO.write(image, "jpeg",new File(dir.getPath() + jpegFileName));
            } 
            else {
                flag=1;
                System.out.println("Please enter a valid choice");
            }
            
        } catch (Exception e) {
           System.err.println(e.getMessage());
        }

        if(flag==0){
        System.out.println("Done...");
        }
    }
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedImage image=null;

        System.out.println("Heyy! What do you Have ?");
        System.out.println("Enter '1' if you have an image URL");
        System.out.println("Enter '2' if you have an dowloaded image on your System");

        int n = sc.nextInt();
        sc.nextLine();

         // Asking what does the user have a File Path or a URL??
        switch (n) {
            case 1:
                System.out.println("Please enter the image URL...");
                String s = sc.nextLine();
                try {
                    URL url = toURL(s);
                     image = ImageIO.read(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                System.out.println("Please enter the path of the file");
                File file = new File(sc.nextLine());
                 image = ImageIO.read(file);
                break;
            
            default:
               System.out.println("Please select the valid Number");

        }

        // Asking the user where he wants to store the file
        System.out.println("Where do you want to store the file");
        System.out.println("Please for 1 if you want to store the file in the Downloads");
        System.out.println("Please for 2 if you want to store the file in the Documents");
        System.out.println("Please for 3 if you want to store the file in the a paticular path");
        
        int filePathChoice=sc.nextInt();
        sc.nextLine();

        String userHome = System.getProperty("user.home");
        String documentsPath = userHome + File.separator + "Documents";
        String downloadsPath = userHome + File.separator + "Downloads";

        System.out.println(documentsPath);
        
        String pathname="";

        if(filePathChoice==1){
            pathname=downloadsPath;
        }
        else if(filePathChoice==2){
            pathname=documentsPath;
        }
        else if (filePathChoice==3){
            System.out.println("Please enter the name of the path you want it get stored at ");
            pathname=sc.nextLine();
        }

       // Asking user what name they want to give to their file
       System.out.println("Please Enter the name of the file");
       String fileName=sc.nextLine();


       // What kind of file format the user wants the current file to be converted into
        System.out.println("Please enter the format you want to convert your image File");
        System.out.println("Please enter 1 for png file format");
        System.out.println("Please enter 2 for gif file format");
        System.out.println("Please enter 3 for bmp file format");
        System.out.println("Please enter 4 for jpg file format");
        System.out.println("Please enter 5 for jpeg file format");
        System.out.println("Please enter 6 for all availabale  file format");

        // Asking the choice of the user
        int choice = sc.nextInt();
        
        // Creating the Object of the class ImageHandling
        ImageHandling object=new ImageHandling();
        
        // Calling the function ImageConversion
        object.ImageConversion(image, choice,pathname,fileName);

        sc.close();

    }
}