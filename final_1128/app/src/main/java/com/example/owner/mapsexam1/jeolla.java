package com.example.owner.mapsexam1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;


public class jeolla extends AppCompatActivity {


    EditText edit; //댓글 입력하는 에디트 텍스트
    RatingBar rate; //별점 저장하는 변수
    Button cmt_input;//맥주 관련해서 댓글 입력하는 버튼
    Button cmt_delete;//입력한 댓글 지우는 버튼
    Button webBtn;// 해당 맥주회사 홈피 페이지를 띄우는 버튼
    TextView opinion; //입력한 댓글을 띄우기 위해 댓글을 저장하는 변수
    String str;// 입력한 댓글을 저장하는 변수

    Button coup; //쿠폰 띄우는 버튼
    Button loc;  //맵 연결되는 버튼


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeolla);

        rate= (RatingBar)findViewById(R.id.ratingbar);
        edit= (EditText)findViewById(R.id.edittext);
        opinion=(TextView)findViewById(R.id.opinionResult);

        cmt_input= (Button)findViewById(R.id.button_cmtinput);
        cmt_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        /*        Intent intent = new Intent();
                intent.putExtra("INPUT_CMT",edit.getText().toString());
                setResult(RESULT_OK,intent);
                finish();*/
                str= edit.getText().toString();
                opinion.setText(str);
            }
        });
        cmt_delete= (Button)findViewById(R.id.button_cmtdelete);
        cmt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*        setResult(RESULT_CANCELED);*/
                opinion.setText("");

            }
        });

        webBtn=(Button)findViewById(R.id.webviewButton);
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(jeolla.this,seven_webview.class);
                startActivity(intent);
            }
        });
        coup = (Button) findViewById(R.id.couponButton);
        coup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(jeolla.this, couponpop.class);
                startActivity(intent);

            }
        });

        loc=(Button)findViewById(R.id.locationButton);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(jeolla.this,MapsSeven.class);
                startActivity(intent);
            }
        });
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            opinion.setText(data.getStringExtra("INPUT_CMT"));
        }
        else{
            opinion.setText("");
        }
    }*/

}
