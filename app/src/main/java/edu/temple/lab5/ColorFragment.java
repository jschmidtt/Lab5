package edu.temple.lab5;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    View v;
    Context context;

    String color;

    public static String COLOR_KEY = "color";

    public ColorFragment() {
        // Required empty public constructor
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get resources with context
        //String[] values = context.getResources().getStringArray();
        //Get Bundle
        Bundle bundle = getArguments();
        //Set to this color
        this.color = bundle.getString(COLOR_KEY);
    }

    public static ColorFragment newInstance(String color){
        //Create instances of the Fragment
        ColorFragment colorFragment = new ColorFragment();
        //Passing Arguments && Creating Bundle
        Bundle bundle = new Bundle();
        bundle.putString(ColorFragment.COLOR_KEY, color);
        colorFragment.setArguments(bundle);
        return colorFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_color, container, false);

        v.setBackgroundColor(Color.parseColor(color));

        return v;
    }

}
