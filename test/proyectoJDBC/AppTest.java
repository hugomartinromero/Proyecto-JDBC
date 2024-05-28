package proyectoJDBC;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {

	@Test
    public void testEsSi() {
        assertTrue(App.esSi("si"));
        assertTrue(App.esSi("sí"));
        assertTrue(App.esSi("S"));
        
        assertFalse(App.esSi("no"));
        assertFalse(App.esSi("nO"));
        assertFalse(App.esSi("n"));
        assertFalse(App.esSi(null));
    }
}
