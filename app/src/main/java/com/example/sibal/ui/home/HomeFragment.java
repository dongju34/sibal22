package com.example.sibal.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sibal.DBHelper;
import com.example.sibal.MyAdapter;

import com.example.sibal.R;
import com.example.sibal.databinding.FragmentHomeBinding;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private MyAdapter incomeAdapter; // 추가: 수입 어댑터
    private MyAdapter expenseAdapter; // 추가: 지출 어댑터
    private ArrayList<String> incomeData; // 추가: 수입 데이터
    private ArrayList<String> expenseData; // 추가: 지출 데이터
    private ListView incomeListView; // 추가: 수입 리스트뷰
    private ListView expenseListView; // 추가: 지출 리스트뷰
    private FragmentHomeBinding binding;
    private DBHelper dbHelper; // DBHelper 객체 추가
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // DBHelper 객체 초기화
        dbHelper = new DBHelper(requireContext());

        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        // 다음 라인을 주석 처리하거나 삭제하여 textHome을 사용하지 않음을 나타냅니다.
        // binding.textHome.setVisibility(View.GONE);

        // 데이터베이스에서 수입 데이터 및 지출 데이터 가져오기
        ArrayList<String> incomeData = dbHelper.getIncomeData();
        ArrayList<String> expenseData = dbHelper.getExpenseData();

        // 수입 데이터 어댑터 설정
        incomeAdapter = new MyAdapter(requireContext(), incomeData);
        incomeListView = root.findViewById(R.id.listIncome);
        incomeListView.setAdapter(incomeAdapter);

//        // 지출 데이터 어댑터 설정
//        expenseAdapter = new MyAdapter(requireContext(), expenseData);
//        expenseListView = root.findViewById(R.id.listExpense);
//        expenseListView.setAdapter(expenseAdapter);

        // 예제: ViewModel에서 가져온 데이터를 사용하는 방법
        homeViewModel.getText().observe(getViewLifecycleOwner(), text -> {
            // 여기에서 가져온 데이터를 사용하는 코드를 추가하세요.
            // 예를 들어, 가져온 데이터를 로그에 출력하는 코드
            Log.d("HomeFragment", "Received text from ViewModel: " + text);
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
