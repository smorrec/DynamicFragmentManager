package com.example.fragment.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.data.Message;
import com.example.fragment.databinding.FragmentABinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {
    private FragmentABinding binding;
    private OnSetDataMessage listener;
    public static final String TAG = "Fragment A";

    //Se declara una interfaz con el/los métodos que ofrece
    //este Fragment (contrato)

    interface OnSetDataMessage{
        void onSetDataMessage(Message message);
    }

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnSetDataMessage) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "debe implementar la interfaz");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater);
        binding.setMessage(new Message());
        binding.button.setOnClickListener(view -> listener.onSetDataMessage(binding.getMessage()));
        Log.d(TAG, "Fragment A -> OnCreateView()");
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Fragment A -> OnResume()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment A -> OnStart()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment A -> OnStop()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Fragment A -> OnPause()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        Log.d(TAG, "Fragment A -> OnDestryView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment A -> OnDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "Fragment A -> OnDetach()");
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