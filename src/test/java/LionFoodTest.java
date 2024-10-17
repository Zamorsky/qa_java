import com.example.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

    @RunWith(MockitoJUnitRunner.class)
    public class LionFoodTest {

        @Mock
        Feline felineMock;         // Создаём мок Feline для того чтобы разорвать зависимость от Lion


        @Test
        public void lionFoodTest() throws Exception {

        // Определяем поведение мока felineMock
        // Когда выполняется метод getFood мока felineMock с параметром Хищник", то этот метод должен вернуть Мясо
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Передаём мок в конструктор Lion
        // создаём льва Самца c моком
        Lion lion = new Lion("Самец", felineMock);

        // Тестируем методы Lion, они будут использовать мок Feline
        // getFood() - не используем параметризацию, так как только один вариант
        // проверка, что список еды льва это еда хищника
        Assert.assertEquals("Ошибка - эта еда не подходит для льва",List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}

