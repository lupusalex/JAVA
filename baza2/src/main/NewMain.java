package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.Scanner;

import classes.Car;

public class NewMain {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		Scanner scanner = new Scanner(System.in);
//		
//		String yourName = "";
//		System.out.print("Name: ");
//		yourName = scanner.nextLine();
//		
//		int yourAge = 0;
//		System.out.println("Age: ");
//		yourAge = scanner.nextInt();
//		
//		System.out.println("Name = " + yourName);
//		System.out.println("Age = " + yourAge);
//		
//		scanner.close();
		
		Car car = new Car("Renault", 90, "blue", 1500);
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("car.txt");
			OutputStreamWriter streamWriter = new OutputStreamWriter(fileOutputStream);
			BufferedWriter writer = new BufferedWriter(streamWriter);
			writer.write(car.getName());
			writer.write(System.lineSeparator());
			Integer speed = car.getSpeed();
			writer.write(speed.toString());
			writer.write(System.lineSeparator());
			writer.write(car.getColor());
			writer.write(System.lineSeparator());
			Integer capacity = car.getCapacity();
			writer.write(capacity.toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream fileInputStream = new FileInputStream("car.txt");
			InputStreamReader streamReader = new InputStreamReader(fileInputStream);
			BufferedReader reader = new BufferedReader(streamReader);
			String name = reader.readLine();
			int speed = Integer.parseInt(reader.readLine());
			String color = reader.readLine();
			int capacity = Integer.parseInt(reader.readLine());
			reader.close();
			Car c2  = new Car(name, speed, color, capacity);
			System.out.println(c2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileOutputStream binaryOutputStream = new FileOutputStream("car.bin");
			DataOutputStream dataOutputStream = new DataOutputStream(binaryOutputStream);
			dataOutputStream.writeUTF(car.getName());
			dataOutputStream.writeInt(car.getSpeed());
			dataOutputStream.writeUTF(car.getColor());
			dataOutputStream.writeInt(car.getCapacity());
			dataOutputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream binaryInputStream = new FileInputStream("car.bin");
			DataInputStream dataInputStream = new DataInputStream(binaryInputStream);
			String name = dataInputStream.readUTF();
			int speed = dataInputStream.readInt();
			String color = dataInputStream.readUTF();
			int capacity = dataInputStream.readInt();
			dataInputStream.close();
			Car c3 = new Car(name, speed, color, capacity);
			System.out.println(c3);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		car.serialize();
		try {
			Car c4 = Car.deserialize();
			System.out.println(c4);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
