package com.davilao.davilaoapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup
import android.widget.TextView;

public class PersonFragment extends Fragment
{
	public final static POSITION = "1";
	int currPosition = -1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state)
	{
		if(state != null) 
		{
			currPosition = state; 
		}

		// Inflate layout for this fragment
		return inflater.inflate(R.layout.view_one, container, false);
	}

	@Override
	public void onStart()
	{
		super.onStart();

		Bundle params = getArguments();
		if(params != null)
		{
			// Get the person based on the id given
			updatePersonView(params.getInt(POSITION));
		} else if (currPosition != -1) {
			updatePersonView(currPosition);
		}

	}

	public void updatePersonView(int position)
	{
		TextView firstName = (TextView) getActivity().findViewById(R.id.first_name);
		TextView lastName = (TextView) getActivity().findViewById(R.id.last_name);
		TextView phoneNumber = (TextView) getActivity().findViewById(R.id.phone_number);

		Person p = deserialPerson(position);
		firstName.setText = p.getName();
		lastName.setText = p.getSurname();
		phoneNumber.setText = p.getPhoneNumber();
		currPosition = position;
	}

	public void callNumber(String phoneNumber)
	{
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:" + phoneNumber));
		startActivity(callIntent);
	}

	public void serialPerson(ArrayList<Person> personList) 
	{
		List<Person> p = new ArrayList<Person>();
		ObjectOutputStream objOutStream = null;
		FileOutputStream fOutStream = null;
		try{
        	FileOutputStream fOutStream = new FileOutputStream("people.dat", true);
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
	        streamIn = new FileInputStream("people.dat");
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

	@Override 
	public void onSavedInstanceState(Bundle state)
	{
		super.onSavedInstanceState(state);

		// Bundle the current person selected
		state.putInt(POSITION, currPosition);
	}
}