public class ArrayMethods{

    public static int rowSum(int[][] AR, int x){
        int sum = 0;
        for(int i = 0; i<AR[x].length;i++){
            sum += AR[x][i];
        }
        return sum;
    }

    public static int columnSum(int[][] AR, int x){
        int sum = 0;
        for(int i = 0; i < AR.length;i++){
            sum += AR[i][x];
        }
        return sum;
    }

    public static int[] allRowSums(int[][] AR){
        int[] rowSum = new int[AR.length];
        for(int i = 0;i < AR.length;i++){
            rowSum[i] += rowSum(AR, i);
        }
        return rowSum;
    }

    public static boolean isRowMagic(int[][] AR){
        int[] sumRow = allRowSums(AR);
        for(int i = 0; i < sumRow.length-1;i++){
            if(sumRow[i] != sumRow[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean isColumnMagic(int[][] AR){
        boolean result = true;
        for(int i = 0; i < AR[0].length-1;i++){
            result = result && (columnSum(AR, i) == columnSum(AR, i+1));
        }
        return result;
    }

}
