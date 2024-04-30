package flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteCharacterPropertiesTest {
    @Test
    void testDisplay() {
        String font = "Arial";
        String color = "Red";
        int size = 12;
        ConcreteCharacterProperties properties = new ConcreteCharacterProperties(font, color, size);

        String expected = "Font: Arial, Color: Red, Size: 12";
        String actual = properties.display();

        assertEquals(expected, actual);
    }

}