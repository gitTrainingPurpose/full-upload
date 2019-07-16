/*
Exercises for Unit 8  - Java Collections
1. Reuse the Circle class from one of the previous labs. Create a List of circles with random radii. Keep adding circles to the list until Math.random returns value < 0.01
Once the list is built, display the number of elements in the list and then display areas of each circle (use for-each)
2. Iterate through the List of random circles from the above lab and remove all those circles which have radius < 0.5. Print the number of circles after removal. (User Iterator and its remove method)
3. Build a map of Employee id vs Employee Name :
EmployeeId  Name
E1234   Steve Jobs
 E2345  Bill Gates 
 E3456  Larry Ellison
 E4567  Jeff Bezos 
 E8765  Mark Zuckerberg 
 E6789  Larry Page

Prompt the user to enter an employee number from keyboard and display the corresponding employee name. Test for both existing and non existing employees

*/

package com.visa.training.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CircleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Circle c1 = new Circle(3);
//		System.out.print("Radius: ");
//		System.out.println(c1.getRadius());
//		System.out.print("Area: ");
//		System.out.println(c1.computeArea());
//
//
//		Circle c2 = new Circle(4);
//		System.out.print("Radius: ");
//		System.out.println(c2.getRadius());
//		System.out.print("Area: ");
//		System.out.println(c2.computeArea());
		
		
		List<Circle> a = new ArrayList<Circle>();
		while(true) {
			double rad = Math.random();
			if(rad<0.01) {
				break;
			}
			else {
				Circle e = new Circle(rad);
				a.add(e);
			}
		}
		System.out.println("Number of elements in the list: "+a.size());
		for (Iterator<Circle> iterator = a.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next().computeArea());
		}
		
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i).getRadius()<0.5) {
				a.remove(i);
				i--;
			}
		}
		/*
		 * for(Circle c1:a) { if(c1.getRadius()<0.5) { a.remove(c1); } }
		 */
		System.out.println("Number of circle whose radius is greater than 0.5: "+a.size());
		for (Iterator<Circle> iterator = a.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next().computeArea());
		}
	}

}
