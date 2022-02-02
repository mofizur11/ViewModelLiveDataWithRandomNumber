package com.ideasoft.viewmodellivedatarandomnumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView showNumberTextView;
    private Button randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showNumberTextView = findViewById(R.id.show_number);
        randomNumber = findViewById(R.id.random);


        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        MutableLiveData<String> myRandomNumber = viewModel.getMyRandomNumber();

        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                showNumberTextView.setText(s);
            }
        });

        randomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.createRandomNumber();
            }
        });


    }


}