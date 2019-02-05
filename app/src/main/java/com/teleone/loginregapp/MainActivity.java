package com.teleone.loginregapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.teleone.loginregapp.Fragment.LoginFragment;

import static com.teleone.loginregapp.Utils.Login_Fragment;

public class MainActivity extends AppCompatActivity {
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        // If savedinstnacestate is null then replace login fragment
        if (savedInstanceState == null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, new LoginFragment(),
                            Utils.SignUp_Fragment).commit();
        }

    }
    // Replace Login Fragment with animation
    public void replaceSignInFragment() {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                .replace(R.id.fragment_container, new LoginFragment(),
                        Utils.Login_Fragment).commit();
    }



    @Override
    public void onBackPressed() {

        backback();

    }

    public void backback(){
        // Find the tag of signup and forgot password fragment
        Fragment SignUp_Fragment = fragmentManager
                .findFragmentByTag(Utils.SignUp_Fragment);
        Fragment ForgotPassword_Fragment = fragmentManager.findFragmentByTag(Utils.ForgotPassword_Fragment);
        Fragment LogIn = fragmentManager.findFragmentByTag(Login_Fragment);

        // Check if both are null or not
        // If both are not null then replace login fragment else do backpressed
        // task


        if (SignUp_Fragment != null)
            replaceSignInFragment();
        else if (ForgotPassword_Fragment != null)
            replaceSignInFragment();
        else
            super.onBackPressed();
    }



}
