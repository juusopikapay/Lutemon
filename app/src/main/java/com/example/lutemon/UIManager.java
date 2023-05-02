package com.example.lutemon;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UIManager extends Activity
{
    View[] views;
    View bar;
    TextView coinsText;
    View askName;
    EditText nameInput;
    LutemonList[] lutemonLists;
    Card card;

    Lutemon lutemonViewed=null;
    int currentView=0;

    public UIManager Start ()
    {
            ChangeView(0);
    }

    //asking name
    public void AskName()
    {
        //open ask name view
    }

    //assigning name and showing lutemons card
    public void SendName()
    {
        if(lutemonViewed!=null)
        {
            lutemonViewed.GiveName(nameInput.getText().toString());
            card.Show(lutemonViewed);
            UpdateLists();
            lutemonViewed = null;
        }
        //close ask name view
    }

    //Opening view of index and closing other views
    public void ChangeView(int index)
    {

    }

    public void UpdateCoins(int coins)
    {
        coinsText.setText(coins);
    }

    public void ShowCard(Lutemon lutemon)
    {
        card.Show(lutemon);
        lutemonViewed = lutemon;
    }

    public void CloseCard()
    {
        card.Close();
        lutemonViewed = null;
    }

    public void UpdateLists(Lutemon[] lutemons)
    {
        for(LutemonList list : lutemonLists)
        {
            list.UpdateList(lutemons);
        }
    }

    public void UpdateLists()
    {
        for(LutemonList list : lutemonLists)
        {
            list.UpdateContainers();
        }
    }
}



