import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new SwingGUI();
        APIRequest.test();
    }
}
/* The APIRequest class should request how many drones exist
and than should iterate that amount via another API Request for each drone
and generate that amount of drone objects from the drone class

After that it should be stored somewhere, maybe in main()? or a local DB(?)
These stored values are than getting read by the swingGUI and get displayed.
 */