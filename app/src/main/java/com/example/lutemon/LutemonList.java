package com.example.lutemon;

import androidx.recyclerview.widget.RecyclerView;

import java.util.HashSet;
import java.util.List;

public class LutemonList
{
    Boolean choose;
    RecyclerView list;
    RecyclerView.Adapter adapter;
    UIManager manager;
    LutemonContainer caller=null;
    List<LutemonContainer> containers;

    //When lutemon is clicked in list, player is either shown Lutemon card or Lutemon is assigned to battle or training slot.
    public void ListObjectClicked(Lutemon lutemon)
    {
        if(choose)
        {
            if(caller!=null)
            {
                caller.AssignLutemon(lutemon);
            }
        }
        else
        {
            manager.ShowCard(lutemon);
        }
    }

    //First we clear the list and then we spawn new list object for each lutemon.
    public void UpdateList(HashSet<Lutemon> lutemons)
    {
        adapter.notifyItemInserted(lutemons.size()-1);

        for (Lutemon lutemon : lutemons)
        {
            LutemonContainer container = new LutemonContainer();
            containers.add(container);
            container.AssignLutemon(lutemon);
        }
    }

    public void UpdateContainers()
    {
        for (LutemonContainer c : containers)
        {
            c.UpdateLutemon();
        }
    }

    public void OpenList(LutemonContainer caller)
    {
        this.caller = caller;
    }
}