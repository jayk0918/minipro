package com.javaex.phonebook;

public class Person {
	
	// 필드
	private int index;
	private String name;
	private String hp;
	private String company;
	
	// 생성자
	public Person() {}
	
	public Person(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	public Person(int index, String name, String hp, String company) {
		this.index = index;
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	// 메소드 gs
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	// 메소드 일반
	@Override
	public String toString() {
		return "Person [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	
	public void showInfo() {
		System.out.println(this.name + "  " + this.hp + "  " +  this.company);
	}
	
	public void indexInfo() {
		System.out.println(this.index + ".  " + this.name + "  " + this.hp + "  " +  this.company);
	}
	
	
	
	
	
}
