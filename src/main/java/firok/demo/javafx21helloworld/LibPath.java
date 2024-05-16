package firok.demo.javafx21helloworld;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LibPath
{
    public static String Value = "/lib/x86_64-linux-gnu/libm.so.6";

    public static void init() throws IOException
    {
        var file = new File("./path.txt").getCanonicalFile();
        if(!file.exists()) return;

        try(var in = new Scanner(file, StandardCharsets.UTF_8))
        {
            var line = in.nextLine();
            Value = line.trim();
        }
    }
}
