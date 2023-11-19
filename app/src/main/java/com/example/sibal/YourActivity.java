package com.example.sibal;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class YourActivity extends AppCompatActivity {
    private ListView incomeListView, expenseListView;
    private MyAdapter incomeAdapter, expenseAdapter;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        dbHelper = new DBHelper(this);

        // 수입 데이터 조회
        ArrayList<String> incomeDataList = dbHelper.getIncomeData();
        incomeListView = findViewById(R.id.listIncome);
        incomeAdapter = new MyAdapter(this, incomeDataList);
        incomeListView.setAdapter(incomeAdapter);

        // 지출 데이터 조회
        ArrayList<String> expenseDataList = dbHelper.getExpenseData();
        expenseListView = findViewById(R.id.listExpense);
        expenseAdapter = new MyAdapter(this, expenseDataList);
        expenseListView.setAdapter(expenseAdapter);

        // 데이터베이스에서 새로운 데이터를 가져와 어댑터 업데이트
        updateAdapters();
    }

    // 데이터베이스에서 새로운 데이터를 가져와 어댑터 업데이트하는 메서드 추가
//    private void updateAdapters() {
//        // 예를 들어, 데이터베이스에서 새로운 수입 데이터를 가져옴
//        ArrayList<String> newIncomeData = dbHelper.getIncomeData();
//
//        // 어댑터에 데이터 업데이트
//        incomeAdapter.updateData(newIncomeData);
//
//        // 마찬가지로 지출 데이터도 업데이트 가능
//        ArrayList<String> newExpenseData = dbHelper.getExpenseData();
//        expenseAdapter.updateData(newExpenseData);
//    }
//}

    protected void updateAdapters() {
        // 원하는 작업 수행
        // 예: 데이터베이스에서 새로운 데이터를 조회하고 어댑터를 업데이트하는 등의 작업

        // 수입 데이터 업데이트
        ArrayList<String> newIncomeData = dbHelper.getIncomeData();
        incomeAdapter.clear();
        incomeAdapter.addAll(newIncomeData);
        incomeAdapter.notifyDataSetChanged();

        // 지출 데이터 업데이트
        ArrayList<String> newExpenseData = dbHelper.getExpenseData();
        expenseAdapter.clear();
        expenseAdapter.addAll(newExpenseData);
        expenseAdapter.notifyDataSetChanged();
    }
}

