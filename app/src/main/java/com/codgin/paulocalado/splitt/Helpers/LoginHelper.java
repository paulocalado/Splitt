package com.codgin.paulocalado.splitt.Helpers;

import android.content.Context;
import android.widget.Toast;

import com.codgin.paulocalado.splitt.LoginActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by paulocalado on 02/10/17.
 */

public class LoginHelper {

    public static void facebookLoginSuccess(LoginButton loginButton, final Context context){

        Profile profile = Profile.getCurrentProfile();
        Toast.makeText(context, "Ola" + profile.getFirstName(), Toast.LENGTH_LONG).show();

    }
}
