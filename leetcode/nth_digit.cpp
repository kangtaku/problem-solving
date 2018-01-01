class Solution {
public:
    int findNthDigit(int n) {
        long start = 1, end = 9, cipher = 1;
        while (n > cipher * end) {
            n -= cipher * end;
            cipher++;
            end *= 10L;
            start *= 10L;
        }
        start += (n - 1) / cipher;
        string nStr = to_string(start);
        return nStr[(n - 1) % cipher] - '0';
    }
};
