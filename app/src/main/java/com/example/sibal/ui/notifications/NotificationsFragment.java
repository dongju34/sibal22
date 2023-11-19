package com.example.sibal.ui.notifications;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.sibal.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    PieChart pieChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        pieChart = view.findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        // 차트의 시각적으로 보이는 부분들.
        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(34f, "한식"));
        yValues.add(new PieEntry(23f, "중식"));
        yValues.add(new PieEntry(14f, "일식"));
        yValues.add(new PieEntry(35f, "양식"));
        yValues.add(new PieEntry(40f, "동남아"));
        yValues.add(new PieEntry(40f, "기타"));

        // 아래에 라벨 추가하는 기능
        Description description = new Description();
        description.setText("세계 요리"); // 라벨
        description.setTextSize(15);
        pieChart.setDescription(description);

        // 실행 시 애니메이션이 뜨게 하는 코드
        pieChart.animateY(1000, Easing.EaseInOutCubic); // 애니메이션

        // 아래에 구성 요소가 뭐가 있는지 뜨게하는 코드
        PieDataSet dataSet = new PieDataSet(yValues, "음식 종류");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);
    }
}
