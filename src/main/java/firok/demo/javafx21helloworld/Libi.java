package firok.demo.javafx21helloworld;

public class Libi
{
    static
    {
        System.load(LibPath.Value);
    }

    native double fmax(double a, double b);

    native double fmin(double a, double b);

    native double cosl(double num);

    native double sinl(double num);
}
