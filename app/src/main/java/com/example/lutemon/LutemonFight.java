using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class LutemonFight : MonoBehaviour
{
    public Lutemon Lutemon { get; private set; }
    [SerializeField] float pointToMove;
    [SerializeField] SpriteRenderer body;
    [SerializeField] Slider health;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    public void SetLutemon(Lutemon lutemon)
    {
        Lutemon = lutemon;
        body.color = lutemon.Color;
    }

    // Update is called once per frame
    public void Attack(Lutemon enemy)
    {
        StartCoroutine(Move());
        Lutemon.DoAttack(enemy);
    }

    public void UpdateHealth()
    {
        health.value = Lutemon.Health/Lutemon.MaxHealth;
    }

    IEnumerator Move()
    {
        float time = 0;
        float startPoint = transform.position.y;

        while(time<1)
        {
            float t = time*2;
            if(t>1)
            {
                t=2-t;
            }
            transform.position = new(0,Mathf.Lerp(startPoint,pointToMove,t));
            time += Time.deltaTime;
            yield return null;
        }
    }
}
