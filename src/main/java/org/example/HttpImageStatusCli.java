package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        try{
            int inputCode = scanner.nextInt();
            HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
            try{
                downloader.downloadStatusImage(inputCode);
                System.out.println("Image download successfully");
            } catch (Exception e) {
                System.out.println("There is no image for HTTP status " + inputCode);
            }
        } catch (InputMismatchException e){
            System.out.println("Please enter a valid number.");
        }
    }
}
