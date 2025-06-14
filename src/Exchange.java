public class Exchange {
    private String base_code;
    private ConversionRates conversion_rates;

    public String getBase_code() {
        return base_code;
    }

    public double getUSD() {
        return conversion_rates.getUSD();
    }

    public double getEUR() {
        return conversion_rates.getEUR();
    }

    public double getBRL() {
        return conversion_rates.getBRL();
    }
}
