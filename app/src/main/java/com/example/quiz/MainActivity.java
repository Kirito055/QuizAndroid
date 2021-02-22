package com.example.quiz;

import android.os.Bundle;
import android.os.Message;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView question, timer,questionConter;
    private String TAG = MainActivity.class.getSimpleName();
    ArrayList<HashMap<String, String>> questionList;

    Button Aans,Bans,Cans,Dans;
    ArrayList<Question> questions=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.question);
        questionConter = findViewById(R.id.questionConter);
        timer = findViewById(R.id.timer);
        Aans = findViewById(R.id.Aans);
        Bans = findViewById(R.id.Bans);
        Cans = findViewById(R.id.Cans);
        Dans = findViewById(R.id.Dans);
        //JsonReader obj=new JsonReader("C:\\Users\\82530\\IdeaProjects\\Quiz\\Json\\question.json");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response
        String url = "https://github.com/Kirito055/QuizAndroid/blob/master/Json/question.json";
        String jsonStr = sh.makeServiceCall(url);
        Log.e(TAG, "Response from url: " + jsonStr);
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array node
                JSONArray questions = jsonObj.getJSONArray("questions");

                // looping through All Contacts
                for (int i = 0; i < questions.length(); i++) {
                    JSONObject c = questions.getJSONObject(i);
                    String id = c.getString("id");
                    String question = c.getString("question");
                    String Aanswer = c.getString("Aanswer");
                    String Banswer = c.getString("Banswer");
                    String Canswer = c.getString("Canswer");
                    String Danswer = c.getString("Danswer");
                    String Correct = c.getString("Correct");
//
//                    // Phone node is JSON Object
//                    JSONObject phone = c.getJSONObject("phone");
//                    String mobile = phone.getString("mobile");
//                    String home = phone.getString("home");
//                    String office = phone.getString("office");

                    // tmp hash map for single contact
                    HashMap<String, String> questionu = new HashMap<>();

                    // adding each child node to HashMap key => value
                    questionu.put("id", id);
                    questionu.put("question", question);
                    questionu.put("Aanswer", Aanswer);
                    questionu.put("Banswer", Banswer);
                    questionu.put("Canswer", Canswer);
                    questionu.put("Danswer", Danswer);
                    questionu.put("Correct", Correct);

                    // adding contact to contact list
                    questionList.add(questionu);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Json parsing error: " + e.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });

            }

        } else {
            Log.e(TAG, "Couldn't get json from server.");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),
                            "Couldn't get json from server. Check LogCat for possible errors!",
                            Toast.LENGTH_LONG).show();
                }
            });
        }

    }


}