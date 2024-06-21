import java.io.IOException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
//Used to parse server response into a string
import java.io.FileWriter;
import java.util.Objects;

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
            connection.disconnect();
            //CONNECTION TEST

            URL droneAmountUrl = new URL("http://dronesim.facets-labs.com/api/drones/?format=json");
            connection = (HttpURLConnection) droneAmountUrl.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            //Use BuildJSONObject to build the JSONObject via the desired API return solution.
            String amountOfDrones = BuildJSONObject.Build(connection).get("count").toString();
            System.out.println(amountOfDrones);
            String URLString = "http://dronesim.facets-labs.com/api/dronedynamics/?format=json&offset=0";
            JSONObject DroneDynamicsDatabase = new JSONObject();
            while (true){
                URL getDroneDynamics = new URL(URLString);
                connection = (HttpURLConnection) getDroneDynamics.openConnection();
                connection.setRequestProperty("Authorization", TOKEN);
                connection.setRequestMethod("GET");

                JSONObject DroneDynamics = BuildJSONObject.Build(connection);
                JSONArray results = (JSONArray) DroneDynamics.get("results");
                for (Object o : results) {
                    JSONObject obj = (JSONObject) o;
                    System.out.println(obj.get("last_seen").toString());
                }
                FileWriter fileWriter = new FileWriter("TESTDatabase.json", true);
                    fileWriter.append(results.toJSONString());
                    fileWriter.append(" ");
                    fileWriter.close();
                    connection.disconnect();
                System.out.println(DroneDynamics.get("next").toString());
                if (DroneDynamics.get("next").toString().equals("http://dronesim.facets-labs.com/api/dronedynamics/?format=json&limit=10&offset=30"))
                    break;
                
                if (DroneDynamics.get("next") == null)
                    break;
                URLString = DroneDynamics.get("next").toString();
            }   //Download the drone dynamics, goes through all and stops by itself using the "next" tag in the jsons.
        }
        catch (ParseException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}