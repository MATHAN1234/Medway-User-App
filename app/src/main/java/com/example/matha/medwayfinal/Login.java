package com.example.matha.medwayfinal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matha.medwayfinal.Common.Common;
import com.example.matha.medwayfinal.Model.Rider;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class Login extends AppCompatActivity {


    Button reg;
    Button logi;
    private Button nbtn_signIn;
    private EditText nEmail;
    private EditText nPassword;
    private FirebaseAuth auth;
    private FirebaseDatabase db;
    private DatabaseReference users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //init paperdb

        Paper.init(this);


        //init firebase
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference(Common.user_rider);
        // init buttons
        nEmail=(EditText)findViewById(R.id.emailAdd);
        nPassword=(EditText)findViewById(R.id.passwordUser);
        reg = (Button) findViewById(R.id.buttonregister);
        logi = (Button) findViewById(R.id.buttonlogin);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                //::Registeration
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });

        String user_field = Paper.book().read(Common.User_Field);
        String Pas_field = Paper.book().read(Common.Pwd_Field);

        if(user_field!=null && Pas_field!=null)
        {

            if(!TextUtils.isEmpty(user_field)&& !TextUtils.isEmpty(Pas_field))
            {

                AutoLogin(user_field,Pas_field);
            }
        }

        logi.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        final ProgressDialog mDialog = new ProgressDialog(Login.this);
                                        mDialog.setMessage("signing in....");
                                        mDialog.show();
                                        if(TextUtils.isEmpty(nEmail.toString()))
                                        { Toast.makeText(Login.this, "Enter Email", Toast.LENGTH_SHORT).show();
                                            return; }
                                        if(TextUtils.isEmpty(nPassword.toString()))
                                        { Toast.makeText(Login.this, "Enter password", Toast.LENGTH_SHORT).show();
                                            return; }
                                        auth.signInWithEmailAndPassword(nEmail.getText().toString().trim(),
                                                nPassword.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                            @Override
                                            public void onSuccess(AuthResult authResult) {
                                                mDialog.dismiss();
                                                FirebaseDatabase.getInstance().getReference(Common.user_rider).child(FirebaseAuth.getInstance()
                                                        .getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                        Paper.book().write(Common.User_Field,nEmail.getText().toString());
                                                        Paper.book().write(Common.Pwd_Field,nPassword.getText().toString());
                                                        Common.currentRider = dataSnapshot.getValue(Rider.class);
                                                        startActivity( new Intent(Login.this,Navigation.class));
                                                        finish(); }
                                                    @Override
                                                    public void onCancelled(DatabaseError databaseError) {

                                                    }
                                                });
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(Login.this, "Failed to Sign In" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                                mDialog.dismiss(); }}); }
                                }
        );
    }

    private void AutoLogin(String user_field, String pas_field) {
        final ProgressDialog mDialog = new ProgressDialog(Login.this);
        mDialog.setMessage("signing in....");
        mDialog.show();
        auth.signInWithEmailAndPassword(user_field,pas_field).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                mDialog.dismiss();

                FirebaseDatabase.getInstance().getReference(Common.user_rider).child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Common.currentRider = dataSnapshot.getValue(Rider.class);
                        //:Navigation
                        startActivity( new Intent(Login.this,Navigation.class));
                        finish();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login.this, "Failed to Sign In" + e.getMessage(), Toast.LENGTH_SHORT).show();
                mDialog.dismiss();
            }
        });


    }

    public void fate(View v){

        Toast.makeText(this, "Succesfully Login", Toast.LENGTH_SHORT).show();
    }
    public void fan(View v){

        Toast.makeText(this, "911 to the Rescue...!", Toast.LENGTH_SHORT).show();
    }


    }

