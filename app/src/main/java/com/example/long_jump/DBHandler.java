package com.example.long_jump;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static final  String DB_NAME ="Events";
    private static final int DB_VERSION=1;
    private static final String TABLE_NAME = "Athlete";
    private static final String NAME="name";
    private static final String CHEST_NO="chest_no";
    private static final String DOB = "dob";
    private static final String SCORE1= "score1";
    private static final String SCORE2= "score2";
    private static final String SCORE3= "score3";



    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +" ("+NAME+"TEXT,"+CHEST_NO+"TEXT,"+
                DOB+"TEXT,"+SCORE1+"NUMBER,"+SCORE2+"NUMBER,"+SCORE3+"NUMBER)";

        db.execSQL(query);
    }

    public void addNewAthlete(String name,String chest_no,String dob)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,name);
        values.put(CHEST_NO,chest_no);
        values.put(DOB,dob);

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public Cursor getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String updateQuery="Select *  from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(updateQuery,null);
        return cursor;
    }

    public void addScore(String chest_no,int score1,int score2,int score3)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SCORE1,score1);
        values.put(SCORE2,score2);
        values.put(SCORE3,score3);
        String query="select * from "+TABLE_NAME+" where chest_no = ?";

        Cursor cursor = db.rawQuery(query,new String[] {chest_no});
        if(cursor.getCount() > 0)
        {
            long result = db.update(TABLE_NAME,values,"name=?",new  String[]{chest_no});
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
