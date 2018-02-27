package kr.co.ac.ezen.kpj.team.DBmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import kr.co.ac.ezen.kpj.team.Beans.ItemList;

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
        String query = "CREATE TABLE Category (id	INTEGER PRIMARY KEY AUTOINCREMENT,code TEXT,title TEXT,content TEXT);";
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL("Insert into Category values(null,'lookaround_hardware','외부구조와 버튼','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'lookaround_gesture','스마트폰 사용법','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_contact','연락처 저장','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_call','전화걸기','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_call2','연락처를 통한 전화걸기','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_message','문자보내기','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_message2','연락처를 통한 문자보내기','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_camera','사진촬영','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_video','동영상촬영','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_album','앨범보기','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_textsize','글자크기 설정','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_brightness','화면밝기 설정','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_colouring','벨소리 변경','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_sound','음량크기 설정','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_alarm','알람 설정','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_display','배경화면 설정','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_basic','기본설명-플레이스토어','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_search','플레이스토어 접속/검색','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_install','어플리케이션 설치','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_delete','어플리케이션 삭제','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_basic','기본설명-카카오톡','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_profile','프로필등록','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_text','문자보내기','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_album','사진보내기','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_voice','음성보내기','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_group','단체카톡방 초대','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_basic','기본설명-인터넷','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_use','기본인터넷 사용','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_use2','어플리케이션을 활용한 검색','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_favorite','즐겨찾기 등록','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic_basic','기본설명-교통정보','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic_search','어플리케이션을 활용한 길찾기','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic_subway','지하철 노선도 검색','아직내용은 미정');");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public String gettitle(String code) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Category where code='"+code+"'" ,null);
        String title= "";
        while (cursor.moveToNext()) {//컬럼의 번째가 i이다.
            title = cursor.getString(2);
        }
        cursor.close();
        Log.d("jpjp",title);
        return title;
    }

    public String getcontent(String code) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Category where code='"+code+"'" ,null);
        String content= "";
        while (cursor.moveToNext()) {//컬럼의 번째가 i이다.
            content = cursor.getString(3);
        }
        cursor.close();
        return content;
    }

    public ArrayList<ItemList> getSearchList(String Searchtitle){
        ArrayList<ItemList> searchlist = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Category where title like '%"+Searchtitle+"%'" ,null);
        //Cursor cursor = db.rawQuery("select * from Category where REPLACE(title, ' ','') like '%"+Searchtitle+"%'" ,null); 띄어쓰기 무시

        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String code = cursor.getString(1);
            String title = cursor.getString(2);
            String content = cursor.getString(3);

            searchlist.add(new ItemList(id,code,title,content));
        }
        if (searchlist.size()>=1){
            Log.d("shb 검색된 갯수는 : ",searchlist.size()+"");
            return searchlist;
        } else{
            Log.d("shb 검색된 갯수는 : ","없습니다.");
            return null;
        }
    }
}