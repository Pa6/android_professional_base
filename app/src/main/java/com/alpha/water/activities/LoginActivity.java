package com.alpha.water.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alpha.water.R;
import com.alpha.water.fragments.LoginFragment;

/**
 * Created by Pascal dev on 3/03/2017.
 */

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener{

    public static Intent getIntent(Context context)
    {
        return new Intent(context, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frameLayout, LoginFragment.newInstance(null,null))
                .commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
