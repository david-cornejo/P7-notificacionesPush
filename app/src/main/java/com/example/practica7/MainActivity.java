package com.example.practica7;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
public class MainActivity extends AppCompatActivity {
    EditText etToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etToken = findViewById(R.id.etToken);
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            System.out.println("Fetching FCM registration token failed");
                            return;
                        }
// Get new FCM registration token
                        String token = task.getResult();
// Log and toast
                        System.out.println(token);
                        Toast.makeText(MainActivity.this,"El token de tu dispositivo es" + token, Toast.LENGTH_SHORT).show();
                        etToken.setText(token);
                    }
                });
    }
}