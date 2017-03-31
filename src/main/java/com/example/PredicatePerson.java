package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicatePerson {
	public static void main(String[] args) {
		List<Person> list=new ArrayList<Person>();
		Person p1=new Person("xiaoming",55);
		Person p2=new Person("xiaohong",66);
		Person p3=new Person("xiaoli",99);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		for(Person per:list){
			per.show();
		}
		List<Person> list2=findMatchPerson(list,per->per.getGrade()>=60,per->per.setIfPass("合格"));
		for(Person per:list2){
			per.show();
		}
	}
	public static List<Person> findMatchPerson(List<Person> l,Predicate<Person> p,Consumer<Person> c){
		List<Person> list=new ArrayList<Person>();
		for(Person per:l){
			if(p.test(per)){
				c.accept(per);
				list.add(per);
			}
		}
		return list;
	}
}
