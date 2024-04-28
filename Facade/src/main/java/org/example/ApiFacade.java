package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiFacade {
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {
        String jsonResult = getJsonFromApi(urlString);

        return extractAttributeValueFromJson(jsonResult, attributeName);
    }

    private String getJsonFromApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    private String extractAttributeValueFromJson(String json, String attributeName)
            throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            Object attributeValue = jsonObject.get(attributeName);
            if (attributeValue == null) {
                throw new IllegalArgumentException("Attribute not found: " + attributeName);
            }

            if (attributeValue instanceof JSONObject) { // If it's a JSON, return it as is
                return attributeValue.toString();
            } else if (attributeValue instanceof String) { // If it's a String, return it
                return (String) attributeValue;
            } else {
                throw new IllegalArgumentException("Unexpected attribute value type: " + attributeValue.getClass());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error extracting attribute: " + e.getMessage());
        }
    }


}

