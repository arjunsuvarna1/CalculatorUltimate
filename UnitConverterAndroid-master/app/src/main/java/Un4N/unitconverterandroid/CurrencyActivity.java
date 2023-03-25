package Un4N.unitconverterandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CurrencyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    private Double usd;
    private Double inr;
    private Double eur;
    private Double gbp;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
            eur = usd * 0.94;
            inr = usd * 82.54;
            gbp = usd * 0.82;
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
            usd = inr / 82.54;
            eur = usd * 0.94;
            gbp = usd * 0.82;
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
            usd = eur / 0.94;
            inr = usd * 82.54;
            gbp = usd * 0.82;
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
            usd = gbp / 0.82;
            eur = usd * 0.94;
            inr = usd * 82.54;

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

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.nav_main)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_length)
        {
            Intent intent = new Intent(this, LengthActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_number)
        {
            Intent intent = new Intent(this, NumberActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_volume)
        {
            Intent intent = new Intent(this, VolumeActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_area)
        {
            Intent intent = new Intent(this, AreaActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_currency)
        {
            Intent intent = new Intent(this, CurrencyActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
