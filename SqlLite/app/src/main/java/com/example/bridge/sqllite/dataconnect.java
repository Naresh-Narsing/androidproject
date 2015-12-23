package com.example.bridge.sqllite;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bridgelabz5 on 23/12/15.
 */
public class dataconnect extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Student.db";
    public static final String TABLE_NAME="Student_table";
    public static final String COL1="ID";
    public static final String COL2="NAME";
    public static final String COL3="SURNAME";
    public static final String COL4="MARKS";



     public dataconnect(Context context) {
        super(context,DATABASE_NAME , null, 1);
         // SQLiteDatabase db=this.getWritableDatabase(); //GOING TO CREATE DB N TABLE WHILE INSERTING REMOVE IT
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_NAME);
        onCreate(db);
    }


    //INSERT DATA

  public boolean insertdata(String name,String surname,String marks)
  {
      SQLiteDatabase db=this.getWritableDatabase();
      ContentValues contentValues=new ContentValues();
      contentValues.put(COL2,name);
      contentValues.put(COL3,surname);
      contentValues.put(COL4,marks);

     long result = db.insert(TABLE_NAME,null,contentValues);
      if(result == -1)

          return false;

      else

          return true;

  }
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updatedata(String id,String name,String surname,String marks)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,name);
        contentValues.put(COL3,surname);
        contentValues.put(COL4, marks);
        db.update(TABLE_NAME,contentValues,"ID = ?",new String[] {id});
        return true;
    }

    public Integer deletedata(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[] {id});
    }



}
