package com.cowboysmall.games.tutorials.tutorial07;

public class Calculator {
	static double CalculatePositionX(double[] ViewFrom, double[] ViewTo, double x, double y, double z)
	{
		return 0;
	}

	static double CalculatePositionY(double[] ViewFrom, double[] ViewTo, double x, double y, double z)
	{
		setStuff(ViewFrom, ViewTo);
		return 0;		
	}
	
	static void setStuff(double[] ViewFrom, double[] ViewTo)
	{
		Vector ViewVector = new Vector(ViewTo[0] - ViewFrom[0], ViewTo[1] - ViewFrom[1], ViewTo[2] - ViewFrom[2]);
		Vector DirectionVector = new Vector(1, 1, 1);
		Vector PlaneVector1 = ViewVector.CrossProduct(DirectionVector);
		Vector PlaneVector2 = ViewVector.CrossProduct(PlaneVector1);	
	}
}
