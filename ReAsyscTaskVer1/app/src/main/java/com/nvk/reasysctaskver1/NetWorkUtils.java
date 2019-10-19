package com.nvk.reasysctaskver1;

import android.net.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetWorkUtils {
    // chạy file gốc trong -> tap-tho có file api.php
    //mỏ cmd -> php -S 0.0.0.0:8000
    // mở trình duyệt nhập địa chỉ IP của máy :8000/api.php -> OK


    //private static final String BASE_URL = "http://192.168.1.248/tap-tho/";
    private static final String BASE_URL = "http://192.168.43.137:8000/";

    public static String convertToString(InputStream inputStream){
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;

        try{
            while ((line = reader.readLine()) != null){
                builder.append(line);
                builder.append("\n");
            }
        }catch (IOException err){
            err.printStackTrace();
        }finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        if (builder.length() == 0){
            return  null;
        }

        return builder.toString();
    }

    public static  String getJSONData(String uri ,String method){
        HttpURLConnection urlConnection = null;
        String jsonString = null;
        Uri builtUri = Uri.parse(BASE_URL + uri).buildUpon().build();
        try {
            URL requestURL = new URL(builtUri.toString());
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod(method);
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            jsonString = convertToString(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }

        }
        return jsonString;
    }

}
