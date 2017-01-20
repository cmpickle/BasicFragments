package com.cmpickle.basicfragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class PowerListFragment extends Fragment implements View.OnClickListener {


    public PowerListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_power_list, container, false);

        setupClickListeners(view);
        return view;
    }

    private void setupClickListeners(View view) {
        setupClickListeners(view, R.id.fire);
        setupClickListeners(view, R.id.water);
        setupClickListeners(view, R.id.earth);
        setupClickListeners(view, R.id.air);
    }

    private void setupClickListeners(View view, int childViewId) {
        View childView = view.findViewById(childViewId);
        childView.setOnClickListener(this);
    }

    int translateIdToIndex(int id) {
        int index = 0;
        switch (id) {
            case R.id.fire:
                index = 0;
                break;
            case R.id.water:
                index = 1;
                break;
            case R.id.earth:
                index = 2;
                break;
            case R.id.air:
                index = 3;
                break;
        }
        return index;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        RadioButton rb = (RadioButton) v;
        CharSequence powerText = rb.getText();

        int index = translateIdToIndex(id);

        Activity activity = getActivity();
        PowerFragmentCoordinator powerFragmentCoordinator = (PowerFragmentCoordinator) activity;
        powerFragmentCoordinator.onSelectedPowerChanged(index);
    }
}
