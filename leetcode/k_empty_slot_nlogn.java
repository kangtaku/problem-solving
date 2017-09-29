class Solution {
  public int kEmptySlots(int[] flowers, int k) {
    TreeSet<Integer> ts = new TreeSet<>();
    for (int i = 0; i < flowers.length; i++) {
      Integer flower = flowers[i];
      ts.add(flower);
      Integer lo = ts.lower(flower);
      Integer hi = ts.higher(flower);
      if (lo != null && diff(flower, lo) == k + 1) return i + 1;
      if (hi != null && diff(flower, hi) == k + 1) return i + 1;
    }
    return -1;
  }

  public int diff(Integer a, Integer b) {
    return Math.abs(a - b);
  }
}

