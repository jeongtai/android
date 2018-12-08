package com.example.owner.finalexam181206.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.owner.finalexam181206.Beer;
import com.example.owner.finalexam181206.R;

import java.util.ArrayList;

public class BeerDataAdapter extends BaseAdapter {
    ArrayList<Beer> beerdata;
    LayoutInflater inflater;


    public BeerDataAdapter(LayoutInflater inflater, ArrayList<Beer> beerdata) {
        this.beerdata = beerdata;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return beerdata.size(); //datas의 개수를 리턴
    }

    @Override
    public Object getItem(int position) {
        return beerdata.get(position).beername;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    //뷰 홀더를 적용하지 않을 땐 항상 xml 리소스에 접근해 성능이 저하됨.
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;
        //뷰가 없을 경우 새로 생성하고 뷰 홀더를 만들음.
        // 한 번도 inflate 되지 않은 view일 수도 있끼 때문에 null 체크 해주기.
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listitem, null);
            viewholder = new ViewHolder();
            viewholder.beerimage = (ImageView) convertView.findViewById(R.id.beerimage);
            viewholder.beername = (TextView) convertView.findViewById(R.id.beername);
            viewholder.brand = (TextView) convertView.findViewById(R.id.brand);
            viewholder.arcohol = (TextView) convertView.findViewById(R.id.arcohol);
            viewholder.rating = (TextView) convertView.findViewById(R.id.rating);
            convertView.setTag(viewholder);
        }else {
            //이미 캐시된 뷰가 있을 경우 저장된 뷰 홀더를 사용. 즉, 재활용함.
            viewholder = (ViewHolder) convertView.getTag();
        }

        viewholder.beerimage.setImageResource(beerdata.get(position).getBeerimage());
        viewholder.beername.setText(beerdata.get(position).getBeername());
        viewholder.brand.setText(beerdata.get(position).getBrand());
        viewholder.arcohol.setText(beerdata.get(position).getArcohol());

        for (beerdata.get(position).key = 1; beerdata.get(position).key < 11; beerdata.get(position).key++) {
            double ran = Math.random();
            String strNumber = String.format("%.2f", ran);
            float fNumber = Float.parseFloat(strNumber);
            viewholder.rating.setText("별점 : " + String.valueOf(9 + fNumber));
        }
        return convertView;
    }
    public class ViewHolder {
        public ImageView beerimage;
        public TextView beername;
        public TextView brand;
        public TextView arcohol;
        public TextView rating;
    }
}

