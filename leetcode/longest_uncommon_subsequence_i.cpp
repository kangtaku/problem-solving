class Solution {
public:
    int findLUSlength(string a, string b) {
        if (a == b) {
            return -1;
        } else {
            return a.size() > b.size() ? a.size() : b.size();
        }
    }
};
