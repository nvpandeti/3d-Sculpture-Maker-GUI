/*
 * Nikhil Pandeti
 * Mrs. Gallatin
 * Period 2
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * A class for Cubes that implements the Shapes interface
 */
public class Cube implements Shapes
{
	private ArrayList<Face> faces;
	String s;
	/**
	 * A constructor for Toruses
	 * @param color Color
	 * @param x X
	 * @param y Y
	 * @param z Z
	 * @param length X Length
	 * @param width Y Width
	 * @param hight Z Height
	 * @param yaw Rotation in the xy plane
	 * @param pitch Rotation in the xz plane
	 * @param roll Rotation in the yz plane
	 */
	public Cube(Color color, double x, double y, double z, double length, double width, double height, double yaw, double pitch, double roll)
	{
		s = "Cube "+color.getRed()+" "+color.getGreen()+" "+color.getBlue()+" "+x+" "+y+" "+z+" "+length+" "+width+" "+height+" "+yaw+" "+pitch+" "+roll;
		double[][] cube = {{x+length/2, y+width/2, z+height/2}, 
							{x+length/2, y+width/2, z-height/2},
							{x+length/2, y-width/2, z+height/2},
							{x+length/2, y-width/2, z-height/2},
							{x-length/2, y+width/2, z+height/2},
							{x-length/2, y+width/2, z-height/2},
							{x-length/2, y-width/2, z+height/2},
							{x-length/2, y-width/2, z-height/2}};
		
		for (int i = 0; i<8; i++)
		{
			double tempX = 	cube[i][0];
            double tempY = 	cube[i][1];
            double tempZ = 	cube[i][2];
           	
           	if(yaw!=0)
			{
				double tempR = Math.sqrt(Math.pow(tempX-x, 2) + Math.pow(tempY-y, 2));
                double tempAngle = Math.toDegrees(Math.atan2(tempY - y, tempX - x));
                tempX = x + tempR * Math.cos(Math.toRadians(tempAngle + yaw));
                tempY = y + tempR * Math.sin(Math.toRadians(tempAngle + yaw));
			}
            if(pitch!=0)
            {
            	double tempR = Math.sqrt(Math.pow(tempX-x, 2) + Math.pow(tempZ-z, 2));
                double tempAngle = Math.toDegrees(Math.atan2(tempZ - z, tempX - x));
                tempX = x + tempR * Math.cos(Math.toRadians(tempAngle + pitch));
                tempZ = z + tempR * Math.sin(Math.toRadians(tempAngle + pitch));
            }
            if(roll!=0)
            {
            	double tempR = Math.sqrt(Math.pow(tempY-y, 2) + Math.pow(tempZ-z, 2));
                double tempAngle = Math.toDegrees(Math.atan2(tempZ - z, tempY - y));
                tempY = y + tempR * Math.cos(Math.toRadians(tempAngle + roll));
                tempZ = z + tempR * Math.sin(Math.toRadians(tempAngle + roll));
            }
            
            cube[i][0] = tempX;
            cube[i][1] = tempY;
            cube[i][2] = tempZ;
		}
		faces = new ArrayList<Face>();
		faces.add(new Face(color, cube[0], cube[1], cube[3], cube[2]));
		faces.add(new Face(color, cube[0], cube[4], cube[5], cube[1]));
		faces.add(new Face(color, cube[4], cube[6], cube[7], cube[5]));
		faces.add(new Face(color, cube[6], cube[2], cube[3], cube[7]));
		faces.add(new Face(color, cube[6], cube[4], cube[0], cube[2]));
		faces.add(new Face(color, cube[7], cube[3], cube[1], cube[5]));
	}
	
	/**
	 * Returns a list of the shape's Faces
	 * @return a list of the shape's Faces
	 */
	public ArrayList<Face> getFaces()
	{
		return faces;
	}
	/**
	 * Returns a string representation of the shape
	 * @return a string representation of the shape
	 */
	public String toString()
	{
		return s;
	}
}