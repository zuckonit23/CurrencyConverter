import com.fasterxml.jackson.databind.JsonNode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String json = ApiClient.getRates();
            JsonNode ratesNode = JsonParser.parseRates(json);

            Scanner scanner = new Scanner(System.in);
            int option;

            do {
                System.out.println("Menú:");
                System.out.println("1) Dólar - Peso argentino");
                System.out.println("2) Peso argentino - Dólar");
                System.out.println("3) Dólar - Real brasileño");
                System.out.println("4) Real brasileño - Dólar");
                System.out.println("5) Dólar - Peso colombiano");
                System.out.println("6) Peso colombiano - Dólar");
                System.out.println("7) Salir del programa");
                System.out.print("Seleccione una opción: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        CurrencyConverter.convertCurrency(ratesNode, "USD", "ARS");
                        break;
                    case 2:
                        CurrencyConverter.convertCurrency(ratesNode, "ARS", "USD");
                        break;
                    case 3:
                        CurrencyConverter.convertCurrency(ratesNode, "USD", "BRL");
                        break;
                    case 4:
                        CurrencyConverter.convertCurrency(ratesNode, "BRL", "USD");
                        break;
                    case 5:
                        CurrencyConverter.convertCurrency(ratesNode, "USD", "COP");
                        break;
                    case 6:
                        CurrencyConverter.convertCurrency(ratesNode, "COP", "USD");
                        break;
                    case 7:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (option != 7);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
