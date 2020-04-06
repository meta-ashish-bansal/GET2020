package graphicsLib;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class implements shape interface.
 * @author Ashish
 *
 */
public class Rectangle implements Shape {
	private String type = typeOfShape.RECTANGLE.toString();
	private double width,height;
	private StartingPoint coordinates;
	private double area, perimeter,originDistance;
	private Timestamp tstamp;

	public Rectangle(StartingPoint obj, ArrayList<Double> listOfInteger){
		width = listOfInteger.get(0);
		height = listOfInteger.get(1);
		coordinates = new StartingPoint(obj.xCoordinate, obj.yCoordinate);
		area = width*height;
		perimeter = 2*(width + height);
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
				&& obj.yCoordinate >= coordinates.yCoordinate && obj.yCoordinate <= coordinates.yCoordinate+height)
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
