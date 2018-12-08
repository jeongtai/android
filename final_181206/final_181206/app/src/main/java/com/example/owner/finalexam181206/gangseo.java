package com.example.owner.finalexam181206;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;


public class gangseo extends AppCompatActivity {


    EditText edit; //댓글 입력하는 에디트 텍스트
    RatingBar rate; //별점 저장하는 변수
    Button webBtn;// 해당 맥주회사 홈피 페이지를 띄우는 버튼
    Button httpBtn;//우리가 만든 사이트 홈피 띄우는 버튼
    TextView opinion; //입력한 댓글을 띄우기 위해 댓글을 저장하는 변수
    String str;// 입력한 댓글을 저장하는 변수

    Button coup; //쿠폰 띄우는 버튼
    Button loc;  //맵 연결되는 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gangseo);

        rate = (RatingBar) findViewById(R.id.ratingbar);

        httpBtn = (Button) findViewById(R.id.webButton);
        httpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        webBtn = (Button) findViewById(R.id.webviewButton);
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gangseo.this, seven_webview.class);
                startActivity(intent);
            }
        });

        coup = (Button) findViewById(R.id.couponButton);
        coup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gangseo.this, couponpop.class);
                startActivity(intent);

            }
        });

        loc=(Button)findViewById(R.id.locationButton);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(gangseo.this,MapsSeven.class);
                startActivity(intent);
            }
        });
    }

}
