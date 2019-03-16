import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest
{
    @Test
    void test()
    {
        assertTrue(true);
    }

    @Test
    void testAssertion()
    {
        assertEquals(1 + 1, 2, "Not assert 111");
        assertTrue('a' < 'b', () -> "Not assert 222 a b");
    }
}
