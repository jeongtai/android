package com.example.owner.finalexam181206;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BeerDataAdapter extends BaseAdapter {

    ArrayList<Beer> beerdata;
    LayoutInflater inflater;

    public BeerDataAdapter(LayoutInflater inflater, ArrayList<Beer> beerdata){
        this.beerdata= beerdata;
        this.inflater=inflater;
    }
    @Override
    public int getCount() {
        return beerdata.size(); //datas의 개수를 리턴
    }

    @Override
    public Object getItem(int position){
        return beerdata.get(position).beername;
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position,View convertView, ViewGroup parent){
        if(convertView==null){
            convertView= inflater.inflate(R.layout.listitem, null);
        }

        ImageView beerimage =(ImageView)convertView.findViewById(R.id.beerimage);
        TextView beername =(TextView)convertView.findViewById(R.id.beername);
        TextView brand =(TextView)convertView.findViewById(R.id.brand);
        TextView arcohol =(TextView)convertView.findViewById(R.id.arcohol);
        TextView rating = (TextView)convertView.findViewById(R.id.rating);


        beerimage.setImageResource(beerdata.get(position).getBeerimage());
        beername.setText(beerdata.get(position).getBeername());
        brand.setText(beerdata.get(position).getBrand());
        arcohol.setText(beerdata.get(position).getArcohol());


        for(beerdata.get(position).key= 1; beerdata.get(position).key<11;beerdata.get(position).key++) {
            double ran = Math.random();
            String strNumber = String.format("%.2f", ran);
            float fNumber = Float.parseFloat(strNumber);
            rating.setText("별점 : "+String.valueOf(9 + fNumber));
        }
       

        return convertView;

    }

}
