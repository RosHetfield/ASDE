package it.unical.prg4.minesweeper.model;
import java.util.Random;

public class MineSweeper {
	  private static final int MINA = -1;    
	  private static char NONSC_CHAR = '-';    // carattere per rappresentare una cella non scoperta
	  private static char MINA_CHAR = '*';     // carattere per rappresentare una cella con mina
	  private int[][] matrix;  // matrice che rappresenta il campo
	  private int rows;  // numero delle righe 
	  private int columns;  // numero delle colonne 
	  private int mine;   // numero delle mine
	  
	public MineSweeper(int rows,int columns , int mine) {
		this.rows=rows;
		this.columns=columns;
		this.mine=mine;
		this.matrix= new int[rows][columns];
		Random rand = new Random();
		for(int m=0;m<mine;m++) {
			int i=rand.nextInt(rows);
			int j=rand.nextInt(columns);
			if(matrix[i][j]==0) {
				matrix[i][j]=MINA;
			}else {
				m--;
			}
		}
		insertNumbers();
	}
	
	
	private void insertNumbers() {
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				if(matrix[i][j]!=-1) {
					matrix[i][j]=mine(i, j);
				}
			}
		}
	}
	
	private int mine(int i, int j) {
		int totMine=0;
		//check on top
		for(int up=j-1 ; up<=j+1;up++) {
			if(inRange(i-1, up)) {
				if(matrix[i-1][up]==-1) {
					totMine++;
				}
			}
		}
		//check on bottom
		for(int down=j-1 ; down<=j+1;down++) {
			if(inRange(i+1, down)) {
				if(matrix[i+1][down]==-1) {
					totMine++;
				}
			}
		}
		//left
		if(inRange(i, j-1)) {
			if(matrix[i][j-1]==-1) {
				totMine++;
			}
		}
		//right
		if(inRange(i, j+1)) {
			if(matrix[1][j+1]==-1) {
				totMine++;
			}
		}
		return totMine;
	}
	
	
	boolean inRange(int i,int j) {
		if(i<0 || j<0) {
			return false;
		}
		if(i>=rows || j >=columns) {
			return false;
		}
		return true;
	}
	
	public void print() {
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				System.out.print("\t"+matrix[i][j]);
			}
			System.out.println();
			System.out.println();
		}
	}
	public static void main(String[] args) {
		MineSweeper m= new MineSweeper(10, 10, 20);
		m.print();
	}
	 
}
