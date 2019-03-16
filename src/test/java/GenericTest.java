import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GenericTest
{
    @Test
    void test()
    {
        assertTrue(true);
    }

    /**
     * Ковариантность
     * Можно только читать значения
     * Добавить можно только null
     */
    @Test
    void covariant()
    {
        List<Integer> ints = new ArrayList<Integer>();
        List<? extends Number> nums = ints; // Producer
        // nums.add(4);  // Нельзя добавлять кроме null  
        nums.add(null);
        Number num1 = nums.get(0);
        assertNull(num1);
    }

    /**
     * Контрвариантность
     * Можно только записывать значения
     * Исключение - вычитывание типа Object
     */
    @Test
    void contrvariant()
    {
        List<Number> nums = new ArrayList<Number>();
        List<? super Integer> ints = nums;
        nums.add(5);
        // Integer int1 = nums.get(0); // Нельзя читать значения
        Object obj1 = nums.get(0);
        assertEquals(5, (int)obj1);
    }
}
