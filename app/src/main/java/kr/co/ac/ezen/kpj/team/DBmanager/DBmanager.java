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
        String query = "CREATE TABLE Category (id	INTEGER PRIMARY KEY AUTOINCREMENT,category TEXT,title TEXT,content TEXT);";
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL("Insert into Category values(null,'lookaround','hardware','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'lookaround','gesture','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction','contact','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction','call','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction','call2','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction','message','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction','message2','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction','camera','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction','video','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction','album','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting','textsize','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting','brightness','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting','colouring','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting','sound','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting','alarm','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting','display','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore','basic','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore','search','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore','install','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore','delete','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk','basic','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk','profile','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk','text','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk','album','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk','voice','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk','group','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'internet','basic','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet','use','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet','use2','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet','favorite','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic','basic','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic','search','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic','subway','아직내용은 미정');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



}