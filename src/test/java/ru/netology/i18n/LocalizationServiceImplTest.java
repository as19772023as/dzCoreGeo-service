package ru.netology.i18n;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    private  static  LocalizationServiceImpl localizationService;

    @BeforeAll
    static void setUp() {

        System.out.println("Начало теста");
         localizationService = new LocalizationServiceImpl();
    }

    @AfterEach
    void tearDown() {
        System.out.println("\nОкончание теста");
    }

    @DisplayName("Тест на вывод русского текста")
    @Test
    void localeTestRUS() {
        final var country = Country.RUSSIA;

        final  var expected = "Добро пожаловать";

        final  var actual = localizationService.locale(country);

        assertEquals(expected, actual);

    }

    @DisplayName("Тест на вывод англ. текста1")
    @Test
    void localeTestUsa() {
        final var country = Country.USA;

        final  var expected = "Welcome";

        final  var actual = localizationService.locale(country);

        assertEquals(expected, actual);

    }

    @DisplayName("Тест на вывод англ. текста2")
    @Test
    void localeTestBraz() {
        final var country = Country.BRAZIL;

        final  var expected = "Welcome";

        final  var actual = localizationService.locale(country);

        assertEquals(expected, actual);

    }
//    @DisplayName("Тест на вывод англ. текста")
//    @ParameterizedTest
//    @EnumSource(Country.class)
//    void localeTestUSA(Country country) {
//       // final var country = Country.USA;
//
//        final  var expected = "Welcome";
//
//        final  var actual = localizationService.locale(country);
//
//        assertEquals(expected, actual);
//
//    }
}