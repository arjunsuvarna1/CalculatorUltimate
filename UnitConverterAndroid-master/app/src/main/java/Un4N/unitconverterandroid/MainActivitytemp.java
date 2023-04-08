package Un4N.unitconverterandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivitytemp extends AppCompatActivity
{

    private Button UnitConverterButton;
    private Button CurrencyConverterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        UnitConverterButton = (Button) findViewById(R.id.unitConverter_button);
        CurrencyConverterButton = (Button) findViewById(R.id.currencyConverter_button);

        UnitConverterButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivitytemp.this, TemperatureActivity.class);
                startActivity(intent);
            }
        });
        CurrencyConverterButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivitytemp.this, CurrencyActivity.class);
                startActivity(intent);
            }
        });

    }
}
