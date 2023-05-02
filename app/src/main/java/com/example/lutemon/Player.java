package com.example.lutemon;

import java.util.ArrayList;
import java.util.HashSet;

public class Player {
    ArrayList<Lutemon> lutemons = new ArrayList<>();

    private static Player player = null;

    public static Player getInstance()
    {
        if(player==null)
        {
            player=new Player();
        }
        return  player;
    }

    //Creating lutemon
    public void addLutemon()
    {
        Lutemon lutemon = Lutemon.RandomLutemon();
        lutemons.add(lutemon);
    }

    ArrayList<Lutemon> getLutemons()
    {
        return lutemons;
    }
}
