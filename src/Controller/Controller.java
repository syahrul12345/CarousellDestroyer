package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.*;

public class Controller {
    @FXML
    private TextArea TermsAndConditionText;
    @FXML
    private GridPane gridPane;
    @FXML
    private HBox HBox;

    public void initialize() {
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        gridPane.getColumnConstraints().add(column1);
        gridPane.setPrefSize(700,400);
        HBox.setSpacing(5);


        File file = new File("/Users/muhdsyahrulnizam/Downloads/CarousellDestroyer/Resources/files/TOC.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
            fr.close();
            TermsAndConditionText.appendText(stringBuffer.toString());


        } catch (FileNotFoundException e) {
            TermsAndConditionText.appendText("TOC FILE MISSING");
        } catch (IOException e) {
            TermsAndConditionText.appendText("TOC FILE PRESENT,BUT FAILED TO READ");
        }

    }

    public void agreeSelected(ActionEvent actionEvent) throws IOException {
       Stage stage = (Stage) gridPane.getScene().getWindow();
       stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/mainmenu.fxml"));
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Carousell Destroyer");
        secondaryStage.setScene(new Scene(root,658,550));
        secondaryStage.show();

    }

    public void cancelSelected(ActionEvent actionEvent) {
        System.exit(0);
    }
}
