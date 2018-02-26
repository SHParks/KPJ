package kr.co.ac.ezen.kpj.team.DBmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        sqLiteDatabase.execSQL("Insert into Category values(null,'lookaround_hardware','외부구조와 버튼','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'lookaround_gesture','스마트폰 사용법','아직내용은 미정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_contact','연락처 저장','1. 전화버튼 선택 \n 2. 번호입력 \n 3. 연락처 추가버튼 선택 \n 4. 새 연락처 추가 선택 \n 5. 상대방 정보입력 \n 6. 우측상단 저장버튼 선택');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_call','전화걸기','1. 전화버튼 선택 \n 2. 번호 입력 \n 3. 좌측하단 통화버튼 선택');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_call2','연락처를 통한 전화걸기','1. 연락처 선택 \n 2. 메세지 보내고자하는 상대 선택 \n 3. 우측 통화버튼 선택');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_message','문자보내기','1. 메세지 선택 \n 2. 우측 상단 새 메세지 작성 버튼 선택 \n 3. 상대방 번호 입력 \n 4. 메세지 내용 입력 \n 5. 전송버튼 선택');"); // gif 번호입력해서 보내는 걸로 다시 따야할듯
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_message2','연락처를 통한 문자보내기','1. 연락처 선택 \n 2. 저장된 연락처 검색 \n 3. 왼쪽으로 스와이프 후 메세지 보내기 선택');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_camera','사진촬영','1. 카메라 선택 \n 2. 초점확인 후 카메라 촬영');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_video','동영상촬영','1. 카메라 선택 \n 2. 카메라, 동영상 전환버튼 클릭 \n 3. 초점확인 후 동영상 촬영');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicfunction_album','앨범보기','1. 갤러리 선택 \n 2. 저장된 사진, 동영상 파일선택');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_textsize','글자크기 설정','1. 환경설정 선택 \n 2. 내 디바이스 선택 \n 3. 디스플레이 선택 \n 서체-글자크기 선택 후 설정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_brightness','화면밝기 설정','1. 환경설정 선택 \n 2. 내 디바이스 선택 \n 3. 디스플레이 선택 \n 4. 밝기 선택 \n 5. 밝기조절');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_colouring','벨소리 변경','1. 환경설정 선택 \n 2. 내 디바이스 선택 \n 3. 소리선택 \n 4. 벨소리 선택후 선정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_sound','음량크기 설정','1. 환경설정 선택 \n 2. 내 디바이스 선택 \n 3. 소리선택 \n 4.음량 선택 후 소리크기 설정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_alarm','알람 설정','1. 알람/시간 선택 \n 2. 알람추가 우측 플러스 버튼 선택 \n 3. 시간설정 \n 4. 원하는 요일 설정 \n 5. 저장버튼 선택');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'basicsetting_display','배경화면 설정','1. 환경설정 선택 \n 2. 내 디바이스 선택 \n 디스플레이 선택 \n 배경화면 선택 \n 홈화면 선택 후 사진 설정');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_basic','기본설명','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_search','구글스토어 접속/검색','1. PlayStore 선택 \n 2. 상단 검색창 선택 후 검색어 입력 \n 3. 검색 후 선택');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_install','어플리케이션 설치','1. 검색한 어플리케이션 선택 \n 2. 설치버튼 선택');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'playstore_delete','어플리케이션 삭제','1. 바탕화면에서 삭제할 앱 길게 누르기 \n 2. 앱을 누른 상태에서 제거 버튼으로 끌어 넣기');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_basic','기본설명','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_profile','프로필등록','1. 카카오톡 어플 선택 \n 2. 휴대전화 번호 입력 후 다음버튼 선택 \n 3. 문자로 전송된 인증번호 입력 후 다음 선택 \n 4. 카카오톡 계정없이 시작하기 선택 \n 5. 이름 입력후 가입완료');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_text','문자보내기','1. 카카오톡 어플 선택 \n 2. 연락상대 프로필 선택 \n 3. 1:1 채팅 선택 \n 4. 메세지 입력후 보내기 선택');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_album','사진보내기','1. 하단 플러스 버튼 선택 \n 2. 사진 선택 \n 3. 보내고자하는 사진 선택 후 전송');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_voice','음성보내기','1. 하단 플러스 버튼 선택 \n 2. 음성메세지 선택 \n 3. 버튼을 눌러 녹음 후 정지버튼 선택 \n 4. 전송버튼 선택');"); // 카카오톡 들어가있는 상태에서 실행되어야 하지 않을까?
        sqLiteDatabase.execSQL("Insert into Category values(null,'kakaotalk_group','단체카톡방 초대','1. 상단 대화 모양 선택 \n 2. 우측 하단 플러스 버튼 선택 \n 3. 일반채팅 선택 \n 4. 채팅하고자 하는 사람들 선택 \n 5. 확인 후 메세지 입력');");

        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_basic','기본설명','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_use','기본인터넷 사용','1. 배경화면에서 크롬(삼색원모양) 어플 선택 \n 2. 중간 검색창에 검색어 입력 \n 3. 검색버튼 선택');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_use2','어플리케이션을 활용한 검색','1. 네이버 어플 선택 \n 2. 중간 검색창에 검색어 입력 \n 3. 검색버튼 선택');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'internet_favorite','즐겨찾기 등록','1. 우측상단 세로점 3개 선택 \n 2. 별모양 선택');");   // 즐겨찾기 들어가는 방법도 같이 들어가면 좋지 않을까?

        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic_basic','기본설명','아직내용은 미정');");
        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic_search','어플리케이션을 활용한 길찾기','gif 다시따야함 네이버 지도필요 ');");  //
        sqLiteDatabase.execSQL("Insert into Category values(null,'traffic_subway','지하철 노선도 검색','1. 출발하고자하는 역 선택 \n 2. 출발역 설정 \n 3. 도착하고자하는 역 선택 \n 4. 도착역 설정 \n 5. 출발시간 선택 ');");  // traffic_ search 로 대체
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public String gettitle(String code) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Category where category='"+code+"'" ,null);
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
        Cursor cursor = db.rawQuery("select * from Category where category='"+code+"'" ,null);
        String content= "";
        while (cursor.moveToNext()) {//컬럼의 번째가 i이다.
            content = cursor.getString(3);
        }
        cursor.close();
        return content;
    }
}