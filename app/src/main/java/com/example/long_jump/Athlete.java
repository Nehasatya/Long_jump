package com.example.long_jump;

import java.util.Date;

public class Athlete {

    String name;
    String chest_no;
    String DOB;
    Integer score1;
    Integer score2;
    Integer score3;

    Athlete(String name, String chest_no, String DOB)
    {
        this.name=name;
        this.chest_no=chest_no;
        this.DOB=DOB;

    }

    Athlete(Integer score1,Integer score2,Integer score3)
    {
        this.score1=score1;
        this.score2=score2;
        this.score3=score3;
    }
}
