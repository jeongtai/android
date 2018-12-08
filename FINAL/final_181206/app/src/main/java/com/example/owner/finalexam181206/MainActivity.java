package com.example.owner.finalexam181206;


import android.content.Intent;
import android.os.Bundle;

import com.example.owner.finalexam181206.adapters.BeerDataAdapter;
import com.github.clans.fab.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.github.clans.fab.FloatingActionMenu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainActivity extends AppCompatActivity {
    public Beer beer;
    public ArrayList<Beer> beerdata;
    BeerDataAdapter adapter;
    ListView listview;




    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2,floatingActionButton3; //플러팅 버튼

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); // 액션바 숨기기~~~






        //플러팅 버튼 ~
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Comparator<Beer> textAsc = new Comparator<Beer>() {
                    @Override
                    public int compare(Beer o1, Beer o2) {
                        return o1.getBeername().compareTo(o2.getBeername());
                    }
                };
                Collections.sort(beerdata, textAsc);
                adapter.notifyDataSetChanged();
            }
        });

        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Comparator<Beer> textAsc = new Comparator<Beer>() {
                    @Override
                    public int compare(Beer o1, Beer o2) {
                        return o1.getBrand().compareTo(o2.getBrand());
                    }
                };
                Collections.sort(beerdata, textAsc);
                adapter.notifyDataSetChanged();
            }
        });

        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Comparator<Beer> textAsc = new Comparator<Beer>() {
                    @Override
                    public int compare(Beer o1, Beer o2) {
                        return o1.getArcohol().compareTo(o2.getArcohol());
                    }
                };
                Collections.sort(beerdata, textAsc);
                adapter.notifyDataSetChanged();

            }
        });
    //여기까지 플러팅버튼

        beerdata = new ArrayList<Beer>();

        beer = new Beer(R.drawable.beer1, "강서마일드에일", "세븐브로이", "알코올 : 4.6%", "",1);
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer2, "달서오렌지에일", "세븐브로이", "알코올 : 4.2%", "",2);
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer3, "전라에일", "세븐브로이", "알코올 : 4.5%", "",3);
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer4, "한강에일", "세븐브로이", "알코올 : 5.2%", "",4);
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer5, "행복충전주", "세븐브로이", "알코올 : 5.5%", "",5);
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer6, "국민 IPA", "더부스", "알코올 : 7.0%", "",6);
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer7, "대강페일에일", "더부스", "알코올 : 4.6%", "",7);
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer8, "긍정신레드에일", "더부스", "알코올 : 5.0%", "",8);
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer10, "광화문", "코리아크래프트브루어리", "알코올 : 5.0%","",9);
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer11, "여수", "코리아크래프트브루어리", "알코올 : 5.0%","",10);
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer12, "평창", "코리아크래프트브루어리", "알코올 : 4.9%","",11);
        beerdata.add(beer);


        //beername으로 intent 연결
        listview = (ListView) findViewById(R.id.listview);

        adapter = new BeerDataAdapter(getLayoutInflater(), beerdata);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (beerdata.get(position).beername.equals("강서마일드에일")) {
                    Intent intent = new Intent(MainActivity.this, gangseo.class);
                    startActivity(intent);
                } else if (beerdata.get(position).beername.equals("달서오렌지에일")) {
                    Intent intent = new Intent(MainActivity.this, dalseo.class);
                    startActivity(intent);
                } else if (beerdata.get(position).beername.equals("전라에일")) {
                    Intent intent = new Intent(MainActivity.this, jeolla.class);
                    startActivity(intent);
                } else if (beerdata.get(position).beername.equals("한강에일")) {
                    Intent intent = new Intent(MainActivity.this, hangang.class);
                    startActivity(intent);
                } else if (beerdata.get(position).beername.equals("행복충전주")) {
                    Intent intent = new Intent(MainActivity.this, haengbok.class);
                    startActivity(intent);
                } else if (beerdata.get(position).beername.equals("국민 IPA")) {
                    Intent intent = new Intent(MainActivity.this, kukmin.class);
                    startActivity(intent);
                } else if (beerdata.get(position).beername.equals("대강페일에일")) {
                    Intent intent = new Intent(MainActivity.this, taekang.class);
                    startActivity(intent);
                } else if (beerdata.get(position).beername.equals("긍정신레드에일")) {
                    Intent intent = new Intent(MainActivity.this, red.class);
                    startActivity(intent);
                } else if (beerdata.get(position).beername.equals("광화문")) {
                    Intent intent = new Intent(MainActivity.this, gwanghwamun.class);
                    startActivity(intent);
                } else if (beerdata.get(position).beername.equals("여수")) {
                    Intent intent = new Intent(MainActivity.this, yeosu.class);
                    startActivity(intent);
                } else if (beerdata.get(position).beername.equals("평창")) {
                    Intent intent = new Intent(MainActivity.this, pyeongchang.class);
                    startActivity(intent);
                }

            }
        });

    }
}



