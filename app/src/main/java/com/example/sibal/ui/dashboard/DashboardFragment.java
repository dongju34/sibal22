package com.example.sibal.ui.dashboard;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.sibal.Input;
import com.example.sibal.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DashboardFragment extends Fragment {

    private TextView textDay;
    private ImageButton btnLeft;
    private ImageButton btnRight;
    private Button button;

    private TextView amount, card, classification;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // +버튼을 누르면 input 액티비티로 이동
        button = root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Input.class);
                startActivity(intent);
            }
        });

//        card = root.findViewById(R.id.asset);
//        classification = root.findViewById(R.id.classification);
//        amount = root.findViewById(R.id.amount);
//
        Intent intent = getActivity().getIntent();
//        String cardstr = intent.getStringExtra("card");
//        String classificationstr = intent.getStringExtra("classification");
//        String amountstr = intent.getStringExtra("str");
//
        String selectedDateFromInput = intent.getStringExtra("selectedDateFromInput");
//
//        card.setText(cardstr);
//        classification.setText(classificationstr);
//        amount.setText(amountstr);

        textDay = root.findViewById(R.id.text_day);

        if (selectedDateFromInput != null) {
            // Input 액티비티에서 전달받은 날짜를 textDay에 설정
            textDay.setText(selectedDateFromInput);
        }


        // text_day TextView의 클릭 리스너 설정
        textDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        return root;
    }

    // DatePickerDialog를 보여주는 메서드
    private void showDatePickerDialog() {
        // 현재 날짜 가져오기
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // DatePickerDialog 생성 및 리스너 설정
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // 선택된 날짜 처리
                        String selectedDate = year + "." + (month + 1) + "." + dayOfMonth;
                        updateTextView(selectedDate);
                    }
                },
                year, month, day);

        // 다이얼로그 표시
        datePickerDialog.show();
    }


    // TextView 업데이트 메서드
    private void updateTextView(String date) {
        textDay.setText(date);
    }
}
