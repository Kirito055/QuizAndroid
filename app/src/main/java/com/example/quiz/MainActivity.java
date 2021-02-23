package com.example.quiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView timer, questionConter, number, gradec;
    ImageFilterView question;
    int count;
    int grade = 0;
    CountDownTimer tm;
    private String TAG = MainActivity.class.getSimpleName();
    ArrayList<Question> questionList = new ArrayList<>();

    Button Aans, Bans, Cans, Dans;

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
        gradec = findViewById(R.id.grade);
        number = findViewById(R.id.number);

        //JsonReader obj=new JsonReader("C:\\Users\\82530\\IdeaProjects\\Quiz\\Json\\question.json");
//        HttpHandler sh = new HttpHandler();
        questionList.add(new Question(1, R.drawable.aisha, "Akniet", "Aisha", "Eldar", "Daryia", "Aisha"));
        questionList.add(new Question(1, R.drawable.akniet, "Akniet", "Aisha", "Eldar", "Daryia", "Akniet"));
        questionList.add(new Question(1, R.drawable.daryia, "Akniet", "Aisha", "Eldar", "Daryia", "Daryia"));
        questionList.add(new Question(1, R.drawable.eldar, "Akniet", "Aisha", "Eldar", "Daryia", "Eldar"));
        questionList.add(new Question(1, R.drawable.sabit, "Akniet", "Sabit", "Eldar", "Daryia", "Sabit"));
        count = 0;
        loadQuestions(count);
        tm = new CountDownTimer(12 * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Time over", Toast.LENGTH_SHORT).show();


            }
        };
        // Making a request to url and getting response
//        String url = "https://github.com/Kirito055/QuizAndroid/blob/master/Json/question.json";
//        String jsonStr = sh.makeServiceCall(url);
//        Log.e(TAG, "Response from url: " + jsonStr);
//        if (jsonStr != null) {
//            try {
//                JSONObject jsonObj = new JSONObject(jsonStr);
//
//                JSONArray questions = jsonObj.getJSONArray("questions");
//
//                for (int i = 0; i < questions.length(); i++) {
//                    JSONObject c = questions.getJSONObject(i);
//                    long id = c.getLong("id");
//                    int question = c.getInt("question");
//                    String Aanswer = c.getString("Aanswer");
//                    String Banswer = c.getString("Banswer");
//                    String Canswer = c.getString("Canswer");
//                    String Danswer = c.getString("Danswer");
//                    String Correct = c.getString("Correct");
//                    Question questionobj =new Question(id,question,Aanswer,Banswer,Canswer,Danswer,Correct);
//
//                    // Phone node is JSON Object
//                    JSONObject phone = c.getJSONObject("phone");
//                    String mobile = phone.getString("mobile");
//                String home = phone.getString("home");
//                    String office = phone.getString("office");
//
//                    // tmp hash map for single contact
//
//
//                    // adding each child node to HashMap key => value
//
//                    System.out.println(questionobj);
//                    // adding contact to contact list
//                    questionList.add(questionobj);
//
//
//
//
//                }
//
//            } catch (final JSONException e) {
//                Log.e(TAG, "Json parsing error: " + e.getMessage());
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(),
//                                "Json parsing error: " + e.getMessage(),
//                                Toast.LENGTH_LONG).show();
//                    }
//                });
//
//            }
//
//        } else {
//            Log.e(TAG, "Couldn't get json from server.");
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(getApplicationContext(),
//                            "Couldn't get json from server. Check LogCat for possible errors!",
//                            Toast.LENGTH_LONG).show();
//                }
//            });
//        }

    }

    public void loadQuestions(int n) {
        final Question q = questionList.get(n);
        questionConter.setText((n + 1) + "/" + questionList.size());
        question.setImageResource(q.getImage());
        Aans.setText("" + q.getAanswer());
        Bans.setText("" + q.getBanswer());
        Cans.setText("" + q.getCanswer());
        Dans.setText("" + q.getDanswer());
        gradec.setText("Correct answer " + grade);
        timer.setText("" + 12);
        if (tm != null) {
            tm.start();
        }


        Aans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Aans.getText().equals(q.getCorrect())) {
                    Toast.makeText(MainActivity.this, "Correct answwer", Toast.LENGTH_SHORT).show();

                    if (count < (questionList.size() - 1)) {
                        tm.cancel();
                        count++;
                        grade++;
                        loadQuestions(count);
                    } else {
                        Toast.makeText(MainActivity.this, "The end ", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();

                    if (count < (questionList.size() - 1)) {
                        tm.cancel();
                        count++;
                        loadQuestions(count);
                    } else {
                        Toast.makeText(MainActivity.this, "The end ", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        Bans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Bans.getText().equals(q.getCorrect())) {
                    Toast.makeText(MainActivity.this, "Correct answwer", Toast.LENGTH_SHORT).show();

                    if (count < (questionList.size() - 1)) {
                        tm.cancel();
                        count++;
                        grade++;
                        loadQuestions(count);
                    } else {
                        Toast.makeText(MainActivity.this, "The end ", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();

                    if (count < (questionList.size() - 1)) {
                        tm.cancel();
                        count++;
                        loadQuestions(count);
                    } else {
                        Toast.makeText(MainActivity.this, "The end ", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        Cans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Cans.getText().equals(q.getCorrect())) {
                    Toast.makeText(MainActivity.this, "Correct answwer", Toast.LENGTH_SHORT).show();
                    if (count < (questionList.size() - 1)) {

                        tm.cancel();
                        count++;
                        grade++;
                        loadQuestions(count);
                    } else {
                        Toast.makeText(MainActivity.this, "The end ", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();

                    if (count < (questionList.size() - 1)) {
                        tm.cancel();
                        count++;
                        loadQuestions(count);
                    } else {
                        Toast.makeText(MainActivity.this, "The end ", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        Dans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Dans.getText().equals(q.getCorrect())) {
                    Toast.makeText(MainActivity.this, "Correct answwer", Toast.LENGTH_SHORT).show();

                    if (count < (questionList.size() - 1)) {
                        tm.cancel();
                        count++;

                        grade++;
                        loadQuestions(count);
                    } else {
                        Toast.makeText(MainActivity.this, "The end ", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    if (count < (questionList.size() - 1)) {
                        tm.cancel();
                        count++;
                        loadQuestions(count);
                    } else {
                        Toast.makeText(MainActivity.this, "The end ", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }


}