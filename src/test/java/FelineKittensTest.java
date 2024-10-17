import com.example.Feline;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;
import org.junit.Test;

@RunWith(Parameterized.class) // Указываем, что тест будет параметризован
public class FelineKittensTest {
    private final Integer kittensSet;  // Поле для хранения значения параметра, который мы будем передавать в метод getKittens (может быть null)
    private final int kittensGet;      // Ожидаемое значение, которое метод должен вернуть
    private Feline feline;             // Экземпляр класса Feline, который мы будем тестировать

    // Конструктор, который принимает параметры для теста: kittensSet — значение, передаваемое в метод, kittensGet — ожидаемое значение результата
    public FelineKittensTest(Integer kittensSet, int kittensGet) {
        this.kittensSet = kittensSet;
        this.kittensGet = kittensGet;
    }

    // Параметры для теста. В этом методе задаются наборы данных, которые будут передаваться в тест.
    // Каждый массив {kittensSet, kittensGet} содержит:
    // kittensSet — передаваемое значение в метод, kittensGet — ожидаемое значение результата.
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {0, 0},         // Если передаём 0 котят, ожидаем результат 0
                {1, 1},         // Если передаём 1 котёнка, ожидаем результат 1
                {500, 500},     // Если передаём 500 котят, ожидаем результат 500
                {null, 1}       // Если не передаём значение (null), ожидаем результат по умолчанию — 1
        };
    }

    // Метод init будет выполняться перед каждым тестом.
    // В нем мы создаем новый экземпляр класса Feline.
    @Before
    public void init() {
        feline = new Feline(); // Инициализация объекта класса Feline перед каждым запуском теста
    }

    // Основной тест для проверки метода getKittens у класса Feline
    @Test
    public void felineKittensTest() throws Exception {
        int actualKittens; // Переменная для хранения фактического результата

        // Если kittensSet равен null, то вызываем метод getKittens без параметра
        if (kittensSet == null) {
            actualKittens = feline.getKittens(); // Метод без параметра должен вернуть значение по умолчанию (1)
        } else {
            // Если kittensSet не равен null, вызываем перегруженный метод getKittens с параметром
            actualKittens = feline.getKittens(kittensSet); // Метод с параметром возвращает переданное значение kittensSet
        }

        // Проверяем, что фактическое значение совпадает с ожидаемым
        Assert.assertEquals("Ошибка! Неправильное количество котят вернулось методом getKittens", kittensGet, actualKittens);
    }
}
