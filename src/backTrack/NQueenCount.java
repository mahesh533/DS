package backTrack;

import java.util.HashMap;

class NQueenCount {


    public static void main(String[] args) {

        System.out.println("Output "+new NQueenCount().totalNQueens(4));
    }

    int validSolution=0;
    public int totalNQueens(int n) {

        int[][] board=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=0;
            }
        }

        placeQueen(board,0,n);
        return validSolution;

    }

    public void placeQueen(int[][] board,int row,int bsize){

        //Exitcondition
        if(!isValid(board,bsize))
            return;

        if(row==bsize){
           // isValid(board,bsize);
            for(int i=0;i<bsize;i++) {
                for (int j = 0; j < bsize; j++) {
                    System.out.print(" "+board[i][j]);

                }
                System.out.println();
            }
            System.out.println("##################################");
            validSolution++;
            return;
        }



        for(int i=0;i<bsize;i++){
            board[row][i]=1;
            placeQueen(board,row+1,bsize);
            board[row][i]=0;


        }
    }

    public boolean isValid(int[][] board, int bsize){


        HashMap<Integer, Integer> dmap=new HashMap<Integer,Integer>();
        HashMap<Integer, Integer> d2map=new HashMap<Integer,Integer>();
        //Row check
        //Cloumn check
        for(int row=0;row<bsize;row++){
            int rowcount=0;
            int colcount=0;
            for(int column=0;column<bsize;column++){

                rowcount+=board[row][column];
                colcount+=board[column][row];
                if(dmap.get(row-column)==null){
                    dmap.put((row-column),board[row][column] );

                }else{
                    int val=dmap.get(row-column)+board[row][column] ;
                    dmap.put((row-column),val);
                }

                if(d2map.get(row+column)==null){
                    d2map.put((row+column),board[row][column] );

                }else{
                    int val=d2map.get(row+column)+board[row][column] ;
                    d2map.put((row+column),val);
                }


            }
            if(rowcount > 1){
                return false;
            }
            if(colcount > 1){
                return false;
            }
        }

        for(Integer i: dmap.keySet()){

            if(dmap.get(i) > 1){
                return false;
            }

        }
        for(Integer i: d2map.keySet()){

            if(d2map.get(i) > 1){
                return false;
            }

        }
        return true;
    }

    //Diagonal check



}
