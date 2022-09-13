package com.elm.service;
import java.util.List;
import com.elm.po.Food;
public interface FoodService {
    public List<Food> listFoodByBusinessId(Integer businessId);
}