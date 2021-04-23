class Solution {
    public int countBinarySubstrings (String s) {
        int arr [] = new int [2];
        int res = 0;
        if (s.charAt (0) == '0')
            arr [0]++;
        else
            arr [1]++;
        for (int i = 1; i < s.length (); i++) {
            char ch = s.charAt (i);
            if (ch != s.charAt (i-1))
                arr [ch - '0'] = 1;
            else
                arr [ch - '0']++;
            if (arr [1 - (ch - '0')] > 0) {
                arr [1 - (ch - '0')]--;
                res++;
            }
        }
        return res;
    }
}