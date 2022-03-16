import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CodeTest {
    @Test
    public void testSayHello(){
        Code code = new Code();
        assertEquals("Hello World!", code.sayHello());

    }
}
