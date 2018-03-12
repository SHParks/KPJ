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
//        sqLiteDatabase.execSQL("Insert into Category values(null,'lookaround_hardware','외부구조와 버튼','아직내용은 미정');");
//        sqLiteDatabase.execSQL("Insert into Category values(null,'lookaround_gesture','스마트폰 사용법','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_contact','연락처 저장','1. 전화 어플을 켭니다.\n2. 저장하실 전화번호를 입력 하신 후 추가 버튼을 누릅니다.\n3. 이름을 입력 후 저장을 누릅니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_call','전화걸기','전화번호를 입력 후 통화 버튼을 누릅니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_call2','연락처를 통한 전화걸기','1. 연락처를 켭니다.\n2. 전화거실 상대방을 확인 후 통화 버튼을 누릅니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_message','문자보내기','1. 메세지 어플을 켭니다.\n2. 받으실 분의 연락처를 입력 후 메세지를 입력합니다.\n3. 전송 버튼을 누릅니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_message2','연락처를 통한 문자보내기','1. 연락처 어플을 켭니다.\n2. 메세지를 받으실 분은 확인 한 후 꾹 누르시거나 왼쪽으로 잡아 끌어보냅니다.\n3. 내용을 작성 후 보냅니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_camera','사진촬영','카메라 어플을 켜고 우측에 촬영 버튼을 누릅니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_video','동영상촬영','카메라 어플을 켜고 촬영 모드를 동영상으로 바꾼 후 촬영 버튼을 누릅니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_album','앨범보기','앨범 어플을 켜고 촬영한 사진이나 동영상을 봅니다.');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_textsize','글자크기 설정','1. 설정에 들어갑니다.\n2. 디스플레이로 들어갑니다.\n3. 글자크기 메뉴로 이동하여 크기를 조정합니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_brightness','화면밝기 설정','1. 설정에 들어갑니다.\n2. 디스플레이로 들어갑니다.\n3. 밝기메뉴로 이동하여 밝기를 조절합니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_colouring','벨소리 변경','1. 설정에 들어갑니다.\n2. 소리로 들어갑니다.\n3. 벨소리를 선택 합니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_sound','음량크기 설정','1. 휴대전화 좌측의 음량 버튼을 누르거나 설정으로 들어갑니다.\n2. 소리로 들어갑니다.\n3. 음량을 조절합니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_alarm','알람 설정','1. 알람 어플을 켭니다.\n2. 추가를 누릅니다.\n3. 시간을 설정하고 저장을 누릅니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_display','배경화면 설정','1. 설정에 들어갑니다.\n2. 디스플레이로 들어갑니다.\n3. 배경화면을 선택합니다.');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_basic','기본설명-플레이스토어','앱을 검색하거나 설치할 때,\n안드로이드를 사용하는 사람은 모두 사용하는 어플입니다.\n아래 버튼을 누르면 앱으로 바로 이동합니다.\n\n');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_search','플레이스토어 접속/검색','1. PlayStore를 켭니다.\n2. 상단 검색창에 원하는 어플을 검색합니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_install','어플리케이션 설치','1. 검색된 어플리케이션을 눌러 들어가서 설치 버튼을 누릅니다.\n2. 설치가 끝난 후 열기버튼 또는 홈 화면에서 앱을 클릭하여 실행합니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_delete','어플리케이션 삭제','1. 삭제하실 어플을 꾹 누릅니다.\n2. 우측 상단에 삭제에 끌어다 놓습니다.');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_basic','기본설명-카카오톡','대한민국 국민 메신저 카카오톡 입니다.\n카카오톡에 대한 기본 기능에 대해 다루고 있습니다.\n아래 버튼을 누르면 앱으로 바로 이동합니다.\n\n');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_profile','프로필등록','1. 카카오톡을 설치하고 연락처 인증을 받습니다.\n2. 계정등록하거나 생략 후 이름을 입력하고 시작합니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_text','문자보내기','1. 보내실 분을 누른 후 1:1채팅을 누릅니다.\n2. 내용을 작성 하고 우측에 보내기 버튼을 누릅니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_album','사진보내기','1. 좌측에 +버튼을 누릅니다.\n2. 사진을 누르고 원하는 사진을 누르신 후 보내기 버튼을 누릅니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_voice','음성보내기','1. 좌측에 +버튼을 누릅니다.\n2. 음성메세지를 누릅니다.\n3. 가운데 녹음버튼을 눌러 녹음 후 보냅니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_group','단체카톡방 초대','1. 채팅방 탭에서 +버튼을 누릅니다.\n2. 일반채팅방을 구성할 인원을 모두 클릭 후 확인을 누릅니다.');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_basic','기본설명-인터넷','안드로이드 공식 인터넷 브라우저 크롬입니다.\n기본적으로 구글에서 검색을 지원하고, 빠른 속도가 장점입니다.\n아래 버튼을 누르면 앱으로 바로 이동합니다.\n\n');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_use','기본인터넷 사용','1. 크롬 어플을 켭니다.\n2. 첫 화면인 구글에서 원하시는 검색어를 입력합니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_use2','어플리케이션을 활용한 검색','1. 네이버 어플을 켭니다.\n2. 첫 화면인 네이버에서 원하시는 검색어를 입력합니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_favorite','즐겨찾기 등록','원하시는 페이지에서 상단 ...을 누르신 후 별마크를 누릅니다.');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic_basic','기본설명-교통정보','지하철 길찾기 어플 중, 가장 잘 구성되어 있는\n지하철 종결자 입니다.\n앱 내 검색등에 대한 정보를 다루고 있습니다.\n아래 버튼을 누르면 앱으로 바로 이동합니다.\n\n');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic_search','어플리케이션을 활용한 길찾기','1. 지하철종결자 어플을 켭니다.\n2. 원하시는 역을 클릭하면 관련 정보가 나옵니다.');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic_subway','지하철 노선도 검색','1. 지하철종결자 어플을 켭니다.\n2. 좌측 상단에 검색에서 역을 검색합니다.\n3. 클릭하면 해당 역의 위치와 정보가 나옵니다.');");
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

    public ItemList getItem(String writeCode){
        SQLiteDatabase db = getReadableDatabase();
        ItemList item = new ItemList();
        Cursor cursor = db.rawQuery("select * from Category where code='"+writeCode+"'" ,null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String code = cursor.getString(1);
            String title = cursor.getString(2);
            String content = cursor.getString(3);

            item =  new ItemList(id,code,title,content);
        }
        return item;
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