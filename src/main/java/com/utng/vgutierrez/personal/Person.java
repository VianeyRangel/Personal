package com.utng.vgutierrez.personal;

/**
 * Created by ulise on 20/02/2018.
 */

public class Person {
    private int imageId;
    private String name;
    private String station;
    private String scholarship;

    public Person(int imageId,
                  String name,
                  String station,
                  String scholarship){
        this.imageId = imageId;
        this.name = name;
        this.station = station;
        this.scholarship = scholarship;

    }
    public Person(){
        this(R.mipmap.ic_launcher,
                "unamed", "unlocated",
                "untyped");
    }
    public int getImageId(){
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getStation() {
        return station;
    }

    public String getScholarship() {
        return scholarship;
    }
}
