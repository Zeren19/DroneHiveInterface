import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//Used to parse server response into a string

public class APIRequest {
    public static void DownloadData() throws IOException {
        final String TOKEN = "TOKEN 984c81a70eda5e46251f28a2d496dd811fb42697";
        try {
            int responseCode;
            URL droneurl = new URL("http://dronesim.facets-labs.com/api/drones/?format=api");
            HttpURLConnection connection = (HttpURLConnection) droneurl.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            //Evaluate whether connection was successful
            responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Exception occurred with response code: " + responseCode);
            }
            else {
                System.out.println("Success! Code:" + responseCode);
            }

            System.out.println(responseCode);
            connection.disconnect();

            URL droneAmountUrl = new URL("http://dronesim.facets-labs.com/api/drones/?format=json");
            connection = (HttpURLConnection) droneAmountUrl.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");
            //Input stream object to read incoming server message
            InputStream inputstream = connection.getInputStream();
            //Save input stream, line by line
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
            StringBuilder response =  new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(" ");
                System.out.println(line);
                response.append(line);
            }
            //String JSONStringObject = response.toString();
            JSONParser parser = new JSONParser();
            JSONObject generalDroneDataJSON = (JSONObject) parser.parse(response.toString());

            //System.out.println(JSONStringObject);
            String amountOfDrones = generalDroneDataJSON.get("count").toString();
            System.out.println(amountOfDrones);

            for (int i = 0; i< Integer.parseInt(amountOfDrones); i++){
            /*
            URL droneData = new URL("http://dronesim.facets-labs.com/api/dronedynamics/"+i);
            connection = (HttpURLConnection) droneData.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");
            inputstream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputstream));
            response =  new StringBuilder();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                response.append(line);
            }
                parser.reset();
                JSONObject droneDataJSON = (JSONObject) parser.parse(response.toString());
                droneDataJSON.get("name");
                drone i = new drone(droneDataJSON.get("name"), droneDataJSON.get("id"));
            }

             */
                System.out.println(i);
            connection.disconnect();
            }
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
//dynamics
//drones
//types
//create json from these
