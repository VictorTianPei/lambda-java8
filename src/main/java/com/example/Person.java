package com.example;

public class Person {
	private String name;
	private int grade;
	private String ifPass="不合格";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getIfPass() {
		return ifPass;
	}
	public void setIfPass(String ifPass) {
		this.ifPass = ifPass;
	}
	public Person(String name,int grade){
		this.grade=grade;
		this.name=name;
	}
	public void show(){
		System.out.println("name:"+name+";grade:"+grade+";ifPass:"+ifPass);
	}
}
