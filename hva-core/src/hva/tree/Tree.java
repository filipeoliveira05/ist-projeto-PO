package hva.tree;

import hva.state.Season;
import hva.state.SeasonState;
import hva.state.PrimaveraState;
import hva.state.VeraoState;
import hva.state.OutonoState;
import hva.state.InvernoState;

import java.io.Serial;
import java.io.Serializable;

public abstract class Tree implements Serializable {

    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081356L;

    private String id;
    private String name;
    private int age;
    private int difficulty;
    private Season season;
    private int passingSeasons = 0;
    private int seasonalEffort;
    private String biologicalCycle;

    public Tree(String id, String name, int age, int difficulty, Season season) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.difficulty = difficulty;
        this.season = season;
        this.updateSeasonalEffortAndCycle();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public Season getSeason() {
        return this.season;
    }

    public void setSeason(Season season) {
        this.season = season;
        this.updateSeasonalEffortAndCycle();
    }

    public int getPassingSeasons() {
        return this.passingSeasons;
    }

    public void passSeason() {
        this.passingSeasons += 1;
        this.updateSeasonalEffortAndCycle();
    }

    public int upgradeAge() {
        if (this.passingSeasons == 4) {
            this.age += 1;
            this.passingSeasons = 0;
        }
        return age;
    }

    public abstract String getType();

    public abstract int getSpecificSeasonalEffort(SeasonState seasonState);
    public abstract String getSpecificBiologicalCycle(SeasonState seasonState);

    private void updateSeasonalEffortAndCycle() {
        SeasonState seasonState = this.season.getState();
        this.seasonalEffort = getSpecificSeasonalEffort(seasonState);
        this.biologicalCycle = getSpecificBiologicalCycle(seasonState);
    }

    public int getSeasonalEffort() {
        return this.seasonalEffort;
    }

    public double cleaningEffort() {
        return getDifficulty() * getSeasonalEffort() * Math.log(getAge() + 1);
    }

    public String getBiologicalCycle() {
        return this.biologicalCycle;
    }
}