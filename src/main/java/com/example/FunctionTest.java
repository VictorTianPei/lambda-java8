package com.example;

import java.util.ArrayList;
import java.util.List;

public class FunctionTest {
	public static void main(String[] args) {
		/*String a=transform("Daniel", String::toLowerCase);
		System.out.println(a);*/
		List<Car> list=new ArrayList<Car>();
		Car car1=new Car(1,"car1",20);
		Car car2=new Car(2,"car2",30);
		Car car3=new Car(3,"car3",40);
		list.add(car1);
		list.add(car2);
		list.add(car3);
		int a= mapSum(list,car->car.getPrice());
		int b=mapSum(list, Car::getPrice);
		System.out.println(a);
		System.out.println(b);
	}
	public static String transform(String s, Function<String, String> f) {  return f.apply(s);}

	public static <T> int mapSum(List<T> entries, Function<T, Integer> f) { int sum = 0;  for (T entry: entries) {sum += f.apply(entry); }  return sum; }
}
