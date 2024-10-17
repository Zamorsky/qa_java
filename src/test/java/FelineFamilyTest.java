import com.example.Feline;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;

public class FelineFamilyTest {
    Feline feline;

    @Before
        public void init() {
           feline = new Feline();
        }

        @Test
        public void felineFamilyTest() {
            Assert.assertEquals("Ошибка - вернулось неправильное семейство!","Кошачьи", feline.getFamily());
        }
}



