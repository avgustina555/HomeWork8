package HomeWork7;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static HomeWork7.Period.FIVE_DAY;
import static HomeWork7.Period.NOW;

public class Controller {
    private WeatherModel weatherModel = new AccuweatherModel();

    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, NOW);
        variants.put(5, FIVE_DAY);
    }

    public void getWeather(String userInput, String cityName) throws IOException {
        Integer command = Integer.parseInt(userInput);

        switch (variants.get(command)) {
            case NOW:
                weatherModel.getWeather(cityName, NOW);
                break;
            case FIVE_DAY:
                weatherModel.getWeather(cityName, FIVE_DAY);
                break;

        }
    }
}

