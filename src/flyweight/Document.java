package flyweight;

import java.io.*;
import java.util.ArrayList;

class Document implements Serializable {
    private ArrayList<Character> content = new ArrayList<>();

    // Method to add a character with specified properties to the document
    public void addCharacter(char value, String font, String color, int size, int row, int column) {
        CharacterProperties properties = CharacterPropertiesFactory.getCharacterProperties(font, color, size);
        Character character = new Character(value, properties, row, column);
        content.add(character);
    }

    // Method to save the document to a file
    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(content);
        }
        catch (IOException e) {
            System.out.println("Error occurred while saving the document: " + e.getMessage());
        }
    }

    // Method to load the document from a file
    public void loadFromFile(String fileName) throws IOException, ClassCastException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?> tempList) {
                content = new ArrayList<>();
                for (Object item : tempList) {
                    if (item instanceof Character) {
                        content.add((Character) item);
                    } else {
                        throw new ClassCastException("Object is not an ArrayList of characters");
                    }
                }
            } else {
                throw new ClassCastException("Object is not an ArrayList");
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error occurred while loading the document: " + e.getMessage());
        }
    }


    // Method to display the document content with character positions
    public void display() {
        for (Character character: content) {
            System.out.println(character.toString());
        }

    }
}
