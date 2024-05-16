package firok.demo.javafx21helloworld;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Libm extends Library
{
    Libm INSTANCE = Native.load(LibPath.Value, Libm.class);

    double fmax(double a, double b);

    double fmin(double a, double b);

    double cosl(double num);

    double sinl(double num);
}
