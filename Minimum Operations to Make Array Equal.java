class Solution {
    // TC : O(1)
    // TC : O(1)
    public int minOperations(int n) {
        if(n%2==1){
            // n is odd
            n =n /2;
            return n*(n+1);
        } else{
            // n is even
            n =n/2;
            return n*n;
        }
    }
}