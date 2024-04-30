package flyweight;

import java.io.IOException;

public class DocumentDriver {
    public static void main(String[] args) {
        Document document = new Document();

        // Add characters with different variations
        addVariation(document, "HelloWorldCS5800", "Arial", "Red", 12, 0);


        addVariation(document, "HelloWorldCS5800", "Calibri", "Blue", 14, 1);


        addVariation(document, "HelloWorldCS5800", "Verdana", "Red", 16, 2);


        addVariation(document, "HelloWorldCS5800", "Verdana", "Black", 12, 3);


        // Save the document to a file
        try {
            document.saveToFile("document.dat");
            System.out.println("flyweight.Document saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving the document: " + e.getMessage());
        }

        // Clear the document content
        document = new Document();

        // Load the document from the file
        try {
            document.loadFromFile("document.dat");
            System.out.println("\nflyweight.Document loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while loading the document: " + e.getMessage());
        }

        // Display the loaded document
        System.out.println("\nLoaded document content:");
        document.display();
    }

    // Method to add characters with different variations
    private static void addVariation(Document document, String text, String font, String color, int size, int row) {
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            document.addCharacter(character, font, color, size, row, i);
        }
    }
}