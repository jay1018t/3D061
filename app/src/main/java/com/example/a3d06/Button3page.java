package com.example.a3d06;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;

import java.util.Locale;


public class Button3page extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;
    CheckBox autoRead;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    String scoreMessage = "";
    private TextToSpeech ttobj;
    private Boolean bCanSpeakNow = false;
    private Boolean bAutoRead = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button3page);

        ttobj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    //int result = ttobj.setLanguage(Locale.TRADITIONAL_CHINESE);
                    //int result = ttobj.setLanguage(new Locale("zh", "HK"));
                    int result = ttobj.setLanguage(new Locale("yue", "HK"));
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        //Log.e("TTS", "This Language is not supported");
                    } else {
                        bCanSpeakNow = true;
                        ReadTheQuestion();
                    }
                } else {
                    //Log.e("TTS", "Initilization Failed!");
                }
            }
        });


        totalQuestionsTextView = findViewById(R.id.Total_Questions);

        questionTextView = findViewById(R.id.result);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        autoRead    = findViewById(R.id.Auto_ReadCheckBox);
        autoRead.setOnClickListener(this);
        autoRead.setChecked(true);

        loadNewQuestions();

        // Play the question
    }

    @Override
    public void onDestroy() {
// Don't forget to shutdown tts!
        if (ttobj != null) {
            ttobj.stop();
            ttobj.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {


            if (selectedAnswer.contains("." + QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                ttobj.speak("答對了!", TextToSpeech.QUEUE_FLUSH, null);
                score++;
            } else {
                ttobj.speak("答錯了!", TextToSpeech.QUEUE_FLUSH, null);
            }
            currentQuestionIndex++;
            loadNewQuestions();

        } else if (clickedButton.getId() == R.id.Auto_ReadCheckBox)
        {
            if (autoRead.isChecked())
            {
                bAutoRead   = true;
                ReadTheQuestion();
            }
            else
            {
                bAutoRead   = false;
                ttobj.stop();
            }
        }
        else {
            //單擊選擇按鈕
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }

    }

    void loadNewQuestions() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        totalQuestionsTextView.setText("問題 : " + (currentQuestionIndex + 1) + "/" + totalQuestion);

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

        if (bCanSpeakNow) {
            ReadTheQuestion();
        }
    }

    void ReadTheQuestion() {
        if (bAutoRead && bCanSpeakNow) {
            String cs = questionTextView.getText().toString();
            ttobj.speak(cs, TextToSpeech.QUEUE_ADD, null);
        }
    }



    void finishQuiz(){
        String passStatus = "";
        if(score >= totalQuestion*0.50){
            passStatus = "Is Passed Good bro";

        }else{
            passStatus = "Failed eat my shit";
        }

        scoreMessage    = "得分是 "+ score+" / "+ totalQuestion;

        if (score == 0) {
            ttobj.speak("你真系人才!",  TextToSpeech.QUEUE_FLUSH, null);
        }
        if (score == 6) {
            ttobj.speak("你真系天才!",  TextToSpeech.QUEUE_FLUSH, null);
        }

/*
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("得分是 "+ score+" / "+ totalQuestion)
                .setPositiveButton("完成",(dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
*/
        restartQuiz();
    }

    void restartQuiz()
    {
        /*
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestions();
          */
        String localmessage=scoreMessage;
        Intent intent = new Intent(Button3page.this, finalresultpage.class);
        intent.putExtra("scoreMessage", localmessage);
        startActivity(intent);
    }


}