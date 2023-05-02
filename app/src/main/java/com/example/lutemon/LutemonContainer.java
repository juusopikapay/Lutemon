package com.example.lutemon;

import android.media.Image;
import android.widget.ImageView;

import org.w3c.dom.Text;

public class LutemonContainer
{
    Lutemon lutemon;

    ImageView image;
    Text nameText;

    public LutemonContainer()
    {
        //Create Box where is lutemon image and text for name;
    }

    public void AssignLutemon(Lutemon lutemon)
    {
        this.lutemon = lutemon;
        image.setColorFilter();
        nameText.text = lutemon.Name;
        if (onAssign != null)
        {
            onAssign.Invoke();
        }
        if (nullView != null) nullView.SetActive(false);
    }

    public void EmptyLutemon()
    {
        lutemon = null;
        image.setColorFilter();
        nameText.text = "";
    }

    public void UpdateLutemon()
    {
        nameText.text = lutemon.Name;
    }

    public Lutemon Lutemon { get { return lutemon; } }
}
