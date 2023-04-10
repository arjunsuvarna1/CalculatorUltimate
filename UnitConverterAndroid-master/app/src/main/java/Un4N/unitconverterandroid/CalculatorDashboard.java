package Un4N.unitconverterandroid;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class CalculatorDashboard extends AppCompatActivity {

    CardView basicCardCalculator;
    CardView sciCardCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        basicCardCalculator=findViewById(R.id.cardBasic_Calculator);
        sciCardCalculator=findViewById(R.id.cardScientific_Calculator);

        if(!MainActivity.lighttheme) {
            basicCardCalculator.setCardBackgroundColor(getResources().getColor(R.color.colorBlack));
//            cardDark_Light_txt.setTextColor(getResources().getColor(R.color.white));
        }
        else {
            basicCardCalculator.setCardBackgroundColor(getResources().getColor(R.color.white));
//            cardDark_Light_txt.setTextColor(getResources().getColor(R.color.black));
        }
        
        basicCardCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorDashboard.this, BasicCalculatorActivity.class);
                startActivity(intent);
            }
        });
        sciCardCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorDashboard.this, ScientificCalculatorMainActivity.class);
                startActivity(intent);
            }
        });

    }
}