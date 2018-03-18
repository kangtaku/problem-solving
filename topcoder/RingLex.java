public class RingLex {
    public String getmin(String s) {
        int[] ps = new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
        int n = s.length(), ofs, i, j;
        String res = "";
        for (i = 0; i < n; i++) {
            res += "x";
        }
        for (int p : ps) {
            if (p >= n) break;
            for (ofs = 0; ofs < n; ofs++) {
                int idx;
                boolean isOkay = true, isLower = false;
                String now = "";
                for (i = 0; i < n; i++) {
                    idx = ofs + (i * p);
                    now += s.charAt(idx % n);
                    if (!isLower && now.charAt(now.length()-1) < res.charAt(now.length()-1)) {
                        isLower = true;
                    } else if (!isLower && now.charAt(now.length()-1) > res.charAt(now.length()-1)) {
                        isOkay = false;
                        break;
                    }
                    if (!isLower && now.charAt(now.length()-1) > res.charAt(now.length()-1)) {
                        isOkay = false;
                        break;
                    }
                }
                if (isOkay) res = now;
            }
        }
        return res;
    }
}
