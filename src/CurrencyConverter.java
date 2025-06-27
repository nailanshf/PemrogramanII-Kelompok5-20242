public class CurrencyConverter {
    public static double convert(double amount, String currency) {
        switch (currency) {
            case "USD": return amount / 16000;
            case "EUR": return amount / 17000;
            case "JPY": return amount / 110;
            case "SGD": return amount / 12000;
            default: return 0;
        }
    }
}