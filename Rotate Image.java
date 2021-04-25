class Solution 
{
    public void rotate(int[][] matrix) 
    {
        int arr[] = new int[matrix.length*matrix.length];
        int k = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                arr[k] = matrix[j][i];
                k++;
            }
        }
        for(int i = 0; i < matrix.length; i++)
        {
            k = 1;
            for(int j = 0; j < matrix.length; j++)
            {
                matrix[i][j] = arr[((i+1)*(matrix[0].length))-k];
                k++;
            }
        }
    }
}