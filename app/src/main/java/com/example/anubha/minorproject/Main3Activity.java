package com.example.anubha.minorproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Main3Activity extends AppCompatActivity {
    private final Handler mHandler = new Handler();
    private Runnable mTimer2;

    private LineGraphSeries<DataPoint> seriesLsa;
    private LineGraphSeries<DataPoint> seriesKLSum;
    private LineGraphSeries<DataPoint> seriesTextRank;
    private LineGraphSeries<DataPoint> seriesLexRank;
    private LineGraphSeries<DataPoint> seriesLuhn;
    private int i=-1;
    DataPoint[] dLsa;
    DataPoint[] dKLSum;
    DataPoint[] dTextRank;
    DataPoint[] dLexRank;
    DataPoint[] dLuhn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //ImageView iv=findViewById(R.id.)
        // we get graph view instance
        TextView tv= (TextView) findViewById(R.id.mainHeading);
        Typeface tf1 = Typeface.createFromAsset(getAssets(),
                "a.otf");
        tv.setTypeface(tf1);
        dLsa=generateDataLsa();
        dKLSum=generateDataKLSum();
        dTextRank=generateDataTextRank();
        dLexRank=generateDataLexRank();
        dLuhn=generateDataLuhn();
        GraphView graph = (GraphView) findViewById(R.id.graph);

        seriesLsa = new LineGraphSeries<>();
        seriesLsa.setColor(Color.CYAN);
        seriesLsa.setThickness(7);
        //seriesLsa.setBackgroundColor(Color.CYAN);
        graph.addSeries(seriesLsa);

        seriesKLSum = new LineGraphSeries<>();
        seriesKLSum.setColor(Color.MAGENTA);
        seriesKLSum.setThickness(7);
        //seriesKLSum.setBackgroundColor(Color.MAGENTA);
        graph.addSeries(seriesKLSum);

        seriesTextRank = new LineGraphSeries<>();
        seriesTextRank.setColor(Color.GREEN);
        seriesTextRank.setThickness(7);
        //seriesKLSum.setBackgroundColor(Color.MAGENTA);
        graph.addSeries(seriesTextRank);

        seriesLexRank = new LineGraphSeries<>();
        seriesLexRank.setColor(Color.YELLOW);
        seriesLexRank.setThickness(7);
        //seriesKLSum.setBackgroundColor(Color.MAGENTA);
        graph.addSeries(seriesLexRank);

        seriesLuhn = new LineGraphSeries<>();
        seriesLuhn.setColor(Color.BLUE);
        seriesLuhn.setThickness(7);
        //seriesKLSum.setBackgroundColor(Color.MAGENTA);
        graph.addSeries(seriesLuhn);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinX(0.0);
        graph.getViewport().setMaxX(4.0);
        graph.getViewport().setMinY(0.0);
        graph.getViewport().setMaxY(0.8);
        graph.getGridLabelRenderer().setHorizontalAxisTitle("cos_val     unit_val      precision_val      recall_val         f_val");
    }

    @Override
    public void onResume() {
        super.onResume();

        mTimer2 = new Runnable() {
            @Override
            public void run() {
                //graph2LastXValue += 1d;

                i+=1;
                if(i<5) {
                    seriesLsa.appendData(new DataPoint(dLsa[i].getX(), dLsa[i].getY()), true, 40);
                    seriesKLSum.appendData(new DataPoint(dKLSum[i].getX(), dKLSum[i].getY()), true, 40);
                    seriesLuhn.appendData(new DataPoint(dLuhn[i].getX(), dLuhn[i].getY()), true, 40);
                    seriesTextRank.appendData(new DataPoint(dTextRank[i].getX(), dTextRank[i].getY()), true, 40);
                    seriesLexRank.appendData(new DataPoint(dLexRank[i].getX(), dLexRank[i].getY()), true, 40);
                }
                mHandler.postDelayed(this, 200);
            }
        };
        mHandler.postDelayed(mTimer2, 1000);
    }

    @Override
    public void onPause() {
        mHandler.removeCallbacks(mTimer2);
        super.onPause();
    }

    private DataPoint[] generateDataLsa() {
        int count = 5;
        DataPoint[] values = new DataPoint[count];
        Double xarr[]={1d,2d,3d,4d,5d};
        Double yarr[]={0.8025d,0.3663d,0.4383d,0.2838d,0.3179d};
        for (int i=0; i<count; i++) {
            double x = xarr[i];
            double y = yarr[i];
            //double y = Math.sin(i*f+2) + mRand.nextDouble()*0.3;
            DataPoint v = new DataPoint(x, y);
            values[i] = v;
        }
        return values;
    }

    private DataPoint[] generateDataKLSum() {
        int count = 5;
        DataPoint[] values = new DataPoint[count];
        Double xarr[]={1d,2d,3d,4d,5d};
        Double yarr[]={0.8015d,0.4369d,0.5641d,0.3590d,0.4042d};
        for (int i=0; i<count; i++) {
            double x = xarr[i];
            double y = yarr[i];
            DataPoint v = new DataPoint(x, y);
            values[i] = v;
        }
        return values;
    }

    private DataPoint[] generateDataTextRank() {
        int count = 5;
        DataPoint[] values = new DataPoint[count];
        Double xarr[]={1d,2d,3d,4d,5d};
        Double yarr[]={0.7898d,0.4113d,0.3974d,0.3371d,0.3026d};
        for (int i=0; i<count; i++) {
            double x = xarr[i];
            double y = yarr[i];
            DataPoint v = new DataPoint(x, y);
            values[i] = v;
        }
        return values;
    }

    private DataPoint[] generateDataLexRank() {
        int count = 5;
        DataPoint[] values = new DataPoint[count];
        Double xarr[]={1d,2d,3d,4d,5d};
        Double yarr[]={0.7402d,0.3435d,0.2650d,0.1971d,0.2081d};
        for (int i=0; i<count; i++) {
            double x = xarr[i];
            double y = yarr[i];
            DataPoint v = new DataPoint(x, y);
            values[i] = v;
        }
        return values;
    }

    private DataPoint[] generateDataLuhn() {
        int count = 5;
        DataPoint[] values = new DataPoint[count];
        Double xarr[]={1d,2d,3d,4d,5d};
        Double yarr[]={0.7642d,0.3687d,0.4516d,0.2904d,0.3297d};
        for (int i=0; i<count; i++) {
            double x = xarr[i];
            double y = yarr[i];
            DataPoint v = new DataPoint(x, y);
            values[i] = v;
        }
        return values;
    }

    public void next(View v) {
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }    }