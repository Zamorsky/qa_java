package LionTests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

//doesHaveMane() - используем параметризацию
//проверка если лев Самец и есть грива Assert.assertTrue(lion.doesHaveMane());
//проверка если лев Самка и у него нет гривы Assert.assertTrue(lion.doesHaveMane());
//проверка если лев непонятного пола и возвращается "Используйте допустимые значения пола животного - самец или самка"

@RunWith(Parameterized.class)
public class LionManeTest {
    private final String sex;
    private final boolean hasMane;
    private Feline felineMock;

    public LionManeTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true}, //есть грива
                {"Самка", false}, //нет гривы
                {"random_String", false}, //неизвестно есть грива или нет
        };
    }

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void lionManeTest() throws Exception {
        if ("Самец".equals(sex) || "Самка".equals(sex)) {
            Lion lion = new Lion(sex, felineMock);
            boolean actual = lion.doesHaveMane();
            assertEquals(hasMane, actual);
        }

        else {
            try {
                Lion lion = new Lion(sex, felineMock);
            }
            catch (Exception e) {
                assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            }
        }
    }
}



