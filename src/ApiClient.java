import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private final HttpClient client = HttpClient.newHttpClient();

    public String fetchQuestions(int amount, String difficulty, String type){
        String url = "https://opentdb.com/api.php?amount=" + amount + "&difficulty=" + difficulty + "&type=" + type;

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> resp = null;
        try{
            resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        }
        catch(IOException | InterruptedException e){
            throw new RuntimeException("Failed to fetch questions: " + e.getMessage(), e);
        }
        if(resp == null){
            throw new RuntimeException("No response from API.");
        }

        return resp.body();
    }
}
