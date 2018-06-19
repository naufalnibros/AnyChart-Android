package com.anychart.sample.charts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.ChartsMekko;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.Mapping;
import com.anychart.anychart.Orientation;
import com.anychart.anychart.Set;
import com.anychart.anychart.TooltipDisplayMode;
import com.anychart.anychart.ValueDataEntry;
import com.anychart.sample.R;

import java.util.ArrayList;
import java.util.List;

public class MosaicChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_common);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));

        ChartsMekko mosaic = AnyChart.mosaic();

        mosaic.setTitle("Skills and Self-ID Top Factors");

        List<DataEntry> data = new ArrayList<>();
        data.add(new CustomDataEntry("Data Businessperson", 50, 15, 10, 5, 25));
        data.add(new CustomDataEntry("Data Creative", 17, 23, 10, 20, 30));
        data.add(new CustomDataEntry("Data Developer", 17, 25, 16, 27, 15));
        data.add(new CustomDataEntry("Data Researcher", 12, 12, 17, 5, 51));

        Set set = new Set(data);
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Data = set.mapAs("{ x: 'x', value: 'value3' }");
        Mapping series4Data = set.mapAs("{ x: 'x', value: 'value4' }");
        Mapping series5Data = set.mapAs("{ x: 'x', value: 'value5' }");

        mosaic.mekko(series1Data)
                .setName("Business");

        mosaic.mekko(series2Data)
                .setName("ML/Big Data");

        mosaic.mekko(series3Data)
                .setName("Math/OR");

        mosaic.mekko(series4Data)
                .setName("Programming");

        mosaic.mekko(series5Data)
                .setName("Statistics");

        mosaic.getXAxis().setOrientation(Orientation.TOP);
        mosaic.getTooltip().setDisplayMode(TooltipDisplayMode.UNION);

        anyChartView.setChart(mosaic);
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4, Number value5) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
            setValue("value5", value5);
        }
    }
}
