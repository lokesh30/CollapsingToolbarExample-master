package co.mobiwise.collapsingtoolbarexample;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EditImageButton extends AppCompatActivity {
// testing commit
    private boolean isLongPressed = false;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeViewsAdapter();
        loadData();
    }

    /**
     * Initializes views and adapter
     */
    private void initializeViewsAdapter(){

        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle("Morning");

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerViewAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    /**
     * load mock data to adapter
     */
    private void loadData(){
        /*Radio radio = new Radio("Bedroom Fan", R.drawable.temp);

        List<Radio> radioList = new ArrayList<>();

        for (int i = 0 ; i < 3; i++)
            radioList.add(radio);

        adapter.setRadioList(radioList);*/

        List<Radio> radioList = new ArrayList<>();
        /**
         * initialize the array list
         */

        radioList.add(new Radio("Bedroom Fan"));
        radioList.add(new Radio("Bedroom Lights"));
        radioList.add(new Radio("Hall Ac"));
        radioList.add(new Radio("Hall Lights"));
        radioList.add(new Radio("Bedroom2 Lights"));
        radioList.add(new Radio("Master Bedroom Fan"));
        radioList.add(new Radio("Kitchen Lights"));
        radioList.add(new Radio("Terrace Lights"));
        radioList.add(new Radio("Bedroom3 Lights"));
        radioList.add(new Radio("Child room Fan"));
        radioList.add(new Radio("Porch Lights"));


        adapter.setRadioList(radioList);


    }

}
