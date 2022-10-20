package com.example.fragment.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.example.fragment.R;
import com.example.fragment.data.Message;

/**
 * Cuando se utiliza el componente fragment manager NUNCA se destruye el fragment, sino que
 * solo se destruye la vista y se guarda la instancia del fragment en memoria. POr eso nunca
 * se llama al método onDestroy()
 * de los fragment a no ser que se finalicen explícitamente
 */
public class MainActivity extends AppCompatActivity implements FragmentA.OnSetDataMessage{
    private Fragment fragmentb;
    private Fragment fragmenta;
    private FragmentManager fragmentManager;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmenta = getSupportFragmentManager().findFragmentByTag(FragmentA.TAG);
        fragmentManager = getSupportFragmentManager();
        if(savedInstanceState == null){
            fragmenta = new FragmentA(); //MAL
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(android.R.id.content, fragmenta);
            fragmentTransaction.commit();
        }
        //Gestor encargado de las transacciones de los Fragment

    }

    @Override
    public void onSetDataMessage(Message message) {
        fragmentb = new FragmentB();
        //Cuando se utiliza la transaccion para camviar de un fragment a otro. La
        //actividad le pasa la informacion a través de bundle
        Bundle bundle = new Bundle();
        bundle.putParcelable(Message.KEY, message );
        fragmentb.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragmentb);
        //Para guardar el fragmento a en la pila de fragmentos de la Activity se llama al méltodo
        //addToBackStack de forma que si el usuario pulsa la tecla Back en B -> se muestra A
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d(TAG, "MainActivity -> OnCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity -> OnResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity -> OnStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity -> OnStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity -> OnPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity -> OnDestroy()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}