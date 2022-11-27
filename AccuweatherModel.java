package HomeWork7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.security.cert.CertPathBuilder;


public class AccuweatherModel extends WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/291605

    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";

    private static final String API_KEY = "KGas4OG9T8hmjJc06yV1uL8BGAEn7fVe";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(String city, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl url = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey())
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

              Request request = new Request.Builder()
                      .url(url)
                      .build();

              Response oneDayResponse = okHttpClient.newCall(request).execute();
              String weatherResponse = oneDayResponse.body().string();

                System.out.println(weatherResponse);
                break;

                case FIVE_DAY:
                    //http://dataservice.accuweather.com/forecasts/v1/daily/5day/291605

                    //HttpUrl url = new HttpUrl.Builder()
                            .scheme(PROTOCOL)
                            .host(BASE_HOST)
                            .addPathSegment(FORECASTS)
                            .addPathSegment(VERSION)
                            .addPathSegment(DAILY)
                            .addPathSegment(FIVE_DAY)
                            .addPathSegment("291605")
                            .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                            .build();

                    Request request = new Request.Builder()
                            .url(url)
                            .build();

                    Response fiveDayResponse = okHttpClient.newCall(request).execute();
                    //String weatherResponse = fiveDayResponse.body().string();

                    System.out.println(weatherResponse);
                    break;

        }

    }

    private CertPathBuilder url(HttpUrl url) {
    }

    private HttpUrl.Builder scheme(String protocol) {
        return null;
    }

    private String detectCityKey() throws IOException {
        //http://dataservice.accuweather.com/forecasts/v1/cities/autocomplete
        String city;
        HttpUrl url = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                //.addPathSegment(FIVE_DAY)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", city)
                .build();

        HttpUrl httpUrl;
        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response fiveDayResponse = okHttpClient.newCall(request).execute();
        String responseString = fiveDayResponse.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        System.out.println(responseString);

        return cityKey;
    }


    }


