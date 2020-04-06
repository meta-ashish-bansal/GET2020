package graphicsLib;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * This class implements shape interface.
 * @author Ashish
 *
 */
public class Square implements Shape {
	private String type = typeOfShape.SQUARE.toString();
	private double width;
	private StartingPoint coordinates;
	private double area, perimeter,originDistance;
	private Timestamp tstamp;

	public Square(StartingPoint obj, ArrayList<Double> listOfInteger){
		width = listOfInteger.get(0);
		coordinates = new StartingPoint(obj.xCoordinate, obj.yCoordinate);
		area = width*width;
		perimeter = 4*width;
		originDistance = Math.sqrt(Math.pow(coordinates.xCoordinate, 2) + Math.pow(coordinates.yCoordinate, 2));
		Date date= new Date();
		long time = date.getTime();
		tstamp = new Timestamp(time);
	}

	@Override
	public double getArea() {
		return area;
	}

	@Override
	public double getOrigin() {
		return originDistance;
	}

	@Override
	public double getPerimeter() {
		return perimeter;
	}

	@Override
	public boolean isPointEnclosed(StartingPoint obj){
		if(obj.xCoordinate >= coordinates.xCoordinate && obj.xCoordinate <= coordinates.xCoordinate+width
				&& obj.yCoordinate >= coordinates.yCoordinate && obj.yCoordinate <= coordinates.yCoordinate+width)
			return true;
		return false;
	}

	@Override
	public String getShapeType() {
		return type;
	}

	@Override
	public Timestamp getTimeStamp() {
		return tstamp;
	}
}
