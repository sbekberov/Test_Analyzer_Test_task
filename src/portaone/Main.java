package portaone;

import portaone.Model.TextAnalyzerModel;
import portaone.Controller.TextAnalyzerController;
import portaone.View.TextAnalyzerView;


public class Main {
    public static void main(String[] args) {
        TextAnalyzerModel model = new TextAnalyzerModel();
        TextAnalyzerView view = new TextAnalyzerView();
        TextAnalyzerController controller = new TextAnalyzerController(model, view);

        controller.processUserInput();

        view.closeScanner();
    }
}
