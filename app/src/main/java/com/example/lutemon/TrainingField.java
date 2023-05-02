package com.example.lutemon;

public class TrainingField
{
    LutemonContainer container;

    public void TrainAttack()
    {
        container.Lutemon.AddAttack();
        container.EmptyLutemon();
    }

    public void TrainDefense()
    {
        container.Lutemon.AddAttack();
        container.EmptyLutemon();
    }
}
