package com.spario.testnavigation.frags;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spario.testnavigation.R;
import com.spario.testnavigation.databinding.FragmentDestBinding;

public class DestFragment extends Fragment {

    FragmentDestBinding binding;

    public DestFragment() {  }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDestBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnText.setOnClickListener(v->{

            NavController nav = Navigation.findNavController(v);
            Bundle b = new Bundle();
            b.putString("K", binding.etText.getText().toString());
            nav.setGraph(R.navigation.nav_graph, b);
            nav.popBackStack();
        });

        if(getArguments()!=null) {
            String s = OriginFragmentArgs.fromBundle(getArguments()).getStr();
            binding.tvText.setText(s);
        }

    }


}
