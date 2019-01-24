package org.pursuit.unit_03_assessment.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.unit_03_assessment.model.MyPlanets;
import org.pursuit.unit_03_assessment.view.PlanetViewHolder;

import java.util.List;

import org.pursuit.unit_03_assessment.R;


public class PlanetAdapter extends RecyclerView.Adapter<PlanetViewHolder> {
    private List<MyPlanets> myPlanetsList;

    public PlanetAdapter(List<MyPlanets> myPlanetsList) {
        this.myPlanetsList = myPlanetsList;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_itemview, parent, false);
        return new PlanetViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int position) {
        planetViewHolder.onBind(myPlanetsList.get(position));
    }

    @Override
    public int getItemCount() {
        return myPlanetsList.size();
    }
}
