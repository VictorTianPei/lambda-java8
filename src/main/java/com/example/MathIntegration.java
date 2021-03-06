package com.example;

import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Predicate;

/**
 * Created by qiuzhanghua on 2017/2/6.
 */
public class MathIntegration {

	public static void main(String[] args) {
		double d1 = integrate(x -> x, 10, 100, 1000);
		System.out.println(d1);
		double d2 = integrate(x -> x * x, 10, 100, 1000);
		System.out.println(d2);
		double d3 = integrate(x -> Math.pow(x, 3), 10, 100, 1000);
		System.out.println(d3);
		double d4 = integrate(Math::sin, 10, 100, 1000);
		System.out.println(d4);
		double d5 = doubleOperator(x -> x, 10, 100, 1000);
		System.out.println(d5);
		double d6 = doubleOperator(x -> x * x, 10, 100, 1000);
		System.out.println(d6);
		double d7 = doubleOperator(x -> Math.pow(x, 3), 10, 100, 1000);
		System.out.println(d7);
		double d8 = doubleOperator(Math::sin, 10, 100, 1000);
		System.out.println(d8);	

		Predicate p ;
	}
	public static int integrateNumSlices(int numSlices,Predicate<Integer> p,Consumer<Integer> c){
		if(p.test(numSlices)){
			c.accept(numSlices);
		}
		return numSlices;
	} 	

	public static double integrate(Integrable func, double x1, double x2, int numSlices) {
		//  if (numSlices < 1) numSlices = 1;

		numSlices=integrateNumSlices(numSlices, x->x<1, x->x=1);
		double delta = (x2 - x1) / numSlices;
		double start = x1 + delta / 2.0;
		double sum = 0.0;
		for (int i = 0; i <numSlices; i++) {
			sum += delta * func.eval(start + delta * i);
		}
		return sum;
	}

	public static double doubleOperator(DoubleUnaryOperator func, double x1, double x2, int numSlices){
		if (numSlices < 1) numSlices = 1;
		double delta = (x2 - x1) / numSlices;
		double start = x1 + delta / 2.0;
		double sum = 0.0;
		for (int i = 0; i <numSlices; i++) {
			sum += delta * func.applyAsDouble(start + delta * i);
		}
		return sum; 
	}
}
