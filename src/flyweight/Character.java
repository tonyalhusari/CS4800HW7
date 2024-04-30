package flyweight;

import java.io.Serializable;

public class Character implements Serializable {
    private char value;
    private CharacterProperties properties;
    private int row;
    private int column;

    public Character(char value, CharacterProperties properties, int row, int column) {
        this.value = value;
        this.properties = properties;
        this.row = row;
        this.column = column;
    }

    // Getters
    public char getValue() {
        return value;
    }

    public CharacterProperties getProperties() {
        return properties;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "flyweight.Character{" +
                "value=" + value +
                ", properties= [" + properties.display() + "]" +
                ", row=" + row +
                ", column=" + column +
                '}';
    }
}