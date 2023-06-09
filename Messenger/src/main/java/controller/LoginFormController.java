package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {

    public JFXButton btnLogin;
    public AnchorPane loginFormContext;
    public JFXTextField txtUserName;

    public void btnLoginOnAction(ActionEvent actionEvent) {
        try {
            setUI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUI() throws IOException {
        Stage stage1 = (Stage) loginFormContext.getScene().getWindow();
        stage1.close();

        URL resource = getClass().getResource("/view/MainForm.fxml");
        if (resource==null){
            throw new IllegalArgumentException("FXML file not found");
        }
        FXMLLoader loader = new FXMLLoader(resource);
        Parent load = loader.load();
        MaiFormController controller = loader.getController();
        controller.txtName.setText(txtUserName.getText());
        Scene scene = new Scene(load);
        Stage stage2 = new Stage();
        stage2.setTitle("Live Chat Application");
        stage2.setScene(scene);
        stage2.centerOnScreen();
        stage2.show();

    }
}