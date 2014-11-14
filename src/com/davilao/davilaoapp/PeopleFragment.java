package com.davilao.davilaoapp;

import android.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class PersonFragment extends Fragment 
{
	OnItemSelectedListener listener;

	public interface OnItemSelectedListener 
	{
		public void onPersonSelected(int position);
	}

	@Override View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state)

	@Override 
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<Person>(getActivity(), android.R.layout.view_one, Person.List));

	}

}