import com.example.Feline;
import com.example.Lion;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CatSoundTest {
    Cat cat;

    @Mock
    Feline felineMock;

    @Before
    public void init() {
        cat = new Cat(felineMock);
    }

    @Test
    public void catSoundTest() throws Exception {
        Assert.assertEquals("Ошибка - кошка издала неправильный звук!", "Мяу", cat.getSound());
    }

    @Test
    public void catFoodTest() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals("Ошибка - вернулось неправильное семейство!",List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}

