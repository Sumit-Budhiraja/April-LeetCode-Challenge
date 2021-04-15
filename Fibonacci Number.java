class Solution {

    // TC : O(n)
    // SC : O(1)
    public int fib(int N) {

        if(N <= 1)
            return N;

        int a = 0, b = 1;

        int sum = a + b;
        for(int i=2;i<=N;i++)
        {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}