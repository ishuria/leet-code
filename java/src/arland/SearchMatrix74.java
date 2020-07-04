package arland;

/**
 * @author xiangchaolei
 */
public class SearchMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(0==n){
            return false;
        }
        int m = matrix[0].length;
        if(0==m){
            return false;
        }
        int row = searchRow(matrix, target, 0, n-1);
        if(row<0){
            return false;
        }
        int col = searchColumn(matrix[row], target, 0, m-1);
        return col!=-1;
    }

    private int searchRow(int[][] matrix, int target, int low, int high){
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[mid][0]>target){
                high = mid - 1;
            }
            else if(matrix[mid][0]<target){
                low=mid+1;
            }
            else{
                return mid;
            }
        }
        if(low>=matrix.length){
            return low-1;
        }
        if(matrix[low][0]<target){
            return low;
        }
        else if(matrix[low][0]>target){
            return low-1;
        }
        else{
            return low;
        }
    }

    private int searchColumn(int[] a, int target, int low, int high){
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]>target){
                high = mid - 1;
            }
            else if(a[mid]<target){
                low=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        // write your code here
        SearchMatrix74 a = new SearchMatrix74();
        int[][] a1 =  {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
        };
        System.out.println(a.searchMatrix(a1, 3));
        int[][] a2 =  {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
        };
        System.out.println(a.searchMatrix(a2, 13));

        int[][] a3 =  {
                {1}
        };
        System.out.println(a.searchMatrix(a3, 0));
        System.out.println(a.searchMatrix(a3, 2));
        int[][] a4 =  {
                {1,3}
        };
        System.out.println(a.searchMatrix(a4, 3));
//        System.out.println(a.searchRow(a1, 23, 0, 2));
    }
}
