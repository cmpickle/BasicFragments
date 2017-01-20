package com.cmpickle.basicfragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PowerDescriptionFragment extends Fragment {
    final String POWER_INDEX_STATE_KEY = "powerIndex";
    final int POWER_DEFAULT_VALUE = 0;

    TextView descriptionView;
    String[] powerDescriptions;
    int powerIndex;

    public PowerDescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_power_description, container, false);

        descriptionView = (TextView) fragmentView.findViewById(R.id.powerDescription);
        powerDescriptions = getResources().getStringArray(R.array.powerDescriptions);

        powerIndex = savedInstanceState == null? POWER_DEFAULT_VALUE : savedInstanceState.getInt(POWER_INDEX_STATE_KEY, POWER_DEFAULT_VALUE);

        setDisplayDescription(powerIndex);
        return fragmentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(POWER_INDEX_STATE_KEY, powerIndex);
    }

    public void setDisplayDescription(int powerIndex) {
        this.powerIndex = powerIndex;
        descriptionView.setText(powerDescriptions[powerIndex]);
    }
}
