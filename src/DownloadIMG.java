import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
    public class DownloadIMG {

        public void downloadIMG(String imageUrl)  {
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                URL url = new URL(imageUrl);
                String fileName=url.getFile();
                inputStream = url.openStream();
                if(!new File("./Memes").exists()) {
                    new File("./Memes").mkdirs();
                }
                outputStream = new FileOutputStream("./Memes" + fileName.substring(fileName.lastIndexOf("/")));

                byte[] buffer = new byte[2048];
                int length;

                while ((length = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }

            } catch (MalformedURLException e) {
                System.out.println("MalformedURLException :- " + e.getMessage());

            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException :- " + e.getMessage());

            } catch (IOException e) {
                System.out.println("IOException :- " + e.getMessage());

            } finally {
                try {

                    inputStream.close();
                    outputStream.close();

                } catch (IOException e) {
                    System.out.println("Finally IOException :- " + e.getMessage());
                }
            }
        }

    }
