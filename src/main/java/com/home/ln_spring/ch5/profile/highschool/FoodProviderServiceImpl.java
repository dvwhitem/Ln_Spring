/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.profile.highschool;

import com.home.ln_spring.ch5.profile.Food;
import com.home.ln_spring.ch5.profile.FoodProviderService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitaliy
 */
public class FoodProviderServiceImpl implements FoodProviderService {

    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<Food>();
        lunchSet.add(new Food("Coke"));
        lunchSet.add(new Food("Hamburger"));
        lunchSet.add(new Food("French Fries"));
        
        return lunchSet;
    }
    
}
