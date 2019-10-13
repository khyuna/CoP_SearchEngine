package com.example.hyuna.cop_searchengine;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ResultViewActivity
 * 결과 리스트들을 리스트형/ 테이블 형으로 보여주는 Activity
 */
public class ResultViewActivity extends AppCompatActivity implements  ResultViewInterface, View.OnClickListener{

    ProgressDialog progressDialog;
    SearchControllerInterface dataControllerInterface;
    RecyclerView rv ;
    RecyclerView gv ;
    String keyword;

    public static int viewType = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLoading(); // 결과값이 나올 때까지 무조건 로딩 돌리기

        final Context context = this;
        setContentView(R.layout.activity_result_view);

        TextView tv_title = findViewById(R.id.title_keyword);

        rv = findViewById(R.id.recyclerView);   //리스트 형
        gv = findViewById(R.id.recyclerView2);  // 테이블 형

        final ScrollView scrollView = findViewById(R.id.recyclerView_scroll);
        final ScrollView scrollView1 = findViewById(R.id.recyclerView2_scroll);

        Bundle bundle = getIntent().getExtras();
        keyword = bundle.getString("keyword"); //키워드 가져오기
        tv_title.setText("keyword = "+keyword);
        scrollView1.setVisibility(View.INVISIBLE);

        dataControllerInterface = new SearchController(this, new ResultList(keyword));

        // onClick
        dataControllerInterface.doSearch(keyword);

        try{
            if(keyword.equals("")){
                showMessageForEmptyMessage("키워드를 입력해주세요.");
            }
        }catch (Exception e){
            Toast.makeText(context, "처리중 오류가 발생했습니다.",Toast.LENGTH_SHORT);
        }
        Button btn_list = findViewById(R.id.btn_listview);
        Button btn_grid = findViewById(R.id.btn_tableview);
        Button btn_back = findViewById(R.id.btn_back);

        //LISTVIEW 선택 버튼
        btn_list.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                //리스트 형 선택
                viewType=0;
                scrollView.setVisibility(View.VISIBLE);
                scrollView1.setVisibility(View.INVISIBLE);
            }
        });

        //TABLEVIEW 선택 버튼
        btn_grid.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewType=1;
                scrollView.setVisibility(View.INVISIBLE);
                scrollView1.setVisibility(View.VISIBLE);
            }
        });

        //BACK 버튼
        btn_back.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                //메인 화면으로 이동함
                Intent intent = new Intent(context, SearchViewActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void drawImage(ArrayList<ImageData> resultList) {


        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(resultList, 0);
        final RecyclerViewAdapter recyclerViewAdapter1 = new RecyclerViewAdapter(resultList, 1);

        rv.setAdapter(recyclerViewAdapter);
        gv.setAdapter(recyclerViewAdapter1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ResultViewActivity.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ResultViewActivity.this, 3);
        gv.setLayoutManager(gridLayoutManager);
        rv.setLayoutManager(linearLayoutManager) ;
        hideLoading();
    }

    @Override
    public void drawView(int idx) {

    }

    @Override
    public void showLoading() {
            //로딩
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        progressDialog = new ProgressDialog(ResultViewActivity.this);
                        progressDialog.setIndeterminate(true);
                        progressDialog.setMessage("로딩 중 ...");
                        progressDialog.show();
                }
        }, 0);

    }

    @Override
    public void hideLoading(){
        new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss(); }
                        }, 0);

    }


    @Override
    public String getKeywordText() {
        Bundle bundle = getIntent().getExtras();
        String keyword = bundle.getString("keyword"); //키워드 가져오기
        return keyword;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_listview :
                //리스트뷰
                viewType=0;
                drawView(0);
                break;

            case R.id.btn_tableview:
                //그리드뷰
                viewType=1;
                drawView(1);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, SearchViewActivity.class);
        intent.putExtra("flag", "removeKeyword");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
    }

    public void showMessageForEmptyMessage(String message){
        //키워드 값이 비었을 경우 toast화면 보여줌
        Toast.makeText(this, message, Toast.LENGTH_SHORT);
        //메인 화면으로 돌아감
        Intent intent = new Intent(this, SearchViewActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
    }
}
