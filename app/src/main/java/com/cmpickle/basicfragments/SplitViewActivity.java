package com.cmpickle.basicfragments;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;

public class SplitViewActivity extends Activity implements PowerFragmentCoordinator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_view);
    }

    @Override
    public void onSelectedPowerChanged(int index) {
        FragmentManager fragmentManager = getFragmentManager();
        PowerDescriptionFragment powerDescriptionFragment = (PowerDescriptionFragment) fragmentManager.findFragmentById(R.id.powerDescriptionFragment);

        powerDescriptionFragment.setDisplayDescription(index);
    }
}
