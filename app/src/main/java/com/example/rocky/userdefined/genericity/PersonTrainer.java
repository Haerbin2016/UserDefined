package com.example.rocky.userdefined.genericity;

import android.util.Log;

import java.util.List;

/**
 * Created by Rocky on 2016/5/24.
 */
public class PersonTrainer {
    //只能读
    public void act(List<? extends Employee> list){
        for(Employee employee:list){
            String name = employee.getName();
            Log.d("sam","name="+name);
        }
    }
    //只能写
    public <T> void actSuper(List<? super Manager> list){
        list.add(new Manager("super mike"));
        list.add(new Ceo("super Rock"));
        //return list;
    }
}
