package normalWork;

import java.util.Arrays;

public class KnightsTour{
    static int size = 5;
    int validMoves = (size*size)-1;
    int moveNumber=0;
    static boolean [][] visited = new boolean[size][size];
    
    int startX, startY;
    static KnightsTour sys = new KnightsTour();
    
    public static void main(String [] args) {
    	
    }

    
    public static void move(int startX, int startY, int moveNumber) {
    	if(visited[startX, startY] = true)
    }
    
    
    
    
    public boolean isValidMove(int x, int y) {
    	boolean validMove=false;
    	if(x>0 && x<size) {
    		if(y>0 && y<size) {
    			validMove=true;
    		}
    	}
    
    	
    	return validMove;
    }

}