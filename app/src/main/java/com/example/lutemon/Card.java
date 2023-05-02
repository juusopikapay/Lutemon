package com.example.lutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Card
{
    View card;
    ImageView image;
    TextView name;

    public void Show(Lutemon lutemon)
    {
        image.setColorFilter(lutemon.getColor());
        name.setText(lutemon.getName());
        //open card
    }

    public void Close()
    {
        //close card
    }
}
