package ru.netology.geo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @BeforeAll
    static void setUp() {
        System.out.println("Начало теста");
    }

    @AfterEach
    void tearDown() {
        System.out.println("\nОкончание теста");
    }


    @DisplayName("Тест должен выдать сша")
    @Test
    void byIpTest() {
        final var ip = GeoServiceImpl.NEW_YORK_IP;
        final var country = Country.USA;
        final var street = " 10th Avenue";
        final var city = "New York";


        GeoServiceImpl geoService = new GeoServiceImpl();
        final Location actual = geoService.byIp(ip);

        Assertions.assertEquals(country, actual.getCountry());
        Assertions.assertEquals(street, actual.getStreet());
        Assertions.assertEquals(city, actual.getCity());
    }

    @DisplayName("Тест на неизвестные координаты")
    @Test
    void byIpTestNull() {
        final String ip = "111.";

        Location expected = null;

        GeoServiceImpl geoService = new GeoServiceImpl();
        final Location actual = geoService.byIp(ip);

        Assertions.assertEquals(expected, actual);
    }


    @DisplayName("Тест на разные - ip России")
    @ValueSource(strings = {GeoServiceImpl.MOSCOW_IP, "172."})
    @ParameterizedTest
    void byIpTestParams(String ip) {
        final var country = Country.RUSSIA;
        final var street = "Lenina";

        GeoServiceImpl geoService = new GeoServiceImpl();
        final Location actual = geoService.byIp(ip);

        Assertions.assertEquals(country, actual.getCountry());
    }

    @DisplayName("Тест на исключение")
    @Test
    void byCoordinatesException() {
        final var latitude = 0;
        final var longitude = 0;

        GeoServiceImpl geoService = new GeoServiceImpl();

        assertThrows(RuntimeException.class, () -> geoService.byCoordinates(latitude, longitude));
    }


    @DisplayName("Тест на исключение-текстОшибки")
    @Test
    void byCoordinatesExceptionText() {

        final var latitude = 0;
        final var longitude = 0;

        GeoServiceImpl geoService = new GeoServiceImpl();

        var actual = assertThrows(RuntimeException.class,
                () -> {
                    geoService.byCoordinates(latitude, longitude);
                });

        assertEquals("Not implemented", actual.getMessage());
    }
}