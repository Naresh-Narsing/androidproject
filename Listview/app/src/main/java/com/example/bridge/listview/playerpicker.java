package com.example.bridge.listview;

/**
 * Created by bridgelabz5 on 16/12/15.
 */
public class playerpicker {
    private int images;
    private String Top_3_players;
    private String goals;

    public int getImages() {
        return images;
    }

    public playerpicker(int images,String Top_3_players,String goals){
        this.setTop_3_players(Top_3_players);
        this.setImages(images);
        this.setGoals(goals);
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getTop_3_players() {
        return Top_3_players;
    }

    public void setTop_3_players(String top_3_players) {
        Top_3_players = top_3_players;
    }
}
