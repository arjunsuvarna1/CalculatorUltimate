package Un4N.unitconverterandroid;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.widget.Button;
import android.widget.TextView;

import com.apptakk.http_request.HttpRequest;
import com.apptakk.http_request.HttpRequestTask;
import com.apptakk.http_request.HttpResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CurrencyActivity extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener
{

    private Double usd;
    private Double usdRate;
    private Double inr;

    private Double inrRate;
    private Double eur;
    private Double eurRate;
    private Double gbp;
    private Double gbpRate;

    private TextInputEditText usdText;
    private TextInputEditText inrText;
    private TextInputEditText eurText;
    private TextInputEditText gbpText;
    private Button usdButton;
    private Button inrButton;
    private Button eurButton;
    private Button gbpButton;
    private Button resetButton;
    private TextView status;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        new HttpRequestTask(
                new HttpRequest("https://api.exchangerate.host/latest?base=USD", HttpRequest.GET),
                new HttpRequest.Handler() {
                    @Override
                    public void response(HttpResponse response) {
                        if (response.code == 200) {

                            JSONObject mainObject = null;
                            try {
                                mainObject = new JSONObject(response.body.toString());
                                JSONObject rates = mainObject.getJSONObject("rates");
                                String  usdrate = rates.getString("USD");
                                usdRate= Double.parseDouble(usdrate);
                                inrRate = Double.parseDouble(rates.getString("INR"));
                                eurRate = Double.parseDouble(rates.getString("EUR"));
                                gbpRate = Double.parseDouble(rates.getString("GBP"));
                                Log.d(this.getClass().toString(), "Request successful!");
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }


                        } else {
                            Log.e(this.getClass().toString(), "Request unsuccessful: " + response);
                        }
                    }
                }).execute();




        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_currency);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        usdText = (TextInputEditText) findViewById(R.id.usd_box);
        inrText = (TextInputEditText) findViewById(R.id. inr_box);
        eurText = (TextInputEditText) findViewById(R.id.eur_box);
        gbpText = (TextInputEditText) findViewById(R.id.gbp_box);

        usdButton = (Button) findViewById(R.id.usd_button);
        inrButton = (Button) findViewById(R.id.inr_button);
        eurButton = (Button) findViewById(R.id.eur_button);
        gbpButton = (Button) findViewById(R.id.gbp_button);

        resetButton = (Button) findViewById(R.id.reset);
        status = (TextView) findViewById(R.id.status);

        usdButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                usdConversion();
            }
        });

        inrButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                inrConversion();
            }
        });

        eurButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                eurConversion();
            }
        });

        gbpButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                gbpConversion();
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
        usdText.setText("");
        inrText.setText("");
        eurText.setText("");
        gbpText.setText("");
        status.setText("Status : OK");
    }

    private void usdConversion()
    {
        try
        {
            
            usd = Double.parseDouble(usdText.getText().toString());
            eur = usd * eurRate;
            inr = usd * inrRate;
            gbp = usd * gbpRate;
            eurText.setText(String.format("%.2f", eur));
            inrText.setText(String.format("%.2f", inr));
            gbpText.setText(String.format("%.2f", gbp));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : Try again. Error -> NumberFormatException -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void inrConversion()
    {
        try
        {
            inr = Double.parseDouble(inrText.getText().toString());
            usd = inr / inrRate;
            eur = usd * eurRate;
            gbp = usd * gbpRate;
            eurText.setText(String.format("%.2f", eur));
            usdText.setText(String.format("%.2f", usd));
            gbpText.setText(String.format("%.2f", gbp));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : Try again. Error -> NumberFormatException -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void eurConversion()
    {
        try
        {
            eur = Double.parseDouble(eurText.getText().toString());
            usd = eur / eurRate;
            inr = usd * inrRate;
            gbp = usd * gbpRate;
            usdText.setText(String.format("%.2f", usd));
            inrText.setText(String.format("%.2f", inr));
            gbpText.setText(String.format("%.2f", gbp));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : Try again. Error -> NumberFormatException -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void gbpConversion()
    {
        try
        {
            gbp = Double.parseDouble(gbpText.getText().toString());
            usd = gbp / gbpRate;
            eur = usd * eurRate;
            inr = usd * inrRate;

            eurText.setText(String.format("%.2f", eur));
            inrText.setText(String.format("%.2f", inr));
            usdText.setText(String.format("%.2f", usd));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : Try again. Error -> NumberFormatException -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

//    @Override
//    public boolean onNavigationItemSelected(MenuItem item)
//    {
//        int id = item.getItemId();
//
//        if (id == R.id.nav_main)
//        {
//            Intent intent = new Intent(this, TemperatureActivity.class);
//            startActivity(intent);
//        }
//        else if (id == R.id.nav_length)
//        {
//            Intent intent = new Intent(this, LengthActivity.class);
//            startActivity(intent);
//        }
//        else if (id == R.id.nav_number)
//        {
//            Intent intent = new Intent(this, NumberActivity.class);
//            startActivity(intent);
//        }
//        else if (id == R.id.nav_volume)
//        {
//            Intent intent = new Intent(this, VolumeActivity.class);
//            startActivity(intent);
//        }
//        else if (id == R.id.nav_area)
//        {
//            Intent intent = new Intent(this, AreaActivity.class);
//            startActivity(intent);
//        }
//        else if (id == R.id.nav_currency)
//        {
//            Intent intent = new Intent(this, CurrencyActivity.class);
//            startActivity(intent);
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
}
