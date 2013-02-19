package sample;

import java.util.*;

public class Templete {

	public static void main(String[] args) {
		List twoDim = new ArrayList();
		//id,row,column,vacant/seat
		
		
		Seats seats1 = new Seats();
		seats1.setId("1");
		seats1.setRow("0");
		seats1.setColumn("0");
		seats1.setIsSeat("N");
		
		Seats seats2 = new Seats();
		seats2.setId("2");
		seats2.setRow("0");
		seats2.setColumn("1");
		seats2.setIsSeat("Y");
		
		Seats seats3 = new Seats();
		seats3.setId("3");
		seats3.setRow("1");
		seats3.setColumn("0");
		seats3.setIsSeat("Y");
		
		Seats seats4 = new Seats();
		seats3.setId("4");
		seats3.setRow("1");
		seats3.setColumn("1");
		seats3.setIsSeat("Y");
		
		twoDim.add(seats1);
		twoDim.add(seats2);
		twoDim.add(seats3);
		twoDim.add(seats4);
		System.out.println(twoDim);
		
		Iterator it = twoDim.iterator();
		while(it.hasNext())
		{
			Seats intDim = (Seats)it.next();
			System.out.println("Seat Id "+intDim.getId());
		}
		
	}
		
}
