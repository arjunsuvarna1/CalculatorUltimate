package Un4N.unitconverterandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class LengthActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    private double meters;
    private double kilometers;
    private double feet;
    private double miles;
    private double inches;
    private double yard;

    private TextInputEditText metersBox;
    private TextInputEditText kilometersBox;
    private TextInputEditText feetBox;
    private TextInputEditText milesBox;
    private TextInputEditText inchesBox;
    private TextInputEditText yardBox;
    private Button metersButton;
    private Button kilometersButton;
    private Button feetButton;
    private Button milesButton;
    private Button inchesButton;
    private Button yardButton;
    private Button resetButton;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        metersBox = (TextInputEditText) findViewById(R.id.meters_box);
        kilometersBox = (TextInputEditText) findViewById(R.id.kilometers_box);
        feetBox = (TextInputEditText) findViewById(R.id.feet_box);
        milesBox = (TextInputEditText) findViewById(R.id.miles_box);
        inchesBox = (TextInputEditText) findViewById(R.id.inches_box);
        yardBox = (TextInputEditText) findViewById(R.id.yard_box);

        metersButton = (Button) findViewById(R.id.meters_button);
        kilometersButton = (Button) findViewById(R.id.kilometers_button);
        feetButton = (Button) findViewById(R.id.feet_button);
        milesButton = (Button) findViewById(R.id.miles_button);
        inchesButton = (Button) findViewById(R.id.inches_button);
        yardButton = (Button) findViewById(R.id.yard_button);
        resetButton = (Button) findViewById(R.id.reset);
        status = (TextView) findViewById(R.id.status);

        metersButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                metersConversion();
            }
        });

        kilometersButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                kilometersConversion();
            }
        });

        feetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                feetConversion();
            }
        });

        milesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                milesConversion();
            }
        });

        inchesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                inchesConversion();
            }
        });

        yardButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                yardConversion();
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

//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
    }

    private void reset()
    {
        metersBox.setText(" ");
        kilometersBox.setText(" ");
        feetBox.setText(" ");
        milesBox.setText(" ");
        inchesBox.setText(" ");
        yardBox.setText(" ");
        status.setText("Status : OK");
    }

    private void metersConversion()
    {
        try
        {
            meters = Double.parseDouble(metersBox.getText().toString());
            kilometers = meters / 1000;
            feet = meters / 0.3048;
            miles = meters / 1609.344;
            inches = meters * 39.37;
            yard = meters * 1.094;
            kilometersBox.setText(String.valueOf(kilometers));
            feetBox.setText(String.valueOf(feet));
            milesBox.setText(String.valueOf(miles));
            inchesBox.setText(String.valueOf(inches));
            yardBox.setText(String.valueOf(yard));
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

    private void kilometersConversion()
    {
        try
        {
            kilometers = Double.parseDouble(kilometersBox.getText().toString());
            meters = kilometers * 1000;
            feet = kilometers / 0.0003048;
            miles = kilometers / 1.609344;
            inches = meters * 39.37;
            yard = meters * 1.094;
            inchesBox.setText(String.valueOf(inches));
            yardBox.setText(String.valueOf(yard));
            metersBox.setText(String.valueOf(meters));
            feetBox.setText(String.valueOf(feet));
            milesBox.setText(String.valueOf(miles));

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

    private void feetConversion()
    {
        try
        {
            feet = Double.parseDouble(feetBox.getText().toString());
            meters = feet * 0.3048;
            kilometers = feet * 0.0003048;
            miles = feet * 0.000189393939;
            inches = meters * 39.37;
            yard = meters * 1.094;
            inchesBox.setText(String.valueOf(inches));
            yardBox.setText(String.valueOf(yard));
            metersBox.setText(String.valueOf(meters));
            kilometersBox.setText(String.valueOf(kilometers));
            milesBox.setText(String.valueOf(miles));
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

    private void milesConversion()
    {
        try
        {
            miles = Double.parseDouble(milesBox.getText().toString());
            meters = miles * 1609.344;
            feet = miles / 0.000189393939;
            kilometers = miles * 1.609344;
            inches = meters * 39.37;
            yard = meters * 1.094;
            inchesBox.setText(String.valueOf(inches));
            yardBox.setText(String.valueOf(yard));
            metersBox.setText(String.valueOf(meters));
            feetBox.setText(String.valueOf(feet));
            kilometersBox.setText(String.valueOf(kilometers));
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

    private void inchesConversion()
    {
        try
        {
            inches = Double.parseDouble(inchesBox.getText().toString());
            meters = inches / 39.37;
            kilometers = meters / 1000;
            feet = meters / 0.3048;
            miles = meters / 1609.344;
            yard = meters * 1.094;
            milesBox.setText(String.valueOf(miles));
            inchesBox.setText(String.valueOf(inches));
            yardBox.setText(String.valueOf(yard));
            metersBox.setText(String.valueOf(meters));
            feetBox.setText(String.valueOf(feet));
            kilometersBox.setText(String.valueOf(kilometers));
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

    private void yardConversion()
    {
        try
        {
            yard = Double.parseDouble(milesBox.getText().toString());
            meters = yard / 1.094;
            kilometers = meters / 1000;
            feet = meters / 0.3048;
            miles = meters / 1609.344;
            inches = meters * 39.37;
            milesBox.setText(String.valueOf(miles));
            metersBox.setText(String.valueOf(meters));
            feetBox.setText(String.valueOf(feet));
            kilometersBox.setText(String.valueOf(kilometers));
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
