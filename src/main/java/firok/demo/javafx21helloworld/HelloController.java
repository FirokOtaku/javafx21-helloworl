package firok.demo.javafx21helloworld;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController
{
    @FXML
    private Label welcomeText;

    @FXML
    private TextField tfA;

    @FXML
    private TextField tfB;

    @FXML
    private Button btn;

    @FXML
    private void onBtnClick()
    {
        var libm = Libm.INSTANCE;
        try
        {
            var numA = Double.parseDouble(tfA.getText());
            var numB = Double.parseDouble(tfB.getText());
            System.out.println("numA = " + numA + ", numB = " + numB);
            var max = libm.fmax(numA, numB);
            var min = libm.fmin(numA, numB);
            var cos = libm.cosl(numA);
            var sin = libm.sinl(numA);
            System.out.println("max = " + max + ", min = " + min + ", cos = " + cos + ", sin = " + sin);
        }
        catch (Exception any)
        {
            System.err.println("发生错误");
            any.printStackTrace(System.err);
        }
    }

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
