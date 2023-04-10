package Un4N.unitconverterandroid;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apptakk.http_request.HttpRequest;
import com.apptakk.http_request.HttpRequestTask;
import com.apptakk.http_request.HttpResponse;


import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TrendsActivity  extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener
{

    private TextInputEditText fromText;
    private TextInputEditText toText;

    private String from;
    private String to;
    private Button showButton;
    private Button resetButton;

    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_trends);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
//                (this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        fromText = (TextInputEditText) findViewById(R.id.from_box);
        toText = (TextInputEditText) findViewById(R.id.to_box);
        showButton = (Button) findViewById(R.id.show_button);
        resetButton = (Button) findViewById(R.id.reset);
        status = (TextView) findViewById(R.id.status);
        /*
        fahrenheitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fahrenheitConversion();
            }
        });

        celsiusButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                celsiusConversion();
            }
        });
        */
        showButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    currencyTrends();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                reset();
            }
        });
    }


    private void reset()
    {
        fromText.setText(" ");
        toText.setText(" ");
        status.setText("Status : OK");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void currencyTrends(){
        from = fromText.getText().toString();
        to = toText.getText().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //System.out.println(LocalDate.now().format(formatter));
        Log.d(this.getClass().toString(), "Date" +LocalDate.now().minusYears(3).format(formatter));

        new HttpRequestTask(
                new HttpRequest("https://api.exchangerate.host/fluctuation?base="+from+"&start_date="+LocalDate.now().minusYears(1).format(formatter)+"&end_date="+LocalDate.now().format(formatter), HttpRequest.GET),
                new HttpRequest.Handler() {
                    @Override
                    public void response(HttpResponse response) {
                        if (response.code == 200) {

                            JSONObject mainObject = null;
                            try {
                                mainObject = new JSONObject(response.body.toString());
                                JSONObject rates = mainObject.getJSONObject("rates");
                                JSONObject  toRate = rates.getJSONObject(to.toUpperCase());
                                 String start = toRate.getString("start_rate");
                                 String end = toRate.getString("end_rate");
                                BarChart mBarChart = (BarChart) findViewById(R.id.barchart);

                                mBarChart.addBar(new BarModel(Float.parseFloat(start), 0xFF123456));
                                mBarChart.addBar(new BarModel(Float.parseFloat(end),  0xFF343456));


                                mBarChart.startAnimation();
                                Log.d(this.getClass().toString(), "Request successful!" + start + end);
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }


                        } else {
                            Log.e(this.getClass().toString(), "Request unsuccessful: " + response);
                        }
                    }
                }).execute();


    }


//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        return false;
//    }
}
