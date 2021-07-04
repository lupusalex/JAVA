package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import classes.Car;
import classes.Vehicle;
import interfaces.Taxable;

public class Main {

	// primitivele se transmit prin val
	static void add(int x, int y) {
		x = x + y;
	}
	
	// se transmite prin valoare o adresa 
	static void add(Car x, Car y ) {
		// daca modific rez in functie se schimba rez
		//x = new Car(x.getName(), x.getSpeed(),
		//		x.getColor(), x.getCapacity());
		x.setCapacity(x.getCapacity() + y.getCapacity());
	}
	
	public static void main(String[] args) {
		Taxable t = new Car("Dacia", 100, "red", 1400);
		System.out.println(t.computeTax());
		
		Vehicle v = new Car();
		v.move();
		
		Car c = new Car("Ford", 90, "white", 1000);
		Car c2 = null;
		if(c instanceof Cloneable) {
			try {
				c2 = (Car)c.clone();
				c.setColor("black");
				System.out.println(c2);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		
		List<Integer> list = new Vector<>();
		list.add(5);
		list.add(4);
		list.add(1);
		
		list.add(3, 7);
		list.remove(0);
		 
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		for(Integer x : list) {
			System.out.printf("%d ", x);
		}
		
		list.set(0, 9);
		System.out.println();
		
		for(Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
			System.out.println(it.next());
		}
		
		Set<Car> set = new TreeSet<Car>();
		set.add(c);
		c2.setCapacity(1600);
		set.add(c2);
		
		for(Car x : set) {
			System.out.println(x);
		}
		
		Map<Car, String> map = new HashMap<Car, String>();
		map.put(c, "Ionel Ionescu");
		map.put(c2, "Gigel Georgescu");
		Car c3 = null;
		try {
			c3 = (Car)c.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put(c3, "Pop Popescu");
		
		for(Car x : map.keySet()) {
			System.out.printf("%s : ", x.toString());
			System.out.println(map.get(x));
		}
		
		int x = 2;
		int y = 3;
		add(x,y);
		System.out.println(x);
		
		add(c, c2);
		System.out.println(c.getCapacity());
	}

}