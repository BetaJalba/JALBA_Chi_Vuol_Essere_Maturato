import com.google.gson.*;
import com.google.gson.GsonBuilder;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        Scanner sc = new Scanner(System.in);

        System.out.print("Insert el numero: ");
        int amount = sc.nextInt();

        ApiResponse apiResponse = apiClient.fetchQuestions(amount, "easy", "multiple");

        if (apiResponse.responseCode != 0)
            return;

        for (ApiQuestion question : apiResponse.results) {
            System.out.println(question.question);
        }
    }
}
