class Solution {
public:
    int findSubstringInWraproundString(string p) {
        vector<int> d(26, 0);
        int len = 0;
        int cur = 0;
        for (int i = 0; i < p.size(); i++) {
            cur = p[i] - 'a';
            if (i > 0 && p[i - 1] - 'a' != (cur - 1 >= 0 ? cur - 1 : 25)) {
                len = 0;
            }
            d[cur] = max(d[cur], ++len);
        }
        return accumulate(d.begin(), d.end(), 0);
    }
};
