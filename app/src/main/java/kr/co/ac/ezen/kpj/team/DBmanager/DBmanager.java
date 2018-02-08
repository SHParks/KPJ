package kr.co.ac.ezen.kpj.team.DBmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018-02-08.
 */

public class DBmanager extends SQLiteOpenHelper {
    Context context;
    public DBmanager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase ) {
        String query = "CREATE TABLE Category (id	INTEGER PRIMARY KEY AUTOINCREMENT,category TEXT);";
        String query2 = "CREATE TABLE Content (id INTEGER,id_list INTEGER PRIMARY KEY AUTOINCREMENT,content TEXT,img TEXT,src TEXT);";
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



}