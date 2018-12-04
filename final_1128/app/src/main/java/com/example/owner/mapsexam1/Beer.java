package com.example.owner.mapsexam1;

public class Beer {

    String beername;
    String brand;
    String arcohol;
    String rating;
    int beerimage;


    public Beer(int beerimage, String beername,String brand, String arcohol,String rating){
        this.beername = beername;
        this.brand = brand;
        this.arcohol = arcohol;
        this.rating = rating;
        this.beerimage = beerimage;

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

}
