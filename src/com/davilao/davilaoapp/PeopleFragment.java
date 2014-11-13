package com.davilao.davilaoapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Build;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.ListFragment;

public class PersonFragment extends ListFragment 
{
	OnPersonSelectedListener callback;

	public interface OnPersonSelectedListener 
	{
		public void onPSelected(int position);
	}

	@Override 
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.view_one, Person.List));

	}

}