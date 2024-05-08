package modulos;

import java.util.Map;
import java.util.Set;

public class Moneda {
    private String time_last_update_utc;

    private Map<String, Double> conversionRates;

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public void setConversion_rates(Map<String, Double> conversionRates){
        this.conversionRates = conversionRates;
    }

    public String getTime_last_update_utc(){
        return time_last_update_utc;
    }

    //Obtener solo los codigos de monedas
    public Set<String> getCodigosMoneda(){
        return conversionRates.keySet();
    }
}
