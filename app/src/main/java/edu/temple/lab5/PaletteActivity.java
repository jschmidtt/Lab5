package edu.temple.lab5;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class PaletteActivity extends AppCompatActivity {

    Spinner spinner;
    final private int REQUEST_CODE_MESSAGE_DISPLAY = 934;
    private static final String LOG_TAG = "PaletteActivity";
    Boolean first = true;
    //Fragment Manger
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        setTitle(R.string.title_one);

        //Set Colors
        Resources res = getResources();
        final String myColorsDisplay[] = res.getStringArray(R.array.colors_array_display); //For Spanish Display
        final String myColors[] = res.getStringArray(R.array.colors_array); //For colorParse (aka cant parse blanco -> white)
        //Log.e(LOG_TAG,myColors[0]);

        //Find Spinner
        spinner = findViewById(R.id.spinner);


        //Adapter
        ColorAdapter adapter = new ColorAdapter(this,myColors,myColorsDisplay);
        spinner.setAdapter(adapter);

        //Listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Check to see if first launch so does not instantly launch
                if(!first) {
                    String colorData = (String) parent.getItemAtPosition(position);
                    fm.beginTransaction().add(R.id.container_1, ColorFragment.newInstance(colorData)).addToBackStack(null).commit();
                    /*
                    //Log.e(LOG_TAG,colorData);
                    Intent startActivityIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    startActivityIntent.putExtra(CanvasActivity.DATA_KEY, colorData);
                    startActivity(startActivityIntent);
                    */
                }
                first = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
