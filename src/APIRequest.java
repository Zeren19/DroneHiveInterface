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
            //CONNECTION TEST

            URL droneAmountUrl = new URL("http://dronesim.facets-labs.com/api/drones/?format=json");
            connection = (HttpURLConnection) droneAmountUrl.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            //Use BuildJSONObject to build the JSONObject via the desired API return solution.
            String amountOfDrones = BuildJSONObject.Build(connection).get("count").toString();
            System.out.println(amountOfDrones);

            for (int i = 0; i< Integer.parseInt(amountOfDrones); i++){
                URL getDroneDynamics = new URL("http://dronesim.facets-labs.com/api/dronedynamics/?limit=10&offset=10");
                connection = (HttpURLConnection) getDroneDynamics.openConnection();
                connection.setRequestProperty("Authorization", TOKEN);
                connection.setRequestMethod("GET");

            /*
            Call this http://dronesim.facets-labs.com/api/dronedynamics/?limit=10&offset=10 until offset = max
            take the jsonobject, add the dronedynamic to list of data of one drone
            COMPARE JSONOBJECT WITH TYPE IF SAME; ADD TO list OF DRONE DYNAMICS FOR THAT DRONE

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
                */
                System.out.println(i);
            connection.disconnect();
            }
        }
        catch (ParseException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
//dynamics
//drones
//types
//create json from these
