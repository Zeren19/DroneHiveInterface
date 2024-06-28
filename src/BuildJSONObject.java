import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class BuildJSONObject {
    public static JSONObject Build(HttpURLConnection connection) throws IOException, ParseException {
        //Input stream object to read incoming server message
        InputStream inputstream = connection.getInputStream();
        //Save input stream, line by line
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
        StringBuilder response = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            //Debugging ^
            response.append(line);
            response.append('\n');
        }
        reader.close();
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(response.toString());
    }
}
