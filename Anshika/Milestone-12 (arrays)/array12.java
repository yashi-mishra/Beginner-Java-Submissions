/*Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]*/
class array12 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> a=new ArrayList<Integer>();
        int min=matrix[0][0], max=matrix[0][0], storej=0, storei=0;
        for (int i=0; i<matrix.length; i++)
        {
            min=matrix[i][0];
            for (int j=0; j<matrix[i].length; j++)
            {
                if (matrix[i][j]<min)
                {
                    min=matrix[i][j];
                    storej=j;
                }
            }
            max=min;
            for (int k=0; k<matrix.length; k++)
            {
                if (matrix[k][storej]>max)
                {
                    max=matrix[k][storej];
                    storei=k;
                }
            }
            if (max==min)
                a.add(matrix[storei][storej]);
        }
        return a;
    }
}