package com.davilao.davilaoapp;

public class Person
{
	private String name;
	private String surname;
	private String phoneNumber;

	public Person(name, surname, phoneNumber)
	{
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
	}

	public setName(String name) 
	{
		this.name = name;
	}

	public setSurname(String surname) 
	{
		this.surname = surname;
	}

	public setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public String getName()
	{
		return this.name;
	}

	public String getSurname()
	{
		return this.surname;
	}

	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
}