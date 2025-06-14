import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    private Exchange exchange;
    public ApiRequest(String apiKey, String currency) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, currency)))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            this.exchange = gson.fromJson(response.body(), Exchange.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Sem resposta do pedido.");
        }
    }

    public Exchange getExchange() {
        return exchange;
    }
}
