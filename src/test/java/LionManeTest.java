import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) // Указываем, что этот тест параметризован
public class LionManeTest {
    private final String sex; // Пол льва ("Самец", "Самка" или случайная строка)
    private final boolean hasMane; // Ожидаемое значение: есть грива или нет
    private Feline felineMock; // Мок объекта Feline для тестирования Lion

    // Конструктор класса теста, куда передаются параметры
    public LionManeTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    // Параметры для теста (пол льва и ожидаемый результат наличия гривы)
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},  // Если лев самец, ожидаем, что грива будет (true)
                {"Самка", false}, // Если лев самка, ожидаем, что гривы не будет (false)
                {"random_String", false}, // Если пол неизвестен, проверяем, что будет выброшено исключение
        };
    }

    // Метод выполняется перед каждым тестом: создаем мок объекта Feline
    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class); // Создаем мок Feline
    }

    // Основной тест для проверки метода doesHaveMane()
    @Test
    public void lionManeTest() throws Exception {
        // Если пол "Самец" или "Самка", тестируем корректность наличия гривы
        if ("Самец".equals(sex) || "Самка".equals(sex)) {
            Lion lion = new Lion(sex, felineMock); // Создаем объект Lion
            boolean actual = lion.doesHaveMane(); // Проверяем, есть ли у льва грива
            assertEquals(hasMane, actual); // Сравниваем ожидаемый и фактический результат
        }

        // Если пол неизвестен (не "Самец" и не "Самка"), проверяем, что выбрасывается исключение
        else {
            try {
                Lion lion = new Lion(sex, felineMock); // Пытаемся создать объект Lion с неизвестным полом
            } catch (Exception e) {
                // Проверяем, что выброшено правильное исключение с ожидаемым сообщением
                assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            }
        }
    }
}
