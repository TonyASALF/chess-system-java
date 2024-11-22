package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

//	@Override
//	public boolean[][] possibleMoves() {
//		
//		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumn()];
//
//		Position p = new Position(0, 0);
//		
//		if (getColor() == Color.WHITE) {
//			//> above
//			p.setValues(this.position.getRow() - 1, this.position.getColumn());
//			
//			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//				mat[p.getRow()][p.getColumn()] = true;
//			}
//			
//			//> above 2 houses
//			p.setValues(this.position.getRow() - 2, this.position.getColumn());
//			
//			Position p2 = new Position(this.position.getRow() - 1, this.position.getColumn());
//			
//			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && 
//					getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
//				mat[p.getRow()][p.getColumn()] = true;
//			}
//			 
//			//> 
//			p.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
//			
//			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//				mat[p.getRow()][p.getColumn()] = true;
//			}
//			
//			//> 
//			p.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
//			
//			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//				mat[p.getRow()][p.getColumn()] = true;
//			}
//			
//		} else {
//			//> above
//			p.setValues(this.position.getRow() + 1, this.position.getColumn());
//			
//			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//				mat[p.getRow()][p.getColumn()] = true;
//			}
//			
//			//> above 2 houses
//			p.setValues(this.position.getRow() + 2, this.position.getColumn());
//			
//			Position p2 = new Position(this.position.getRow() + 1, this.position.getColumn());
//			
//			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && 
//					getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
//				mat[p.getRow()][p.getColumn()] = true;
//			}
//			 
//			//> diagonal esquerda
//			p.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
//			
//			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//				mat[p.getRow()][p.getColumn()] = true;
//			}
//			
//			//> diagonal direita
//			p.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
//			
//			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//				mat[p.getRow()][p.getColumn()] = true;
//			}
//		}
//		
//		return mat;
//	}
	
	//MINHA VERSÃO
	@Override
	public boolean[][] possibleMoves() {
	
	boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumn()];
	int avanco;
	
	if (getColor() == Color.WHITE) {
		avanco = -1;
	} else {
		avanco = 1;
	}
	
	//seta p em uma casa acima ou abaixo, a depender da cor
	Position p = new Position(this.position.getRow() + avanco, this.position.getColumn());
	
	//acima/abaixo - depende da cor
	if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
		
		mat[p.getRow()][p.getColumn()] = true;
		
		//2ª casa acima/abaixo
		if (getMoveCount() == 0) {
			
			p.setValues(p.getRow() + avanco, p.getColumn());
			
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				
				mat[p.getRow()][p.getColumn()] = true;
			}	
		}
	}
	
	//diagonal à esquerda
	p.setValues(this.position.getRow() + avanco, this.position.getColumn() - 1);
	if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
		
		mat[p.getRow()][p.getColumn()] = true;
	}
	
	//diagonal à direta
	p.setValues(this.position.getRow() + avanco, this.position.getColumn() + 1);
	if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
		
		mat[p.getRow()][p.getColumn()] = true;
	}
	
	return mat;
}
	
	
	@Override
	public String toString() {
		return "P";
	}
}