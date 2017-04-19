package org.alexkurets.lesson4;

public class User /*extends Object*/ {
	String name;
	int age;
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	//@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		return this.name.toString()+" "+this.age;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		//return super.equals(obj);
		if(obj==null)
			return false;
		
		if(this==obj)
			return true;
		
		if(obj instanceof User)
		{
			User temp = (User)obj;
			
			if((this.name.equals(temp.name))&&(this.age==temp.age))
				return true;
			else
				return false;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
}
