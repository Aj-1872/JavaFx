package basic;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PokemonController {

    @FXML
    private Button button1; // Button to open Arceus page

    @FXML
    private Button button2; // Button to open Pikachu page

    private List<Pokemon> pokemons = new ArrayList<>(); // ArrayList to hold Pokemon objects

    @FXML
    private void handleButton1Action() {
        openFXML("Arceus.fxml"); // Open the Arceus page
    }

    @FXML
    private void handleButton2Action() {
        openFXML("Pikachu.fxml"); // Open the Pikachu page
    }

    // Open an FXML file in a new stage
    private void openFXML(String fxmlResource) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlResource));

        try {
            Parent root = fxmlLoader.load();

            // Set text from file to text elements
            Text text1 = (Text) root.lookup("#text1");
            if (text1 != null) {
                text1.setText(readTextFromFile("text1.txt"));
            }

            Text text2 = (Text) root.lookup("#text2");
            if (text2 != null) {
                text2.setText(readTextFromFile("text2.txt"));
            }

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read text from a file and return as a string
    private String readTextFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (InputStream inputStream = getClass().getResourceAsStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // Nested class to represent a Pokemon
    private class Pokemon {
        private String name;
        private String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }
    }

    // Method to add a new Pokemon to the list
    public void addPokemon(String name, String type) {
        pokemons.add(new Pokemon(name, type));
    }
}
