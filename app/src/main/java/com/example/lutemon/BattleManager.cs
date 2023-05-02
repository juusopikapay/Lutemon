using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BattleManager : MonoBehaviour
{
    [SerializeField] LutemonFight player;
    [SerializeField] LutemonFight enemy;

    [Header("UI")]
    [SerializeField] UIManager ui;
    [SerializeField] LutemonContainer chooseLutemon;


    // Start is called before the first frame update
    void Start()
    {
        
    }

    public void GiveEnemy()
    {
        if (chooseLutemon.Lutemon == null) return;
        player.SetLutemon(chooseLutemon.Lutemon);
        int enemyExperience = player.Lutemon.Experience+Random.Range(-2, 3);
        if (enemyExperience < 0) enemyExperience = 0;
        enemy.SetLutemon(Lutemon.RandomLutemon(enemyExperience));
        ui.ShowCard(enemy.Lutemon);
        Invoke(nameof(StartFight), 3f);
    }

    public void StartFight()
    {
        ui.CloseCard();
    }
    
    public IEnumerator CycleTurns()
    {
        bool playerTurn = false;

        while(player.Lutemon.Health>0&&enemy.Lutemon.Health>0)
        {
            if(playerTurn)
            {
                player.Attack(enemy.Lutemon);
                enemy.UpdateHealth();
            }
            else
            {
                enemy.Attack(enemy.Lutemon);
                player.UpdateHealth();
            }
            yield return new WaitForSeconds(1);
            playerTurn = !playerTurn;
        }

        if(player.Lutemon.Health>enemy.Lutemon.Health)
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
        player.Lutemon.SetStatus(Status.injured);
    }

    void PlayerWon()
    {
        
    }
}
