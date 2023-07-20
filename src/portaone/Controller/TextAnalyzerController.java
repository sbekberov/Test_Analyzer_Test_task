package portaone.Controller;

import portaone.Model.TextAnalyzerModel;
import portaone.View.TextAnalyzerView;
import portaone.File.TextAnalyzerFileWriter;
import portaone.File.TextAnalyzerFileReader;

import java.io.IOException;
import java.util.List;

public class TextAnalyzerController {
    private final TextAnalyzerModel model;
    private final TextAnalyzerView view;

    public TextAnalyzerController(TextAnalyzerModel model, TextAnalyzerView view) {
        this.model = model;
        this.view = view;
    }

    public void processUserInput() {
        int choice = view.getUserChoice();
        String text;

        if (choice == 1) {
            text = view.getUserText();
        } else if (choice == 2) {
            text = view.getExampleText();
        } else if (choice == 3) {
            String filePath = view.getFilePathFromUser();
            try {
                text = TextAnalyzerFileReader.readTextFromFile(filePath);
            } catch (IOException e) {
                view.displayError("An error occurred while reading the file. Please try again.");
                return;
            }
        } else {
            System.out.println("Invalid choice. Please enter a valid option.");
            return;
        }

        List<Character> firstUniqueChars = model.findFirstUniqueCharactersInWords(text);
        view.displayFirstUniqueCharacters(firstUniqueChars);

        char finalResult = model.findFirstUniqueCharInList(firstUniqueChars);
        view.displayFinalResult(finalResult);

        int saveChoice = view.getSaveChoice();
        if (saveChoice == 1) {
            String filePath = view.getSaveFilePath();
            String resultToSave = "First unique characters in each word:\n";
            for (char c : firstUniqueChars) {
                resultToSave += c + " ";
            }
            resultToSave += "\nFirst non-repeating character: " + finalResult;

            try {
                TextAnalyzerFileWriter.saveResultToFile(resultToSave, filePath);
                view.displaySaveMessage(filePath);
            } catch (IOException e) {
                view.displayError("An error occurred while saving the result to the file.");
            }
        } else if (saveChoice == 2) {
            System.out.println("Exiting the program.");
        } else {
            System.out.println("Invalid choice. Program will be closed.");
        }
    }
}