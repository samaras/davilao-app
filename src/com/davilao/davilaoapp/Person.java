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

	public ArrayList<Person> getPerson(int position)
	{

	}

	public setPerson(ArrayList<String> person)
	{

	}

	public void serialPerson(ArrayList<Person> personList) 
	{
		ObjectOutputStream objOutStream = null;
		FileOutputStream fOutStream = null;
		try{
        	FileOutputStream fOutStream = new FileOutputStream("people.ser", true);
        	ObjectOutputStream objOutStream = new ObjectOutputStream(fOutStream);
        	objOutStream.writeObject(personList);
		} catch (Exception ex) {
        	e.printStackTrace();
		}finally {
        	if(objOutStream  != null){
            	objOutStream.close();
         	} 
		}
	}

	public ArrayList<Person> deserialPerson(int i)
	{
		ObjectInputStream objInStream = null;
 		try {
	        streamIn = new FileInputStream("people.ser");
	        ObjectInputStream objInStream = new ObjectInputStream(streamIn);
	        List<Personn> readCase = (List<Person>) objInStream.readObject();
	        recordList.add(readCase);
	        return recordList.get(i);
    	} catch (Exception e) {
        	e.printStackTrace();
 		}finally {
        	if(objInStream != null){
            	objInStream .close();
         	} 
 		}
	}
}