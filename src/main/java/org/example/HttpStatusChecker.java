package org.example;

import javax.net.ssl.HttpsURLConnection;

import java.io.FileNotFoundException;
import java.net.URL;

import static org.example.Utils.*;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws Exception{
        String stringUrl = START_URL + code + EXTENSION;
        HttpsURLConnection connection = (HttpsURLConnection) new URL(stringUrl).openConnection();
        int responseCode = connection.getResponseCode();
        if(responseCode == 404){
            throw new FileNotFoundException(String.format(FILE_NOT_FOUND_EXCEPTION_TEXT, code));
        } else{
            return stringUrl;
        }
    }
}
