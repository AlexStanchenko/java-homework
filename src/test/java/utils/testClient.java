package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.hse.homework.data.Location;
import ru.hse.homework.utils.Client;

public class testClient {



    private Client client;


    @DisplayName("Получение и Парс JSON строки первый тест")
    @Test
    public void testJSONParser() {
        client = new Client("85.249.41.225");
        Location actual = client.getLocation().get();

        Location expected = new Location();
        expected.setIp("85.249.41.225");
        expected.setCountryCode("RU");
        expected.setCountryName("Russia");
        expected.setRegionCode("MOW");
        expected.setRegionName("Moscow");
        expected.setCity("Moscow");
        expected.setZipCode("125009");
        expected.setTimeZone("Europe/Moscow");
        expected.setLatitude(55.7527);
        expected.setLongitude(37.6172);
        expected.setMetroCode(0L);

        Assertions.assertEquals(expected,actual);

    }

    @DisplayName("Получение и Парс JSON строки второй тест")
    @Test
    public void testJSONParser_2() {
        client = new Client("169.249.41.225");
        Location actual = client.getLocation().get();

        Location expected = new Location();
        expected.setIp("169.249.41.225");
        expected.setCountryCode("US");
        expected.setCountryName("United States");
        expected.setRegionCode("");
        expected.setRegionName("");
        expected.setCity("");
        expected.setZipCode("");
        expected.setTimeZone("America/Chicago");
        expected.setLatitude(37.751);
        expected.setLongitude(-97.822);
        expected.setMetroCode(0L);

        Assertions.assertEquals(expected,actual);

    }
}
