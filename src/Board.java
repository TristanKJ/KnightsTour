import java.util.Arrays;
import java.awt.*;
import javax.swing.*;

public class Board{

	private int n; //the size of the board
	private int M; //set to n*n-1
	private boolean[][] visited; //
	
	
	public Board(int size)
	{
		n = size;
		visited = new boolean[n][n];
		M = (n*n)-1;
		
		for(int i = 0; i < n; i++)
		{
			Arrays.fill(visited[i], false);
		}
	}
	
	public boolean move(int x, int y, int m)
	{
		if( (x < 0) || ( x >= n ) || ( y < 0) || (y >= n) )
			return false; //coordinates are off board
		if( visited[x][y] == true)
			return false; //knight has already been there
		if(m  == M)
		{
			System.out.println("A solution has been found");
			//System.out.println()
			visited[x][y] = true;
			return true;
		}
		else
		{
			visited[x][y] = true;
			
			boolean result = false;
			
			result = result || move(x+2, y+1, m+1);
			result = result || move(x+2, y-1, m+1);
			result = result || move(x-2, y+1, m+1);
			result = result || move(x-2, y-1, m+1);
			result = result || move(x+1, y+2, m+1);
			result = result || move(x+1, y-2, m+1);
			result = result || move(x-1, y+2, m+1);
			result = result || move(x-1, y-2, m+1);
			
			if( result == true)
			{
				System.out.println("x= " + x + " y= " + y);
				return true;
			}
			else
			{
				visited[x][y] = false;
				return false;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Board board = new Board(5);
		board.move(0, 0, 0);
	}
}
