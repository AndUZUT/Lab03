package com.example.lab3.data;

import com.example.lab3.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */

public class LoginDataSource {

    String[] users = new String[]{"test1:test1", "test2:test2", "test3:test3"};

    public Result<LoggedInUser> login(String username, String password) {

        try {
            for(int i =0; i < users.length ; i++){

                for (String credential : users) {
                    String[] pieces = credential.split(":");
                    if (pieces[0].equals(username)) {
                        if(pieces[1].equals(password)){
                            LoggedInUser newUser = new LoggedInUser(java.util.UUID.randomUUID().toString(),username);

                            return new Result.Success<>(newUser);
                        }
                        else{
                            return new Result.Pass();
                        }
                    }
                }


            }
            return new Result.Error(new IOException("Error logging in"));
            // TODO: handle loggedInUser authentication

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }


    public void logout() {
        // TODO: revoke authentication
    }
}
