import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String apiKey = "dcaa93706bfad2b2d3cd4c9b";
        boolean running = true;
        double convertedValue;

        while (running) {
            Scanner scanner = new Scanner(System.in);
            Exchange exchange;

            System.out.println("""
                    =============================================================
                    Seja bem vindo/a ao conversor de moedas =]
                    
                    1) Dólar =>> Real
                    2) Real =>> Dólar
                    3) Euro =>> Real
                    4) Real =>> Euro
                    5) Dólar =>> Euro
                    6) Euro =>> Dólar
                    7) Sair
                    
                    Escolha uma opção válida:
                    =============================================================
                    """);

            String opcao = scanner.nextLine();

            if (opcao.equals("7")) {
                running = false;
                System.out.println("Encerrando o algoritmo.");
                break;
            };

            System.out.println("Qual o valor para conversão?");
            double value = scanner.nextDouble();

            switch (opcao) {
                case "1":
                    exchange = callApi(apiKey, "USD");
                    convertedValue = value * exchange.getBRL();
                    System.out.printf(exchangeMsg(value, "USD", convertedValue, "BRL"));
                    break;
                case "2":
                    exchange = callApi(apiKey, "BRL");
                    convertedValue = value * exchange.getUSD();
                    System.out.printf(exchangeMsg(value, "BRL", convertedValue, "USD"));
                    break;
                case "3":
                    exchange = callApi(apiKey, "EUR");
                    convertedValue = value * exchange.getBRL();
                    System.out.printf(exchangeMsg(value, "EUR", convertedValue, "BRL"));
                    break;
                case "4":
                    exchange = callApi(apiKey, "BRL");
                    convertedValue = value * exchange.getEUR();
                    System.out.printf(exchangeMsg(value, "BRL", convertedValue, "EUR"));
                    break;
                case "5":
                    exchange = callApi(apiKey, "USD");
                    convertedValue = value * exchange.getEUR();
                    System.out.printf(exchangeMsg(value, "USD", convertedValue, "EUR"));
                    break;
                case "6":
                    exchange = callApi(apiKey, "EUR");
                    convertedValue = value * exchange.getUSD();
                    System.out.printf(exchangeMsg(value, "EUR", convertedValue, "USD"));
                    break;
                default:
                    System.out.println("Valor incorreto.");
                    break;
            }
        }


    }

    public static Exchange callApi(String apiKey, String currency) {
        ApiRequest apiRequest = new ApiRequest(apiKey, currency);
        return apiRequest.getExchange();
    }

    public static String exchangeMsg(double value, String currency, double convertedValue, String convertedTo) {
        return String.format("Valor %.2f [%s] corresponde ao valor final de =>> %.2f%n [%s]", value, currency, convertedValue, convertedTo);
    }
}
