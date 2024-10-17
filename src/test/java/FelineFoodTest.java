import com.example.Feline;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineFoodTest {
    Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void felineFoodTest() throws Exception {
        Assert.assertEquals("Ошибка - вернулся неправильный рацион!", List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }
}



