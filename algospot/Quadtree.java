import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    QUADTREE solver = new QUADTREE();
    solver.solve(1, in, out);
    out.close();
  }

  static class QUADTREE {
    int idx;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      for (int i = 0; i < n; i++) {
        String tree = in.next();
        idx = -1;
        out.println(quadtree(tree));
      }
    }

    public String quadtree(String tree) {
      idx++;
      if (tree.charAt(idx) != 'x') {
        return String.valueOf(tree.charAt(idx));
      }
      String a = quadtree(tree);
      String b = quadtree(tree);
      String c = quadtree(tree);
      String d = quadtree(tree);
      return "x" + c + d + a + b;
    }

  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

  }
}

