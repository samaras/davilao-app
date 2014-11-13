package com.davilao.davilaoapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements PersonFragment.OnPersonSelectedListener 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people);

        /* 
        	Get the FrameLayout view in main.xml file
        	Check if the state is null
        */
        if(findViewById(R.id.main) != null) {
        	if(savedInstanceState != null) 
    		{ 
    			// return to previous state because it seems to exist
    			return; 
    		} 
        }

    	// Create the List of people fragment
    	PeopleFragment listFragement = new PeopleFragment();
    	listFragement.setArguments(getIntent().getExtras());

    	// Begin the fragment initialization here
    	getSupportFragmentManager().beginTransaction().add(R.id.main, listFragement).commit()
    }

    /**
     * When the user clicks any person on the list, this function responds
     * and passes the position id of the selected item
     * @param int position
     * @return void
     */
    public void OnPersonSelected(int position)
    {
    	// Person(singular) - Create the fragment to load the details of the person
    	// selected.
    	PersonFragment personFragment = (PersonFragment) getSupportFragmentManager().findFragmentById(R.layout.view_one);

    	if(personFragment != null) 
    	{
    		// Load all the details of the person in the view
    		personFragment.updatePersonView(position);
    	} 
    	else 
    	{
    		PersonFragment newFragment = new PersonFragment();
    		Bundle args = new Bundle();
            args.putInt(PersonFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.main, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
    	}
    }
}
