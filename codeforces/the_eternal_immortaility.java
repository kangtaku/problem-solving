package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String a = in.readToken(), b = in.readToken();
        if (a.equals("0")) {
            out.println("0");
            return;
        }
        int aLast = a.charAt(a.length() - 1) - '0';
        int c = aLast;
        BigInteger ba = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        BigInteger bc = bb.subtract(ba);
        int dif;
        if (bc.compareTo(BigInteger.valueOf(5L)) > 0) {
            out.println("0");
        } else {
            dif = bc.intValue();
            int cc = c + 1;
            c = 1;
            for (int i = 0; i < dif; i++) {
                c = c * cc;
                cc++;
            }
            String aa = String.valueOf(c);
            out.println(aa.charAt(aa.length()-1));
        }
    }
}
