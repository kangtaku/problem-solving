import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author kangtaku
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    ARCTIC solver = new ARCTIC();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++)
      solver.solve(i, in, out);
    out.close();
  }

  static class ARCTIC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.readInt(), i, j, cnt = 0;
      double[][] arctic = new double[n][2];
      for (i = 0; i < n; i++) {
        arctic[i][0] = in.readDouble();
        arctic[i][1] = in.readDouble();
      }
      double[][] dists = new double[n][n];
      for (i = 0; i < n; i++) {
        for (j = i + 1; j < n; j++) {
          dists[i][j] = Maths.distance(arctic[i][0], arctic[i][1], arctic[j][0], arctic[j][1]);
          dists[j][i] = Maths.distance(arctic[i][0], arctic[i][1], arctic[j][0], arctic[j][1]);
        }
      }

      double lo = -1, hi = 1001;
      for (i = 0; i < 100; i++) {
        double mid = (lo + hi) / 2.0;
        if (isOkay(dists, mid)) {
          hi = mid;
        } else lo = mid;
      }
      lo = Math.round(lo * 100) / 100d;
      out.printf("%.2f", lo);
      out.println();
    }

    public boolean isOkay(double[][] dists, double dist) {
      int n = dists.length, i, cnt = 1;
      int[] visit = new int[n];
      Queue<Integer> q = new LinkedList<>();
      q.add(0);
      visit[0] = 1;
      while (!q.isEmpty()) {
        int now = q.poll();
        for (i = 0; i < n; i++) {
          if (now == i) continue;
          if (dists[now][i] <= dist && visit[i] == 0) {
            cnt++;
            visit[i] = 1;
            q.add(i);
          }
        }
        if (cnt == n) return true;
      }
      return cnt == n;
    }

  }

  static class Maths {
    public static double distance(double x1, double y1, double x2, double y2) {
      return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

  }

  static class InputReader {
    private InputStream stream;
    private BufferedReader br = null;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
      this.stream = stream;
      this.br = new BufferedReader(new InputStreamReader(stream));
    }

    public int read() {
      if (numChars == -1)
        throw new InputMismatchException();
      if (curChar >= numChars) {
        curChar = 0;
        try {
          numChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (numChars <= 0)
          return -1;
      }
      return buf[curChar++];
    }

    public int readInt() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public String next() {
      return readToken();
    }

    public String readToken() {
      int c;
      while (isSpaceChar(c = read())) ;
      StringBuilder result = new StringBuilder();
      result.appendCodePoint(c);
      while (!isSpaceChar(c = read()))
        result.appendCodePoint(c);
      return result.toString();
    }

    public boolean isSpaceChar(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public double readDouble() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      double res = 0;
      while (!isSpaceChar(c) && c != '.') {
        if (c == 'e' || c == 'E')
          return res * Math.pow(10, readInt());
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
      }
      if (c == '.') {
        c = read();
        double m = 1;
        while (!isSpaceChar(c)) {
          if (c == 'e' || c == 'E')
            return res * Math.pow(10, readInt());
          if (c < '0' || c > '9')
            throw new InputMismatchException();
          m /= 10;
          res += (c - '0') * m;
          c = read();
        }
      }
      return res * sgn;
    }

  }
}


