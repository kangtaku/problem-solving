class Solution {
    public int findComplement(int num) {
        int mask = ~0;
        int first = Integer.highestOneBit(num);
        while (first != 1) {
            first >>= 1;
            mask <<= 1;
        }
        return ~mask & ~num;
    }
}
