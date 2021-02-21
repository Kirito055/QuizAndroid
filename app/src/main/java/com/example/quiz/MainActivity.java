package com.example.quiz;

import android.os.Bundle;
import android.util.JsonReader;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView question, timer,questionConter;
    Button Aans,Bans,Cans,Dans;
    ArrayList<Question> questions=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question=findViewById(R.id.question);
        questionConter=findViewById(R.id.questionConter);
        timer=findViewById(R.id.timer);
        Aans=findViewById(R.id.Aans);
        Bans=findViewById(R.id.Bans);
        Cans=findViewById(R.id.Cans);
        Dans=findViewById(R.id.Dans);
        J obj=new JsonReader(C:\Users\82530\IdeaProjects\Quiz\Json)
    }
}