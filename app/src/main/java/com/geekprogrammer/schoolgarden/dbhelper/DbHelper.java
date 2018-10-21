package com.geekprogrammer.schoolgarden.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;

import com.bumptech.glide.util.Util;
import com.geekprogrammer.schoolgarden.Plant;
import com.geekprogrammer.schoolgarden.utils.Utils;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteAssetHelper {
    private static final String DBNAME = "dbplants.db";
    private static final int DBVER = 1;

    private static final String TBLNAME = "plants";
    private static final String COLNAME = "name";
    private static final String COLSCNAME = "scienceName";
    private static final String COLCHARACTERISTICS = "characteristic";
    private static final String COLDATA = "pathData";

    public DbHelper(Context context) {
        super(context, DBNAME, null, DBVER);
    }

    public void addBitmap(String name, String sciencename, String characteristics, byte[] image) throws SQLiteException{
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLNAME, name);
        cv.put(COLSCNAME, sciencename);
        cv.put(COLCHARACTERISTICS, characteristics);
        cv.put(COLDATA, image);
        database.insert(TBLNAME, null, cv);
    }

    public byte[] getBitmapByName(String name){
        SQLiteDatabase database = this.getWritableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] select = {COLNAME, COLDATA};
        qb.setTables(TBLNAME);
        Cursor c = qb.query(database, select, "name = ?", new String[]{name}, null, null, null);
        byte[] result = null;
        if (c.moveToFirst()){
            do {
                result = c.getBlob(c.getColumnIndex(COLDATA));
            }while (c.moveToNext());
        }
        return result;
    }

    public List<Plant> getPlants(){
        List<Plant> plants = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] select = {COLNAME, COLSCNAME, COLCHARACTERISTICS, COLDATA};
        qb.setTables(TBLNAME);
        Cursor c = qb.query(db, select, null, null, null, null, null);
        byte[] result = null;
        if (c.moveToFirst()){
            do {
                Plant plant = new Plant();
                plant.setName(c.getString(c.getColumnIndex(COLNAME)));
                plant.setScienceName(c.getString(c.getColumnIndex(COLSCNAME)));
                plant.setUse(c.getString(c.getColumnIndex(COLCHARACTERISTICS)));
                result = c.getBlob(c.getColumnIndex(COLDATA));
                plant.setPathImage(Utils.getImage(result));
                plants.add(plant);
            }while (c.moveToNext());
        }
        return plants;
    }
}
