import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class JavaHttpsTest {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java JavaHttpsTest <URL>");
            System.exit(1);
        }

        String targetUrl = args[0];
        System.out.println("Testing URL: " + targetUrl);

        try {
            URL url = new URL(targetUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

            // Optional: Force TLS 1.2 (uncomment if needed)
            // System.setProperty("https.protocols", "TLSv1.2");

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "*/*");

            System.out.println("Response Code: " + conn.getResponseCode());
            System.out.println("Response Headers: " + conn.getHeaderFields());

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line); // Print response body
                }
            }
        } catch (Exception e) {
            System.err.println("Error accessing URL: " + targetUrl);
            e.printStackTrace();
        }
    }
}
