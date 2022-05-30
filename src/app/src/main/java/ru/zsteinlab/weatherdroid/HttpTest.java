package ru.zsteinlab.weatherdroid;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpTest {

    public static void main(String[] args) throws Exception {

        String url = "http://ip-api.com/json/";
        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        System.out.println("Send 'HTTP GET' request to : " + url);

        Integer responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = inputReader.readLine()) != null) {
                response.append(inputLine);
            }

            String lol = response.toString();

            inputReader.close();
            Map<String,Object> result =
                    new ObjectMapper().readValue(lol, HashMap.class);

            System.out.println(result.get("query"));
        }
    }

}