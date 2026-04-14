import java.util.Arrays;
public class Sudoku
{
    public static void main(String[] args)
    {
        int[][] puzzle = new int[9][9];
        fill(puzzle);
        for (int r = 0; r < puzzle.length; r++){
            if (r % 3 == 0)
                    System.out.println("-------------------------");
            for (int c = 0; c < puzzle[0].length; c++){
                if (c % 3 == 0)
                    System.out.print("| ");
                System.out.print(puzzle[r][c] + " ");
                if (c == puzzle[0].length - 1)
                    System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
    
    public static boolean fill(int[][] puzz){
        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                if (puzz[r][c] == 0){
                    int[] nums = genArray();
                    for (int num : nums){
                        if (valid(puzz, r, c, num)){
                            puzz[r][c] = num;
                            if (fill(puzz))
                                return true;
                            puzz[r][c] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean valid(int[][] puzz, int r, int c, int n){
        for (int i = 0; i < 9; i++){
            if (puzz[r][i] == n || puzz[i][c] == n)
                return false;
        }
        int srow = (r/3)*3;
        int scol = (c/3)*3;
        for (int row = srow; row < srow + 3; row++) {
            for (int col = scol; col < scol + 3; col++) {
                if (puzz[row][col] == n)
                    return false;
            }
        }
        return true;
    }
    
    public static int[] genArray(){
        String list = "123456789";
        int[] result = new int[9];
        for (int i = 0; i < result.length; i++){
            int index = (int)(Math.random()*list.length());
            result[i] = list.charAt(index) - '0';
            list = list.substring(0, index) + list.substring(index + 1);
        }
        return result;
    }
}