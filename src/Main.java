import com.google.gson.*;
import com.google.gson.GsonBuilder;


public class Main {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String rawJson = apiClient.fetchQuestions(5, "easy", "multiple");
        JsonElement jsonElement = JsonParser.parseString(rawJson);
        String prettyJson = gson.toJson(jsonElement);

        System.out.println(prettyJson);
    }
}
