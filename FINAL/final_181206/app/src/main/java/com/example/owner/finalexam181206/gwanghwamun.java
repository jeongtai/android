package com.example.owner.finalexam181206;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class gwanghwamun extends AppCompatActivity {


    EditText edit; //댓글 입력하는 에디트 텍스트
    RatingBar rate; //별점 저장하는 변수
    Button webBtn;// 해당 맥주회사 홈피 페이지를 띄우는 버튼
    Button httpBtn;//우리가 만든 사이트 홈피 띄우는 버튼
    TextView opinion; //입력한 댓글을 띄우기 위해 댓글을 저장하는 변수
    String str;// 입력한 댓글을 저장하는 변수

    Button coup; //쿠폰 띄우는 버튼
    Button loc;  //맵 연결되는 버튼
    Button favoriteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gwanghwamun);

        rate = (RatingBar) findViewById(R.id.ratingbar);

        opinion = (TextView) findViewById(R.id.opinionResult);


        favoriteButton = (Button) findViewById(R.id.favoriteButton);
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"즐겨찾기에 등록되었습니다.",Toast.LENGTH_LONG).show();
            }
        });


        httpBtn = (Button) findViewById(R.id.webButton);
        httpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://jeongtai.github.io/"));
                startActivity(intent);
                str = edit.getText().toString();
                opinion.setText(str);
            }
        });


        webBtn = (Button) findViewById(R.id.webviewButton);
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gwanghwamun.this, seven_webview.class);
                startActivity(intent);
            }
        });

        coup = (Button) findViewById(R.id.couponButton);
        coup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gwanghwamun.this, couponpop.class);
                startActivity(intent);

            }
        });

        loc=(Button)findViewById(R.id.locationButton);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(gwanghwamun.this,MapsSeven.class);
                startActivity(intent);
            }
        });
    }

}
