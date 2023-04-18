public class sudoku {
    public static boolean sudokusolver(int sudoku[][] , int row,int col) {
        if(row == 9){    //base case
            return true;
        }
        int nextrow = row;
        int nextcol = col+1;
        if(col+1==9){
             nextrow = row+1;
             nextcol = 0;
        }

        if(sudoku[row][col]!=0){               //if a value is already placed then move to next row and column
           return sudokusolver(sudoku, nextrow, nextcol);
        }
        for(int digit=1 ; digit<=9 ; digit++){
              if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(sudokusolver(sudoku, nextrow, nextcol)){    //checking if solution exist
                    return true;
                }
                sudoku[row][col]=0;    //putting zero again coz we dont want to plce any other value
              }
        }
           return false;
    }

    public static boolean isSafe(int sudoku[][],int row,int col, int digit) {
        for(int j=0 ; j<=8 ; j++){              //check if that column has that digit
            if(sudoku[row][j]==digit){
                return false;
            }
        }
        for(int i=0 ; i<=8 ; i++){             //check if that row has same digit
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        int sr = (row/3)*3;                    //check if number exist in same grid
        int sc = (col/3)*3;
        for(int i=sr ; i<sr+3 ; i++){
            for(int j=sc ; j<sc+3 ; j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static void printsudoku(int sudoku[][]) {
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                System.out.print(sudoku[i][j]);
            }
             System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudoku[][] = {{0,0,8,0,0,0,0,0,0},
                          {4,9,0,1,5,7,0,0,2},
                          {0,0,3,0,0,4,1,9,0},
                          {1,8,5,0,6,0,0,2,0},
                          {0,0,0,0,2,0,0,6,0},
                          {9,6,0,4,0,5,3,0,0},
                          {0,3,0,0,7,2,0,0,4},
                          {0,4,9,0,3,0,0,5,7},
                          {8,2,7,0,0,9,0,1,3}};
        if(sudokusolver(sudoku,0,0)){
            System.out.println("solution exist");
            printsudoku(sudoku);
        }
        else{
            System.out.println("solution does not exist");
        }
    }
}
