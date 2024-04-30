package flyweight;

import java.io.Serializable;

class ConcreteCharacterProperties implements CharacterProperties, Serializable {
    private String font;
    private String color;
    private int size;

    public ConcreteCharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    @Override
    public String display() {
        return "Font: " + font + ", Color: " + color + ", Size: " + size;
    }
}