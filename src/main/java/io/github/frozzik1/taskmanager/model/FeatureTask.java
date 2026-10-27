package io.github.frozzik1.taskmanager.model;

public class FeatureTask extends Task{
    private int storyPoints;

    public FeatureTask(String title, String description, int storyPoints){
        super(title, description);
        this.storyPoints = storyPoints;
    }

    public int getStoryPoints(){
        return storyPoints;
    }

    public void setStoryPoints(int storyPoints){
        this.storyPoints = storyPoints;
    }

    @Override
    public String getTaskType(){
        return "FEATURE";
    }

    @Override
    public String toString() {
        return super.toString() + " | Story Points: " + storyPoints;
    }
}
