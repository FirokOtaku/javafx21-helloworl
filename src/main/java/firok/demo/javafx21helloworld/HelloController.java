package firok.demo.javafx21helloworld;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

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
    private WebView wv;

    private void testJNA(double numA, double numB)
    {
        try
        {
            System.out.println("测试 JNA 框架");
            var libm = Libm.INSTANCE;
            var max = libm.fmax(numA, numB);
            var min = libm.fmin(numA, numB);
            var cos = libm.cosl(numA);
            var sin = libm.sinl(numA);
            System.out.println("max = " + max + ", min = " + min + ", cos = " + cos + ", sin = " + sin);

            System.out.println("测试 JNA 框架成功");
        }
        catch (Throwable any)
        {
            any.printStackTrace(System.err);
            System.out.println("测试 JNA 框架发生错误");
        }
    }
    private void testJNI(double numA, double numB)
    {
        try
        {
            System.out.println("测试 JNI 框架");
            var libi = new Libi();
            var max = libi.fmax(numA, numB);
            var min = libi.fmin(numA, numB);
            var cos = libi.cosl(numA);
            var sin = libi.sinl(numA);
            System.out.println("max = " + max + ", min = " + min + ", cos = " + cos + ", sin = " + sin);

            System.out.println("测试 JNI 框架成功");
        }
        catch (Throwable any)
        {
            any.printStackTrace(System.err);
            System.out.println("测试 JNI 框架发生错误");
        }
    }
    private void testWebView()
    {
        try
        {
            System.out.println("测试 WebView");

            var url = HelloApplication.class.getResource("/firok/demo/javafx21helloworld/index.html");
            var res = String.valueOf(url);
            System.out.println(res);
            wv.getEngine().load(res);

            System.out.println("测试 WebView 完成");
        }
        catch (Throwable any)
        {
            any.printStackTrace(System.err);
            System.out.println("测试 WebView 发生错误");
        }
    }

    @FXML
    private void onBtnClick()
    {
        double numA, numB;
        try
        {
            numA = Double.parseDouble(tfA.getText());
            numB = Double.parseDouble(tfB.getText());
            System.out.println("numA = " + numA + ", numB = " + numB);
        }
        catch (Exception any)
        {
            any.printStackTrace(System.err);
            System.out.println("数字转换发生错误");
            return;
        }

        testJNA(numA, numB);
        testJNI(numA, numB);
        testWebView();
    }

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
        tfA.setText("3.14");
        tfB.setText("1");
    }
}
