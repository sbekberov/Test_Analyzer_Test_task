package portaone.View;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class TextAnalyzerView {
    private Scanner scanner;

    private static final String USER_CHOICE_PROMPT = "Choose an action:";
    private static final String ENTER_TEXT_OR_USE_EXAMPLE = "1) Enter your text\n2) Use the example\n3) Read text from a file";
    private static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Enter a number corresponding to the option:";
    private static final String ENTER_TEXT_MESSAGE = "Enter your text:";
    private static final String EXAMPLE_TEXT = "The Tao gave birth to machine language.  Machine language gave birth to the assembler.\n" +
            "The assembler gave birth to the compiler.  Now there are ten thousand languages.\n" +
            "Each language has its purpose, however humble.  Each language expresses the Yin\n" +
            "and Yang of software.  Each language has its place within the Tao. But do not\n" +
            "program in COBOL if you can avoid it.\n" +
            "-- Geoffrey James, \"The Tao of Programming\"";
    private static final String SAVE_FILE_PATH_PROMPT = "Enter the path to save the result (or just the file name to save in the project root):";
    private static final String INVALID_SAVE_CHOICE_MESSAGE = "Invalid choice. Enter 1 to save the result or 2 to exit the program.";
    private static final String SAVE_RESULT_MESSAGE = "Result saved to the file: ";
    private static final String FIRST_UNIQUE_CHARACTERS_MESSAGE = "First unique characters in each word:";
    private static final String NON_REPEATING_CHARACTER_MESSAGE = "First non-repeating character: ";

    public TextAnalyzerView() {
        scanner = new Scanner(System.in);
    }

    public int getUserChoice() {
        int choice;

        while (true) {
            try {
                System.out.println(USER_CHOICE_PROMPT);
                System.out.println(ENTER_TEXT_OR_USE_EXAMPLE);
                choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1 || choice == 2 || choice == 3) {
                    break;
                } else {
                    System.out.println(INVALID_CHOICE_MESSAGE);
                }
            } catch (NumberFormatException e) {
                System.out.println(INVALID_CHOICE_MESSAGE);
            }
        }

        return choice;
    }

    public String getUserText() {
        System.out.println(ENTER_TEXT_MESSAGE);

        StringBuilder sb = new StringBuilder();
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            sb.append(line).append("\n");
        }

        return sb.toString().trim();
    }

    public String getExampleText() {
        return EXAMPLE_TEXT;
    }

    public String getSaveFilePath() {
        System.out.println(SAVE_FILE_PATH_PROMPT);
        String filePath = scanner.nextLine();

        if (!filePath.contains(File.separator)) {
            String rootDir = System.getProperty("user.dir");
            filePath = rootDir + File.separator + filePath;
        }

        return filePath;
    }

    public String getFilePathFromUser() {
        System.out.println("Enter the path to the file:");
        return scanner.nextLine();
    }

    public void displayResult(char result) {
        System.out.println("\nFirst unique character: " + result);
    }

    public void displayFirstUniqueCharacters(List<Character> characters) {
        System.out.println("\n" + FIRST_UNIQUE_CHARACTERS_MESSAGE);
        for (char c : characters) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void displayFinalResult(char character) {
        System.out.println(NON_REPEATING_CHARACTER_MESSAGE + character);
    }

    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    public int getSaveChoice() {
        int choice;

        while (true) {
            System.out.println(USER_CHOICE_PROMPT);
            System.out.println("1) Save the result to a file\n2) Exit the program");

            String input = scanner.nextLine();

            try {
                choice = Integer.parseInt(input);

                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println(INVALID_SAVE_CHOICE_MESSAGE);
                }
            } catch (NumberFormatException e) {
                System.out.println(INVALID_CHOICE_MESSAGE);
            }
        }

        return choice;
    }

    public void displaySaveMessage(String filePath) {
        System.out.println(SAVE_RESULT_MESSAGE + filePath);
    }

    public void closeScanner() {
        scanner.close();
    }
}
