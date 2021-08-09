package com.example.marco.pianotutor;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView lbl_answer;
    private Button btn_check;
    private Button btn_next;
    private EditText txf_answer;
    private ImageView img_question;
    private SecureRandom srand;

    private int currentImage;
    private int[] images = {
            R.mipmap.tastatur_a,
            R.mipmap.tastatur_ais,
            R.mipmap.tastatur_as,
            R.mipmap.tastatur_b,
            R.mipmap.tastatur_c,
            R.mipmap.tastatur_cis,
            R.mipmap.tastatur_d,
            R.mipmap.tastatur_des,
            R.mipmap.tastatur_dis,
            R.mipmap.tastatur_e,
            R.mipmap.tastatur_es,
            R.mipmap.tastatur_f,
            R.mipmap.tastatur_fis,
            R.mipmap.tastatur_g,
            R.mipmap.tastatur_ges,
            R.mipmap.tastatur_gis,
            R.mipmap.tastatur_h
    };
    private HashMap<Integer,String> imageToAnswer = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMap();

        srand = new SecureRandom();


        btn_check = (Button) findViewById(R.id.btn_check);
        btn_check.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });


        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               nextQuestion();
            }
        });

        lbl_answer = (TextView) findViewById(R.id.lbl_answer);
        txf_answer = (EditText) findViewById(R.id.txf_answer);
        img_question = (ImageView) findViewById(R.id.img_question);

        nextQuestion();
    }
    private void initMap(){
        imageToAnswer.put(0,"a");
        imageToAnswer.put(1,"ais");
        imageToAnswer.put(2,"as");
        imageToAnswer.put(3,"b");
        imageToAnswer.put(4,"c");
        imageToAnswer.put(5,"cis");
        imageToAnswer.put(6,"d");
        imageToAnswer.put(7,"des");
        imageToAnswer.put(8,"dis");
        imageToAnswer.put(9,"e");
        imageToAnswer.put(10,"es");
        imageToAnswer.put(11,"f");
        imageToAnswer.put(12,"fis");
        imageToAnswer.put(13,"g");
        imageToAnswer.put(14,"ges");
        imageToAnswer.put(15,"gis");
        imageToAnswer.put(16,"h");

    }
    public void checkAnswer(){
        System.out.println("Current: " + imageToAnswer.get(currentImage));
        System.out.println("Input: " + txf_answer.getText());
        if(imageToAnswer.get(currentImage).equals(txf_answer.getText().toString().toLowerCase().trim())){
            lbl_answer.setText(R.string.lbl_answer_correct);
        }
        else {
            lbl_answer.setText(R.string.lbl_answer_wrong);
        }

    }
    public void nextQuestion(){
        lbl_answer.setText(R.string.lbl_answer);
        currentImage = srand.nextInt(images.length);

        img_question.setImageResource(images[currentImage]);
    }
}
