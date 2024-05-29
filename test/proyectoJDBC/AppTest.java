package proyectoJDBC;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {

	@Test
    public void testEsSiBien() {
        assertTrue(App.esSi("si"));
        assertTrue(App.esSi("sí"));
        assertTrue(App.esSi("S"));
    }
	
	@Test
	public void testEsSiMal() {
		assertTrue(App.esSi("no"), "Está mal");
		assertTrue(App.esSi("nO"), "Está mal");
		assertTrue(App.esSi("n"), "Está mal");
		assertTrue(App.esSi(null), "Está mal");
    }
}
