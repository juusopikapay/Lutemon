package com.example.lutemon;


import java.util.Random;

public class BattleManager
{
    Lutemon player;
    Lutemon enemy;


    public void GiveEnemy()
    {
        /*if (chooseLutemon.Lutemon == null) return;
        player=chooseLutemon.Lutemon;
        int enemyExperience = player.getExperience()+new Random().nextInt(5)-2;
        if (enemyExperience < 0) enemyExperience = 0;
        enemy=Lutemon.RandomLutemon(enemyExperience);*/
    }

    public void StartFight()
    {
       CycleTurns();
    }
    
    void CycleTurns()
    {
        boolean playerTurn = false;

        while(player.getHealth()>0&&enemy.getHealth()>0)
        {
            if(playerTurn)
            {
                player.DoAttack(enemy);
            }
            else
            {
                enemy.DoAttack(player);
            }
            playerTurn = !playerTurn;
        }

        if(player.getHealth()>enemy.getHealth())
        {
            PlayerWon();
        }
        else
        {
            EnemyWon();
        }
    }

    void EnemyWon()
    {

    }

    void PlayerWon()
    {
        
    }
}
