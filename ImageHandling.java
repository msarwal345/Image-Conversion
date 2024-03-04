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
        
        public static URL toURL(String s) throws MalformedURLException {
            URL x=null;
            try {
                x = new URI(s).toURL();
            } 
            catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return x;
        }

        public static void main(String[] args) throws IOException {
            Scanner sc=new Scanner(System.in);
            
            
            String userHome= System.getProperty("user.home");
            String documentsPath = userHome + File.separator + "Documents";
            String downloadsPath = userHome + File.separator + "Downloads";


            System.out.println("Heyy! What do you Have ?");
            System.out.println("Enter '1' if you have an image URL");
            System.out.println("Enter '2' if you have an dowloaded image on your System");

            int n=sc.nextInt();
            sc.nextLine();

            switch(n){
                case 1:
                  System.out.println("Please enter the image URL...");
                  String s=sc.nextLine();
                  System.out.println("Please enter the format you want to convert your image File");
                  System.out.println("Please enter 1 for png file format");
                  System.out.println("Please enter 2 for gif file format");
                  System.out.println("Please enter 3 for bmp file format");
                  System.out.println("Please enter 4 for jpg file format");
                  System.out.println("Please enter 5 for jpeg file format");
                  System.out.println("Please enter 6 for all availabale  file format");
                //   System.out.println("Please enter 1 for png file");
                  int choice=sc.nextInt();

                    try {
                        URL url = toURL(s);
                        BufferedImage image =ImageIO.read(url);

                        File dir=new File("./ImageConversion");
                        if (!dir.exists()){
                                dir.mkdirs();
                        }

                        if(choice == 1){
                            ImageIO.write(image, "png", new File(dir.getPath()+"/LAP.png"));
                        }
                        else if(choice==2){
                            ImageIO.write(image, "gif", new File(dir.getPath()+"/LAP.gif"));
                        }
                        else if(choice==3){
                            ImageIO.write(image, "bmp", new File(dir.getPath()+"/LAP.bmp"));
                        }
                        else if(choice==4){
                            ImageIO.write(image, "jpg", new File(dir.getPath()+"/LAP.jpg"));
                        }
                        else if(choice==5){
                            ImageIO.write(image, "jpeg", new File(dir.getPath()+"/LAP.jpeg"));
                        }
                        else if(choice==6){
                            ImageIO.write(image, "png",  new File(dir.getPath()+"/LAP.png"));
                            ImageIO.write(image, "gif",  new File(dir.getPath()+"/LAP.gif"));
                            ImageIO.write(image, "bmp",  new File(dir.getPath()+"/LAP.bmp"));
                            ImageIO.write(image, "jpg",  new File(dir.getPath()+"/LAP.jpg"));
                            ImageIO.write(image, "jpeg", new File(dir.getPath()+"/LAP.jpeg"));
                        }
                        else {
                            System.out.println("Please enter a valid choice");
                        }
                        System.out.println("Done....");

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                   break;
                case 2:
                System.out.println("Doing....");
                    
            }


    }
}