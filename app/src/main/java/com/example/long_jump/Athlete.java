package com.example.long_jump;

import java.util.Date;
import android.os.Parcel;
import android.os.Parcelable;

public class Athlete implements Parcelable{

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

    protected Athlete(Parcel in) {
        name = in.readString();
        chest_no = in.readString();
        DOB = in.readString();
        if (in.readByte() == 0) {
            score1 = null;
        } else {
            score1 = in.readInt();
        }
        if (in.readByte() == 0) {
            score2 = null;
        } else {
            score2 = in.readInt();
        }
        if (in.readByte() == 0) {
            score3 = null;
        } else {
            score3 = in.readInt();
        }
    }

    public static final Creator<Athlete> CREATOR = new Creator<Athlete>() {
        @Override
        public Athlete createFromParcel(Parcel in) {
            return new Athlete(in);
        }

        @Override
        public Athlete[] newArray(int size) {
            return new Athlete[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(chest_no);
        parcel.writeString(DOB);
        if (score1 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(score1);
        }
        if (score2 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(score2);
        }
        if (score3 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(score3);
        }
    }
}
