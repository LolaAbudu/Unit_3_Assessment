package org.pursuit.unit_03_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.controller.PlanetAdapter;
import org.pursuit.unit_03_assessment.model.MyPlanets;
import org.pursuit.unit_03_assessment.model.PlanetList;
import org.pursuit.unit_03_assessment.network.PlanetService;
import org.pursuit.unit_03_assessment.network.PlanetSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private TextView nameTextView;
    List<MyPlanets> myPlanetsList = new ArrayList<>();

    private static final String TAG = "allPlanets";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        //nameTextView = findViewById(R.id.name_textView_RecyclerView);

        recyclerView = findViewById(R.id.planet_recyclerView);

        Retrofit retrofit = PlanetSingleton.getSingleInstance();
        PlanetService planetService = retrofit.create(PlanetService.class);

        Call<PlanetList> planet = planetService.getPlanet();

            planet.enqueue(new Callback<PlanetList>() {
                @Override
                public void onResponse(Call<PlanetList> call, Response<PlanetList> response) {
                    Log.d(TAG, "onRespone: " + response.body().getPlanetsList().get(0).getName());

                    for (MyPlanets myPlanets : response.body().getPlanetsList()) {
                        myPlanetsList.add(myPlanets);
                        Log.d("test", "onResponse: " + myPlanetsList.size());
                    }

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                    PlanetAdapter planetAdapter = new PlanetAdapter(myPlanetsList);
                    recyclerView.setAdapter(planetAdapter);
                    recyclerView.setLayoutManager(linearLayoutManager);

//                    recyclerView.setAdapter(new PlanetAdapter(response.body().getPlanetsList().get(0)));
            //                //or can just pass do below without creating a new List and dont need the foreach loop either
                    ////                recyclerView.setAdapter(new AndoidAdapter(response.body().getAndroidList()));
                    ////                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


                }

                @Override
                public void onFailure(Call<PlanetList> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t.toString());
                }
            });



        /*
        * TODO: Add logic that will:
        * TODO done! 1. Make Retrofit instance for this endpoint: https://raw.githubusercontent.com/JDVila/storybook/master/planets.json
        * TODO done! 2. Make data model objects based on JSON
        * TODO done! 3. Make a service interface with method(s) to make a GET request
        * TODO done! 4. Make a request to the JSON endpoint using the Retrofit instance and the service
        * TODO done! 5. Subclass a RecyclerView Adapter
        * TODO done! 6. Subclass a RecyclerView ViewHolder
        * TODO 7. Pass list to RecyclerView
        * TODO 8. Display planet name in a RecyclerView tile
        * TODO done! 9. Implement an OnClickListener for the itemview
        * TODO done! 10. Pass the Planet Name, Number, and Image URL data to DisplayActivity when tile is clicked
        */

    }
}
