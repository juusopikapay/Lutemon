package com.example.lutemon;
import android.graphics.Color;
import java.util.Random;

public class Lutemon
{
    //private
    private String name;
    private int color;
    private int experience;
    private int attack;
    private int defense;
    private int maxHealth;
    private int health;

    //public
    public String getName()
    {
        return name;
    }
    public int getExperience()
    {
        return experience;
    }
    public int getAttack()
    {
        return attack;
    }
    public int getDefense()
    {
        return defense;
    }
    public int getMaxHealth()
    {
        return maxHealth;
    }
    public int getHealth()
    {
        return health;
    }
    public int getColor()
    {
        return Colors[color];
    }


    //functions

    Lutemon(int color, int attack, int defense, int maxHealth)
    {
        name = ColorNames[color];
        this.color = color;
        experience = 0;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        health = maxHealth;
    }

    public void GiveName(String name)
    {
        this.name = name;
    }

    public void AddMaxHealth()
    {
        maxHealth += 1;
        experience += 1;
    }

    public void AddAttack()
    {
        attack += 1;
        experience += 1;
    }

    public void AddDefense()
    {
        defense += 1;
        experience += 1;
    }

    public void DoAttack(Lutemon lutemon)
    {
        lutemon.DoDefense(attack);
    }

    public void DoDefense(int damage)
    {
        damage -= defense;
        health -= damage;
        if(health<0)
        {
            health = 0;
        }
    }

    //static

    //Returning random Lutemon with random skills corresponding to experience
    public static Lutemon RandomLutemon(int experience)
    {
        Lutemon lutemon = RandomLutemon();
        lutemon.experience = experience;
        for (int i = 0; i < experience; i++)
        {
            int whatToUpgrade=new Random().nextInt(3);
            switch(whatToUpgrade)
            {
                case 0:
                    lutemon.attack += 1;
                    break;
                case 1:
                    lutemon.defense += 1;
                    break;
                case 2:
                    lutemon.maxHealth += 1;
                    break;
            }
        }
        return lutemon;
    }

    public static Lutemon RandomLutemon()
    {
        int random = new Random().nextInt(5);
        switch(random)
        {
            case 1:
                return Black();
            case 2:
                return Orange();
            case 3:
                return Pink();
            case 4:
                return Green();
            default:
                return White();
        }
    }

    static Lutemon White()
    {
        return new Lutemon(0, 1, 2, 6);
    }

    static Lutemon Black()
    {
        return new Lutemon(1, 3, 2, 2);
    }

    static Lutemon Orange()
    {
        return new Lutemon(2, 2, 3, 2);
    }

    static Lutemon Pink()
    {
        return new Lutemon(3, 1, 3, 4);
    }

    static Lutemon Green()
    {
        return new Lutemon(4, 2, 1, 6);
    }

    static String[] ColorNames = new String[]
    {
        "White",
        "Black",
        "Orange",
        "Pink",
        "Green",
    };

    static int[] Colors = new int[]
    {
            Color.WHITE,
            Color.rgb(51, 51, 51), //black
            Color.rgb(255, 178, 102), //orange
            Color.rgb(255, 153, 230), //pink
            Color.rgb(204, 255, 179) //green
    };
}
