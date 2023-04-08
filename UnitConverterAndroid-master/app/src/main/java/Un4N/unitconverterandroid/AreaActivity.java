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

public class AreaActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    private Double sqin;
    private Double sqft;
    private Double sqm;
    private Double sqyd;

    private TextInputEditText sqinBox;
    private TextInputEditText sqftBox;
    private TextInputEditText sqmBox;
    private TextInputEditText sqydBox;
    private Button sqinButton;
    private Button sqftButton;
    private Button sqmButton;
    private Button sqydButton;
    private Button resetButton;
    private TextView status;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sqinBox = (TextInputEditText) findViewById(R.id.sqin_box);
        sqftBox = (TextInputEditText) findViewById(R.id. sqft_box);
        sqmBox = (TextInputEditText) findViewById(R.id.sqm_box);
        sqydBox = (TextInputEditText) findViewById(R.id.sqyd_box);

        sqinButton = (Button) findViewById(R.id.sqin_button);
        sqftButton = (Button) findViewById(R.id.sqft_button);
        sqmButton = (Button) findViewById(R.id.sqm_button);
        sqydButton = (Button) findViewById(R.id.sqyd_button);

        resetButton = (Button) findViewById(R.id.reset);
        status = (TextView) findViewById(R.id.status);

        sqinButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sqinConversion();
            }
        });

        sqftButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sqftConversion();
            }
        });

        sqmButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sqmConversion();
            }
        });

        sqydButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sqydConversion();
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
        sqinBox.setText("");
        sqftBox.setText("");
        sqmBox.setText("");
        sqydBox.setText("");
        status.setText("Status : OK");
    }

    private void sqinConversion()
    {
        try
        {
            sqin = Double.parseDouble(sqinBox.getText().toString());
            sqm = sqin / 1550;
            sqft = sqin / 144;
            sqyd = sqin / 1296;
            sqmBox.setText(String.format("%.6f", sqm));
            sqftBox.setText(String.format("%.6f", sqft));
            sqydBox.setText(String.format("%.6f", sqyd));
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

    private void sqftConversion()
    {
        try
        {
            sqft = Double.parseDouble(sqftBox.getText().toString());
            sqin = sqft * 144;
            sqm = sqin / 1550;
            sqyd = sqin / 1296;
            sqmBox.setText(String.format("%.6f", sqm));
            sqinBox.setText(String.format("%.6f", sqin));
            sqydBox.setText(String.format("%.6f", sqyd));
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

    private void sqmConversion()
    {
        try
        {
            sqm = Double.parseDouble(sqmBox.getText().toString());
            sqin = sqm * 1550;
            sqft = sqin / 144;
            sqyd = sqin / 1296;
            sqinBox.setText(String.format("%.6f", sqin));
            sqftBox.setText(String.format("%.6f", sqft));
            sqydBox.setText(String.format("%.6f", sqyd));
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

    private void sqydConversion()
    {
        try
        {
            sqyd = Double.parseDouble(sqydBox.getText().toString());
            sqin = sqyd * 1296;
            sqm = sqin / 1550;
            sqft = sqin / 144;

            sqmBox.setText(String.format("%.6f", sqm));
            sqftBox.setText(String.format("%.6f", sqft));
            sqinBox.setText(String.format("%.6f", sqin));
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
            Intent intent = new Intent(this, TemperatureActivity.class);
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
//        else if (id == R.id.nav_currency)
//        {
//            Intent intent = new Intent(this, CurrencyActivity.class);
//            startActivity(intent);
//        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
