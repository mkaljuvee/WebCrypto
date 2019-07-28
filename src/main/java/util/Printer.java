package util;

import static java.lang.System.*;

public class Printer {
    public static void p(Object p, boolean newline) {
        out.println(p + (newline ? "\n" : ""));
    }

    public static void p(Object p) {
        p(p, true);
    }
}
