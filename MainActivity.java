package coms.example.lenovo.mydemoapplication;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.view.ColumnChartView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Set<RequestListener> requestListeners = new HashSet<>();
        requestListeners.add(new RequestLoggingListener());
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                // other setters
                .setRequestListeners(requestListeners)
                .build();
        Fresco.initialize(this, config);
        FLog.setMinimumLoggingLevel(FLog.VERBOSE);
//初始化必须在不见初始化前，否则报错

        setContentView(R.layout.activity_main);
      //Fresco.initialize(this);



        Uri uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499945001074&di=94812c6ec9b9d36a8ec024cad6d29c41&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201411%2F08%2F20141108201327_sCxZX.jpeg");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);


        List<SubcolumnValue> values = new ArrayList<SubcolumnValue>();
        SubcolumnValue subcolumnValue = new SubcolumnValue();

        values.add(subcolumnValue);  subcolumnValue.setValue(100.0f) ;
        values.add(new SubcolumnValue(100, Color.RED));
        values.add(new SubcolumnValue(10,  Color.BLUE));
        values.add(new SubcolumnValue(200,  Color.BLUE));
        values.add(new SubcolumnValue(30,  Color.BLUE));
//In most cased you can call data model methods in builder-pattern-like manner.
     //   Column line = new Column(values).setColor(Color.RED).setCubic(true);

        Column line = new Column();


        //测试
        line.setValues(values);
        List<Column> lines = new ArrayList<Column>();
        lines.add(line);
        ColumnChartData data = new ColumnChartData();
        data.setColumns(lines);
        ColumnChartView chart =(ColumnChartView)super.findViewById(R.id.chart);
        chart.setColumnChartData(data);
    }
}
