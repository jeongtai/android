package com.example.owner.finalexam181206;

public class Beer {

    String beername;        // 맥주 이름
    String brand;           // 맥주 브랜드 이름
    String arcohol;         // 맥주 도수(알코올)
    String rating;          // 맥주 평점(랜덤)
    int beerimage;         // 맥주 이미지
    int key;


    public Beer(int beerimage, String beername,String brand, String arcohol,String rating, int key){
        this.beername = beername;
        this.brand = brand;
        this.arcohol = arcohol;
        this.rating = rating;
        this.beerimage = beerimage;
        this.key= key;
    }

    public String getBeername(){
        return beername;
    }
    public String getBrand(){
        return brand;
    }
    public String getArcohol(){
        return arcohol;
    }
    public String getRating(){
        return rating;
    }
    public int getBeerimage(){
        return beerimage;
    }
    public int getKey() {return key;}


    public void setBeername(String beername){
        this.beername= beername;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setArcohol(String arcohol){
        this.arcohol= arcohol;
    }
    public void setRating(String rating){
        this.rating= rating;
    }
    public void setBeerimage(int beerimage){
        this.beerimage= beerimage;
    }
    public void setKey(int key) {this.key = key;}

}

