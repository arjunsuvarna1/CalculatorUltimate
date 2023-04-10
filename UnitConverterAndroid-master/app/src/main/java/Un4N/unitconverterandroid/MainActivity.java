package Un4N.unitconverterandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;


//import com.example.se1_sample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static Boolean lighttheme = true;
    CardView cardDark_Light;
    CardView cardCurreny_Converter;
    CardView cardCalculator;
    CardView cardUnit_Converter;
    CardView cardNearest_Bank_Locator;
    CardView cardCurrency_Trends;

//    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        cardDark_Light=findViewById(R.id.cardDark_Light);
        cardCurreny_Converter=findViewById(R.id.cardCurrency_Converter);
        cardCalculator=findViewById(R.id.cardCalculator);
        cardUnit_Converter=findViewById(R.id.cardUnit_Converter);
        cardNearest_Bank_Locator=findViewById(R.id.cardNearest_Bank_Locator);
        cardCurrency_Trends=findViewById(R.id.cardCurrency_Trends);

        cardCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatorDashboard.class);
                startActivity(intent);
            }
        });


        cardUnit_Converter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, TemperatureActivity.class);
                startActivity(intent);
            }
        });
        cardCurreny_Converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrencyActivity.class);
                startActivity(intent);
            }
        });

        cardCurrency_Trends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TrendsActivity.class);
                startActivity(intent);
            }
        });

        cardDark_Light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cardDark_Light_txt = findViewById(R.id.cardDark_Light_txt);

                lighttheme = !lighttheme;
                if(!lighttheme) {
                    cardDark_Light.setCardBackgroundColor(getResources().getColor(R.color.colorBlack));
                    cardDark_Light_txt.setTextColor(getResources().getColor(R.color.white));
                    cardCalculator.setCardBackgroundColor(getResources().getColor(R.color.colorBlack));
                    cardCurrency_Trends.setCardBackgroundColor(getResources().getColor(R.color.colorBlack));
                    cardCurreny_Converter.setCardBackgroundColor(getResources().getColor(R.color.colorBlack));
                    cardUnit_Converter.setCardBackgroundColor(getResources().getColor(R.color.colorBlack));
                    cardNearest_Bank_Locator.setCardBackgroundColor(getResources().getColor(R.color.colorBlack));
                }
                else {
                    cardDark_Light.setCardBackgroundColor(getResources().getColor(R.color.white));
                    cardDark_Light_txt.setTextColor(getResources().getColor(R.color.black));

                    cardCalculator.setCardBackgroundColor(getResources().getColor(R.color.white));
                    cardCurrency_Trends.setCardBackgroundColor(getResources().getColor(R.color.white));
                    cardCurreny_Converter.setCardBackgroundColor(getResources().getColor(R.color.white));
                    cardUnit_Converter.setCardBackgroundColor(getResources().getColor(R.color.white));
                    cardNearest_Bank_Locator.setCardBackgroundColor(getResources().getColor(R.color.white));
                }
            }
        });
    }
}
