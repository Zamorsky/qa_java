package LionTests;

import com.example.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

//getKittens() - используем параметризацию

//не имеет смысла делать параметризованную проверку так как lion.getKittens() не может принимать параметры
//и возвращает только значение по умолчанию 1
//логически это можно считать багом так как у льва может быть больше 1 котенка



@RunWith(MockitoJUnitRunner.class)
public class LionKittensTest {

    @Mock
    Feline felineMock;         // Создаём мок Feline для того чтобы разорвать зависимость от Lion


    @Test
    public void lionKittensTest() throws Exception {

        // Определяем поведение мока felineMock
        // Когда выполняется метод getFood мока felineMock с параметром Хищник", то этот метод должен вернуть Мясо
        Mockito.when(felineMock.getKittens()).thenReturn(1);

        // Передаём мок в конструктор Lion
        // создаём льва Самца c моком
        Lion lion = new Lion("Самец", felineMock);

        // Тестируем методы Lion, они будут использовать мок Feline
        // getFood() - не используем параметризацию, так как только один вариант
        // проверка, что список еды льва это еда хищника
        Assert.assertEquals("Ошибка - неправильное количество котят!",1, lion.getKittens());
    }
}

