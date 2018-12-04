package com.example.owner.mapsexam1;


import android.content.Intent;
import android.os.Bundle;
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
    FloatingActionButton floatingActionButton1, floatingActionButton2; //플러팅 버튼

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //플러팅 버튼 ~
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);

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
    //여기까지 플러팅버튼

        beerdata = new ArrayList<Beer>();

        beer = new Beer(R.drawable.beer1, "강서마일드에일", "세븐브로이", "알코올 4.6%", "");
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer2, "달서오렌지에일", "세븐브로이", "알코올 4.2%", "");
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer3, "전라에일", "세븐브로이", "알코올 4.5%", "");
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer4, "한강에일", "세븐브로이", "알코올 5.2%", "");
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer5, "행복충전주", "세븐브로이", "알코올 5.5%", "");
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer6, "국민 IPA", "더부스", "알코올 7.0%", "");
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer7, "대강페일에일", "더부스", "알코올 4.6%", "");
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer8, "긍정신레드에일", "더부스", "알코올 5.0%", "");
        beerdata.add(beer);

        beer = new Beer(R.drawable.beer10, "광화문", "코리아크래프트브루어리", "알코올 5.0%", "");
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer11, "여수", "코리아크래프트브루어리", "알코올 5.0%", "");
        beerdata.add(beer);
        beer = new Beer(R.drawable.beer12, "평창", "코리아크래프트브루어리", "알코올 4.9%", "");
        beerdata.add(beer);



        listview = (ListView) findViewById(R.id.listview);

        adapter = new BeerDataAdapter(getLayoutInflater(), beerdata);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, gangseo.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, dalseo.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, jeolla.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(MainActivity.this, hangang.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(MainActivity.this, haengbok.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(MainActivity.this, kukmin.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(MainActivity.this, taekang.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(MainActivity.this, red.class);
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(MainActivity.this, gwanghwamun.class);
                    startActivity(intent);
                } else if (position == 9) {
                    Intent intent = new Intent(MainActivity.this, yeosu.class);
                    startActivity(intent);
                } else if (position == 10) {
                    Intent intent = new Intent(MainActivity.this, pyeongchang.class);
                    startActivity(intent);
                }

            }
        });

    }
}



