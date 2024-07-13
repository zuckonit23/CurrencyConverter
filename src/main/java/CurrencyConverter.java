import com.fasterxml.jackson.databind.JsonNode;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CurrencyConverter {
    public static void convertCurrency(JsonNode ratesNode, String fromCurrency, String toCurrency) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad en " + fromCurrency + ": ");
        double amount = scanner.nextDouble();
        
        double fromRate = ratesNode.path(fromCurrency).asDouble();
        double toRate = ratesNode.path(toCurrency).asDouble();
        
        double convertedAmount = amount * (toRate / fromRate);
        
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(amount + " " + fromCurrency + " = " + df.format(convertedAmount) + " " + toCurrency);
        System.out.print("Presione una tecla para continuar...");
        scanner.nextLine();  // consume newline
        scanner.nextLine();  // wait for user input
    }
}
