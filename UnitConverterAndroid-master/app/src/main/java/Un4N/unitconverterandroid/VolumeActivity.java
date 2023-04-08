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

public class VolumeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    private Double tsp;
    private Double tbsp;
    private Double ml;
    private Double l;
    private Double cup;

    private TextInputEditText tspBox;
    private TextInputEditText tbspBox;
    private TextInputEditText mlBox;
    private TextInputEditText lBox;
    private TextInputEditText cupBox;
    private Button tspButton;
    private Button tbspButton;
    private Button mlButton;
    private Button lButton;
    private Button cupButton;
    private Button resetButton;
    private TextView status;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tspBox = (TextInputEditText) findViewById(R.id.tsp_box);
        tbspBox = (TextInputEditText) findViewById(R.id. tbsp_box);
        mlBox = (TextInputEditText) findViewById(R.id.ml_box);
        lBox = (TextInputEditText) findViewById(R.id.l_box);
        cupBox = (TextInputEditText) findViewById(R.id.cup_box);

        tspButton = (Button) findViewById(R.id.tsp_button);
        tbspButton = (Button) findViewById(R.id.tbsp_button);
        mlButton = (Button) findViewById(R.id.ml_button);
        lButton = (Button) findViewById(R.id.l_button);
        cupButton = (Button) findViewById(R.id.cup_button);

        resetButton = (Button) findViewById(R.id.reset);
        status = (TextView) findViewById(R.id.status);

        tspButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tspConversion();
            }
        });

        tbspButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tbspConversion();
            }
        });

        mlButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mlConversion();
            }
        });

        lButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                lConversion();
            }
        });

        cupButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cupConversion();
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
        tspBox.setText("");
        tbspBox.setText("");
        mlBox.setText("");
        lBox.setText("");
        cupBox.setText("");
        status.setText("Status : OK");
    }

    private void tspConversion()
    {
        try
        {
            tsp = Double.parseDouble(tspBox.getText().toString());
            ml = tsp * 4.929892;
            tbsp = tsp / 3;
            l = tsp / 202.9;
            cup = tsp / 48.692;
            mlBox.setText(String.valueOf(ml));
            tbspBox.setText(String.valueOf(tbsp));
            lBox.setText(String.valueOf(l));
            cupBox.setText(String.valueOf(cup));
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

    private void tbspConversion()
    {
        try
        {
            tbsp = Double.parseDouble(tbspBox.getText().toString());
            tsp = tbsp * 3;
            ml = tsp * 4.929892;
            l = tsp / 202.9;
            cup = tsp / 48.692;
            mlBox.setText(String.valueOf(ml));
            tspBox.setText(String.valueOf(tsp));
            lBox.setText(String.valueOf(l));
            cupBox.setText(String.valueOf(cup));
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

    private void mlConversion()
    {
        try
        {
            ml = Double.parseDouble(mlBox.getText().toString());
            tsp = ml / 4.929892;
            tbsp = tsp / 3;
            l = tsp / 202.9;
            cup = tsp / 48.692;
            tspBox.setText(String.valueOf(tsp));
            tbspBox.setText(String.valueOf(tbsp));
            lBox.setText(String.valueOf(l));
            cupBox.setText(String.valueOf(cup));
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

    private void lConversion()
    {
        try
        {
            l = Double.parseDouble(lBox.getText().toString());
            tsp = l * 202.9;
            ml = tsp * 4.929892;
            tbsp = tsp / 3;
            cup = tsp / 48.692;
            mlBox.setText(String.valueOf(ml));
            tbspBox.setText(String.valueOf(tbsp));
            tspBox.setText(String.valueOf(tsp));
            cupBox.setText(String.valueOf(cup));
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

    private void cupConversion()
    {
        try
        {
            cup = Double.parseDouble(cupBox.getText().toString());
            tsp = cup * 48.692;
            ml = tsp * 4.929892;
            tbsp = tsp / 3;
            l = tsp / 202.9;
            mlBox.setText(String.valueOf(ml));
            tbspBox.setText(String.valueOf(tbsp));
            lBox.setText(String.valueOf(l));
            tspBox.setText(String.valueOf(tsp));
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
