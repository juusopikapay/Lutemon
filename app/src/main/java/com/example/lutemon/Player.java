package com.example.lutemon;

import java.util.ArrayList;
import java.util.HashSet;

public class Player {
    UIManager uiManager = new UIManager();
    ArrayList<Lutemon> lutemons = new ArrayList<>();
    int coins=2;

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
    public void AddLutemon()
    {
        if (coins == 0) return;
        coins--;
        Lutemon lutemon = Lutemon.RandomLutemon();
        lutemons.add(lutemon);
        uiManager.ShowCard(lutemon);
        uiManager.UpdateCoins(coins);
    }

    ArrayList<Lutemon> getLutemons()
    {
        return lutemons;
    }

    public void AddCoin()
    {
        coins++;
        uiManager.UpdateCoins(coins);
    }
}
