package com.teleone.loginregapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.teleone.loginregapp.R;

import static com.teleone.loginregapp.Utils.SignUp_Fragment;

public class LoginFragment extends Fragment {
    private View view;
    private TextView signUpBtn;
    private FragmentManager fragmentManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.login_screen, container, false);
        signUpBtn = view.findViewById(R.id.login_goToSignUo);
        fragmentManager = getActivity().getSupportFragmentManager();


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getContext()!=null){
                    signUp();
                }
            }
        });



        return view;
    }

    private void signUp() {
        final MaterialDialog dialog = new MaterialDialog.Builder(getContext())
                .title(R.string.signUpWith)
                .titleColor(getResources().getColor(R.color.colorPrimary))
                .customView(R.layout.signup_choice, true)
                .show();
        View views = dialog.getCustomView();

        if (views != null) {

            final ImageView signWithFB = views.findViewById(R.id.signUp_with_fb);
            final ImageView signWithEmail = views.findViewById(R.id.signUp_with_email);

            signWithFB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            signWithEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.hide();

                    fragmentManager
                            .beginTransaction()
                            .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                            .replace(R.id.fragment_container, new SignUpFragment(),
                                    SignUp_Fragment).commit();


                }
            });
        }
    }


}
