package org.pursuit.unit_03_assessment.model;

import java.util.List;

public class PlanetList {
    private List<MyPlanets> planets;

    public PlanetList(List<MyPlanets> planets) {
        this.planets = planets;
    }

    public List<MyPlanets> getPlanetsList() {
        return planets;
    }

    public void setPlanets(List<MyPlanets> planets) {
        this.planets = planets;
    }
}
