import com.example.Alex;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class) // Указываем, что будем использовать MockitoJUnitRunner для работы с моками
public class AlexTests {

    @Mock
    Feline felineMock; // Создаем мок для класса Feline. Это нужно для разрыва зависимости от реальной реализации Feline в классе Alex

    // Тест для метода getKittens() класса Alex
    @Test
    public void alexKittensTest() throws Exception {
        // Создаем объект Alex, передавая в него мок felineMock
        Alex alex = new Alex(felineMock);

        // Проверяем, что метод getKittens() возвращает правильное количество котят (0, так как Алекс не имеет котят)
        Assert.assertEquals("Ошибка - вернулось неправильное количество котят Алекса!", 0, alex.getKittens());
    }

    // Тест для метода getPlaceOfLiving() класса Alex
    @Test
    public void alexPlaceTest() throws Exception {
        // Создаем объект Alex, передавая в него мок felineMock
        Alex alex = new Alex(felineMock);

        // Проверяем, что метод getPlaceOfLiving() возвращает правильное место обитания (Нью-Йоркский зоопарк)
        Assert.assertEquals("Ошибка - вернулось неправильное место обитания Алекса!", "Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    // Тест для метода getFriends() класса Alex
    @Test
    public void alexFriendsTest() throws Exception {
        // Создаем объект Alex, передавая в него мок felineMock
        Alex alex = new Alex(felineMock);

        // Проверяем, что метод getFriends() возвращает правильный список друзей (Марти, Глория, Мелман)
        Assert.assertEquals("Ошибка - вернулся неправильный список друзей Алекса!", List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }
}
