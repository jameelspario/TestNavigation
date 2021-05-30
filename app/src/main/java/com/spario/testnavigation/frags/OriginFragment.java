package com.spario.testnavigation.frags;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spario.testnavigation.R;
import com.spario.testnavigation.databinding.FragmentOriginBinding;

public class OriginFragment extends Fragment {

  FragmentOriginBinding binding;

    public OriginFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOriginBinding.inflate(inflater, container, false);
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
            //OriginFragmentArgs;
            //OriginFragmentDirections;

            String s = binding.etText.getText().toString();
            OriginFragmentDirections.ActionOriginFragmentToDestFragment dir = OriginFragmentDirections.actionOriginFragmentToDestFragment();
            dir.setStr(s);
            Navigation.findNavController(v).navigate(dir);

        });

        if(getArguments()!=null){
            String s = getArguments().getString("K");
            binding.tvText.setText(s);
        }
    }


}