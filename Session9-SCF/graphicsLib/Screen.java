package graphicsLib;

import java.util.*;

/**
 * This class contains operation to be performed on Shapes.
 * @author Ashish
 *
 */
public class Screen{
	private ArrayList<Shape> listOfShape = new ArrayList<Shape>();

	/**
	 * This function creates and adds new shape in a listOfShape list.
	 * @param type of shape.
	 * @param xCoordinate starting x-coordinate
	 * @param yCoordinate starting y-coordinate
	 * @param length sides length of shape
	 * @return true if shape is added else false.
	 * @throws AssertionError when parameters are invalid.
	 */
	public boolean addShape(String type,double xCoordinate,double yCoordinate,ArrayList<Double> length) throws AssertionError{
		if(type == null|| xCoordinate < 0|| yCoordinate < 0|| length.size() <= 0)
			throw new AssertionError("Provide valid parameters.");
		StartingPoint start = new StartingPoint(xCoordinate,yCoordinate);
		Shape shapeObj = ShapeFactory.typeShapeFactory(type, start, length);
		listOfShape.add(shapeObj);
		return true;
	}

	/**
	 * This function removes all shapes of same type.
	 * @param shapeType of object to be removed.
	 * @return true if shape found else false.
	 */
	public boolean removeAllShapesOfSameType(String shapeType){
		int i;
		for(i=0; i < listOfShape.size();i++){
			if(listOfShape.get(i).getShapeType().equalsIgnoreCase(shapeType))
				listOfShape.remove(i);
		}
		if(listOfShape.size() < i)
			return true;
		else 
			return false;
	}

	/**
	 * This  function sorts object list based on different user requirements.
	 * @param filter defines the type of sorting.
	 * @return list of objects after sorting.
	 */
	public ArrayList<Shape> sortObjects(String filter){

		if("area".equalsIgnoreCase(filter))
			Collections.sort(listOfShape ,new AreaComparator());
		else if("perimeter".equalsIgnoreCase(filter))
			Collections.sort(listOfShape ,new PerimeterComparator());
		else if("timestamp".equalsIgnoreCase(filter))
			Collections.sort(listOfShape ,new TimeStampComparator());
		else
			Collections.sort(listOfShape ,new OriginDistComparator());
		return listOfShape;
	}

	/**
	 * This function checks is the provided corrdinates are enclosed by any shape or not.
	 * @param xCoord coordinate of point.
	 * @param yCoord coordinate of point.
	 * @return list of objects enclosing the point.
	 * @throws AssertionError if no object found enclosing the shape.
	 */
	public ArrayList<Shape> checkShapesEnclosingPoint(double xCoord, double yCoord) throws AssertionError{
		StartingPoint obj = new StartingPoint(xCoord,yCoord);

		ArrayList<Shape> enclosingShapeObjects = new ArrayList<Shape>();

		for(int i = 0; i<listOfShape.size();i++){
			if(listOfShape.get(i).isPointEnclosed(obj))
				enclosingShapeObjects.add(listOfShape.get(i));
		}

		if(enclosingShapeObjects.size() == 0)
			throw new AssertionError("No object enclosing this point found.");

		return enclosingShapeObjects;
	}

	/**
	 * This function removes shape from screen.
	 * @param shapeType object type to be removed.
	 * @return true if shape removed else false.
	 */
	public boolean removeShape(String shapeType){
		for(int i=0; i < listOfShape.size();i++){
			if(listOfShape.get(i).getShapeType().equalsIgnoreCase(shapeType)){
				listOfShape.remove(i);
				return true;
			}
		}
		return false;
	}

	/*	public static void main(String[] args){
		Screen s1 = new Screen();
		ArrayList<Double> sides = new ArrayList<Double>();
		sides.add(5d);
		s1.addShape("square", 5d, 7d, sides);
		System.out.println(s1.listOfShape.get(0).getShapeType());
		System.out.println(s1.listOfShape.get(0).getTimeStamp());
		System.out.println(s1.listOfShape.get(0).getArea());
		System.out.println(s1.listOfShape.get(0).getOrigin());
		System.out.println("----------------");
		sides.add(4d);

		s1.addShape("rectangle", 2d, 7d, sides);
		System.out.println(s1.listOfShape.get(1).getShapeType());
		System.out.println(s1.listOfShape.get(1).getTimeStamp());
		System.out.println(s1.listOfShape.get(1).getArea());
		System.out.println(s1.listOfShape.get(1).getOrigin());
		System.out.println("----------------");

		sides.add(3d);
		s1.addShape("triangle", 8d, 3d, sides);
		System.out.println(s1.listOfShape.get(2).getShapeType());
		System.out.println(s1.listOfShape.get(2).getTimeStamp());
		System.out.println(s1.listOfShape.get(2).getArea());
		System.out.println(s1.listOfShape.get(2).getOrigin());
		System.out.println("----------------");

		ArrayList<Double> len = new ArrayList<Double>();
		len.add(4d);
		s1.addShape("circle", 4d, 4d, len);
		System.out.println(s1.listOfShape.get(3).getShapeType());
		System.out.println(s1.listOfShape.get(3).getTimeStamp());
		System.out.println(s1.listOfShape.get(3).getArea());
		System.out.println(s1.listOfShape.get(3).getOrigin());
		System.out.println("----------------");


		len.remove(0);

		ArrayList<Shape> obj = new ArrayList<Shape>();
		obj = s1.checkShapesEnclosingPoint(3d, 6d);
		for(int i=0;i<obj.size();i++){
			System.out.println(obj.get(i).getShapeType());
		}
		System.out.println("----------------");

		obj = s1.sortObjects("ärea");
		for(int i=0;i<obj.size();i++){
			System.out.println(obj.get(i).getShapeType());
		}
		System.out.println("----------------");

		System.out.println(s1.removeShape("circle"));		

	}*/
}

