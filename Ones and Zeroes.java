class Solution {
    // TC : O(n*m*len)
    // SC : O(n*m)
    public int findMaxForm(String[] strs, int m, int n) {


        int[][] strFreq = new int[strs.length][2];
        int i = 0;
        for (String str : strs) {
            strFreq[i] = freqCount(str);
            i++;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (i = 0; i < strs.length; i++) {
            int oneFreq = strFreq[i][1];
            int zeroFreq = strFreq[i][0];

            for (int k = m; k >= zeroFreq; k--) {
                for (int j = n; j >= oneFreq; j--) {
                    dp[k][j] = Math.max(dp[k][j], dp[k - zeroFreq][j - oneFreq] + 1);
                }
            }

        }
        return dp[m][n];


    }

    private int[] freqCount(String str) {
        int[] freq = new int[2];
        for (char a : str.toCharArray()) {
            if (a == '0') {
                freq[0]++;
            } else {
                freq[1]++;
            }
        }
        return freq;
    }
}