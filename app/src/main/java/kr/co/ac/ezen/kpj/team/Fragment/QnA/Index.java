package kr.co.ac.ezen.kpj.team.Fragment.QnA;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ac.ezen.kpj.team.Beans.Board_Item;
import kr.co.ac.ezen.kpj.team.Fragment.QnA.Adapter.Index_Adapter;
import kr.co.ac.ezen.kpj.team.R;
import kr.co.ac.ezen.kpj.team.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Index extends Fragment {
    ArrayList<Board_Item> items = new ArrayList<>();
    @BindView(R.id.index_list)
    ListView index_list;
    @BindView(R.id.move_write)
    Button move_write;
    Index_Adapter index_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.activity_index,container,false);
        ButterKnife.bind(this,rootview);


        return rootview;
    }


    @OnClick(R.id.move_write)
    public void move_write(View view){
        Intent intent = new Intent(getContext(),Write.class);
        startActivity(intent);

    }

    @Override
    public void onResume() {
        super.onResume();

        Call<ArrayList<Board_Item>> obser = RetrofitService.getInstance().getRetrofitRequest().getItemList();
        obser.enqueue(new Callback<ArrayList<Board_Item>>() {
            @Override
            public void onResponse(Call<ArrayList<Board_Item>> call, Response<ArrayList<Board_Item>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Board_Item> items = response.body();

                    for (int i = 0 ; i < items.size() ; i++) {
                        Log.d("shb",items.get(i).getTitle());
                    }
                    index_adapter = new Index_Adapter(items,getContext());
                    index_list.setAdapter(index_adapter);
                } else {

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Board_Item>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
