package com.example.jessica.myapplication;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Connection{

    private final String USER_AGENT = "Mozilla/5.0";


    // HTTP GET request
    public List<Voluntario> sendGet() throws Exception {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //String url = "https://api.myjson.com/bins/i9q5n";
        String url = "https://api.myjson.com/bins/q6em3";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //System.out.println(response.toString());

        List<Voluntario> found = findAllItems(new JSONArray(response.toString()));

        return found;
    }

    public List<Voluntario> findAllItems(JSONArray response) {

        List<Voluntario> found = new LinkedList<Voluntario>();

        try {


            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);
                found.add(new Voluntario(obj.getString("nome"), obj.getString("programa"), obj.getString("local")));
            }

        } catch (JSONException e) {
            // handle exception
        }

        return found;
    }

}