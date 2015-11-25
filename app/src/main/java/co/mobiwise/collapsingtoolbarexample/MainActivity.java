package co.mobiwise.collapsingtoolbarexample;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity  {
    private GridView gridViewObj;
    private ArrayList<Item> themeArray = new ArrayList<>();
    private ArrayList<Integer> dialogArray = new ArrayList<>();
    private ThemesAdapter themesAdapter;
    private DialogImagesAdapter dialogImagesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme_layout);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Themes");



        //set Main grid view item
        themeArray.add(new Item(R.drawable.morning, "Evening"));
        themeArray.add(new Item(R.drawable.re, "Morning"));
        themeArray.add(new Item(R.drawable.morning, "Night"));

        //set Dialog grid view item
        dialogArray.add(R.drawable.morning);
        dialogArray.add(R.drawable.re);
        dialogArray.add(R.drawable.morning);
        dialogArray.add(R.drawable.re);
        dialogArray.add(R.drawable.morning);
        dialogArray.add(R.drawable.re);
        dialogArray.add(R.drawable.morning);
        dialogArray.add(R.drawable.re);
        dialogArray.add(R.drawable.morning);
        dialogArray.add(R.drawable.morning);
        dialogArray.add(R.drawable.re);
        dialogArray.add(R.drawable.morning);

        //render ThemesAdapter
        gridViewObj = (GridView) findViewById(R.id.gridTheme);
        themesAdapter = new ThemesAdapter(this, themeArray);
        gridViewObj.setAdapter(themesAdapter);

        //set DialogAdapter object
        dialogImagesAdapter = new DialogImagesAdapter(this, dialogArray);

        // onclick of add item button
        ImageButton addButt = (ImageButton) findViewById(R.id.addButton);
        addButt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.image_click));
                // get dialog_items.xml view
                LayoutInflater li = LayoutInflater.from(MainActivity.this);
                View promptsView = li.inflate(R.layout.dialog_items, null);

                // set dialog_items.xml to alertdialog builder
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setView(promptsView);

                // set items of dialog_items
                final EditText userInput = (EditText) promptsView.findViewById(R.id.editTextDialogUserInput);
                gridViewObj = (GridView) promptsView.findViewById(R.id.gridView_Dialog);
                gridViewObj.setAdapter(dialogImagesAdapter);

                // set dialog message and actions
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        String input = userInput.getText().toString();
                                        if(input.matches(""))
                                        {
                                            Toast.makeText(getApplicationContext(), "please enter the theme name", Toast.LENGTH_SHORT).show();
                                            return;
                                        }
                                        themeArray.add(new Item(R.drawable.morning,input ));
                                        gridViewObj = (GridView) findViewById(R.id.gridTheme);
                                        gridViewObj.setAdapter(themesAdapter);
                                        Toast.makeText(getApplicationContext(), "Ok button click activity", Toast.LENGTH_SHORT).show();

                                    }

                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });
       /* ImageButton imageButton = (ImageButton) findViewById(R.id.editImageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               *//* Intent intent = new Intent(MainActivity.this, EditImageButton.class);
                startActivity(intent);
                finish();*//*
                 Toast.makeText(getApplicationContext(), "Image button click activity", Toast.LENGTH_SHORT).show();
            }
        });*/
    }


}



