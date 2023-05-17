package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quiz.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    DatabaseHelper2 databaseHelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper2 = new DatabaseHelper2(this);

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.signupEmail.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String confirmpassword = binding.signupConfirm.getText().toString();

                if(email.equals("") || password.equals("") || confirmpassword.equals("")){
                    Toast.makeText(SignupActivity.this,"All fields are mandatory",Toast.LENGTH_SHORT).show();
                }else {
                    if(password.equals(confirmpassword)){
                        Boolean checkUserEmail = databaseHelper2.checkEmail(email);

                        if(checkUserEmail == false){
                            Boolean insert = databaseHelper2.insertData(email,password);

                            if(insert == true){
                                Toast.makeText(SignupActivity.this,"Signup Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(SignupActivity.this,"Signup Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignupActivity.this,"User already xists",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignupActivity.this,"Invalid password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.goToLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}