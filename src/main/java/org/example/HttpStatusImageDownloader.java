package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.example.Utils.*;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws  Exception{
        String url = new HttpStatusChecker().getStatusImage(code);
        try(InputStream inputStream = new URL(url).openStream()){
            String path = DIRECTORY_FOR_SAVE + code + EXTENSION;
            if(!new File(path).exists()){
                Files.copy(inputStream, Paths.get(path));
            } else{
                System.out.println(String.format(FILE_ALREADY_EXIST_TEXT,code));
            }
        } catch (Exception e){
            throw new FileNotFoundException(String.format(FILE_NOT_FOUND_EXCEPTION_TEXT, code));
        }
    }
}
