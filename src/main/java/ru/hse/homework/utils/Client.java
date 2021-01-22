package ru.hse.homework.utils;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.hse.homework.data.Location;

import java.util.Optional;

public class Client {
    /**
     * константа - строка подключения по умолчанию
     */
    private static final String DEFAULT_CONNECT_STRING = "https://freegeoip.app/json/";
    /**
     * поле - строка подключения
     */
    private final String connectString;

    /**
     * Создает экземпляр класса со строкой подключения по умолчанию
     *
     * @see #Client(String)
     */
    public Client() {
        connectString = DEFAULT_CONNECT_STRING;
    }

    /**
     * Создает экземпляр класса с уникальной строкой подключения
     *
     * @param ip ip адрес пользователя
     * @see #Client()
     */
    public Client(String ip) {
        connectString = DEFAULT_CONNECT_STRING + ip;
    }

    /**
     * Получает местонахождение пользователя
     *
     * @return Местонахождение пользователя
     */
    public Optional<Location> getLocation() {

        ClientConfig clientConfig = new DefaultClientConfig();
        com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(clientConfig);
        WebResource webResource = client.resource(connectString);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        // Статус 200 = успешно
        if (response.getStatus() != 200) {
            System.out.println("Failed with HTTP Error code: " + response.getStatus());
            String error = response.getEntity(String.class);
            System.out.print("Error: " + error);
            return Optional.empty();
        }

        String output = response.getEntity(String.class);

        try {
            return Optional.of(parseJSON(output));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            return Optional.empty();
        }

    }

    /**
     * Создает экземпляр класса {@link Location} из JSON строки
     *
     * @param jsonString JSON строка
     * @return экземпляр класса {@link Location}
     * @throws ParseException если произошла ошибка при парсинге JSON строки
     */
    private Location parseJSON(String jsonString) throws ParseException {

        Object obj = new JSONParser().parse(jsonString);
        JSONObject jo = (JSONObject) obj;

        String ip = (String) jo.get("ip");
        String countryCode = (String) jo.get("country_code");
        String countryName = (String) jo.get("country_name");
        String regionCode = (String) jo.get("region_code");
        String regionName = (String) jo.get("region_name");
        String city = (String) jo.get("city");
        String zipCode = (String) jo.get("zip_code");
        String timeZone = (String) jo.get("time_zone");
        Double latitude = (Double) jo.get("latitude");
        Double longitude = (Double) jo.get("longitude");
        Long metroCode = (Long) jo.get("metro_code");

        return new Location(ip, countryCode, countryName,
                regionCode, regionName, city, zipCode,
                timeZone, latitude, longitude, metroCode);
    }

}
