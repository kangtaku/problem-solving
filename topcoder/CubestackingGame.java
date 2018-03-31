public class CubeStackingGame {
    public int ans = -1;
    public int[] c1,c2,c3,c4;
    public boolean[][] used = new boolean[4][10];
    public int MaximumValue(int n, int[] c1, int[] c2, int[] c3, int[] c4) {
      int i, j;
      this.c1=c1;
      this.c2=c2;
      this.c3=c3;
      this.c4=c4;
      find(0);
      return ans;
    }
    public void find(int x) {
      if (ans < x) {
        ans = x;
      }
      if (x == c1.length) return;
      for (int i =0; i < 3; i++) {
        if (!used[0][c1[x]]
            && !used[1][c2[x]]
            && !used[2][c3[x]]
            && !used[3][c4[x]]) {
          used[0][c1[x]] = true;
          used[1][c2[x]] = true;
          used[2][c3[x]] = true;
          used[3][c4[x]] = true;
          find(x + 1);
          used[0][c1[x]] = false;
          used[1][c2[x]] = false;
          used[2][c3[x]] = false;
          used[3][c4[x]] = false;
        }
        rotate(x);
      }
      upsideDown(x);
      for (int i =0; i < 3; i++) {
        if (!used[0][c1[x]]
            && !used[1][c2[x]]
            && !used[2][c3[x]]
            && !used[3][c4[x]]) {
          used[0][c1[x]] = true;
          used[1][c2[x]] = true;
          used[2][c3[x]] = true;
          used[3][c4[x]] = true;
          find(x + 1);
          used[0][c1[x]] = false;
          used[1][c2[x]] = false;
          used[2][c3[x]] = false;
          used[3][c4[x]] = false;
        }
        rotate(x);
      }
    }

    public void upsideDown(int x) {
      int t=c1[x];
      c1[x]=c4[x];
      c4[x]=t;
      t=c2[x];
      c2[x]=c3[x];
      c3[x]=t;
    }
    public void rotate(int x) {
      int t = c1[x];
      c1[x] = c2[x];
      c2[x] = c3[x];
      c3[x] = c4[x];
      c4[x] = t;
    }
  }
