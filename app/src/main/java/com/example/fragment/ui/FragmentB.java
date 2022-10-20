package com.example.fragment.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fragment.R;
import com.example.fragment.data.Message;
import com.example.fragment.databinding.FragmentBBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {
    public static final String TAG = "Fragment B";
    private FragmentBBinding binding;
    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBBinding.inflate(inflater);

        binding.setMessage(getArguments().getParcelable(Message.KEY));

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        Log.d(TAG, "Fragment B -> onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment B -> onDestroy()");
    }

    public void setDataMessage(Message message){
        Toast.makeText(getActivity(), "Ha funcionado", Toast.LENGTH_SHORT).show();
        binding.setMessage(message);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(binding != null) {
            outState.putParcelable(Message.KEY, binding.getMessage());
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(binding != null && savedInstanceState != null){
            binding.setMessage(savedInstanceState.getParcelable(Message.KEY));
        }
    }
}