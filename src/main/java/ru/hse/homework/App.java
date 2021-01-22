package ru.hse.homework;

import ru.hse.homework.data.Location;
import ru.hse.homework.utils.Client;

import java.util.Optional;

public class App {
    public static void main(String[] args) {
        String resultString;
        Client client = new Client();
        Optional<Location> userLocationOptional = client.getLocation();

        if (userLocationOptional.isPresent()) {
            Location userLocation = userLocationOptional.get();
            resultString = String.format("Страна:%s\nОбласть:%s\nГород:%s\nШирота:%s\nДолгота:%s",
                    userLocation.getCountryName(), userLocation.getRegionName(), userLocation.getCity(),
                    userLocation.getLatitude(), userLocation.getLongitude());

        } else {
            resultString = "Не удалось получить местонаходение пользователя!";
        }

        System.out.println(resultString);

    }
}
