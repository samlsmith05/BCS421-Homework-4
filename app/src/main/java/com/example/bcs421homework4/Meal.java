package com.example.bcs421homework4;

public class Meal {

    private String mainDish;
    private String sideDish;

    public String getMain() {
        return mainDish;
    }

    public void setMain(String mainDish) {
        this.mainDish = mainDish;
    }


    public String getSide() {
        return sideDish;
    }

    public void setSide(String sideDish) {
        this.sideDish = sideDish;
    }

    public Meal(String mainDish, String sideDish){
        this.mainDish = mainDish;
        this.sideDish = sideDish;
    }

}
