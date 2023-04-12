package Un4N.unitconverterandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.apptakk.http_request.HttpRequest;
import com.apptakk.http_request.HttpRequestTask;
import com.apptakk.http_request.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import androidx.appcompat.app.AppCompatActivity;

public class BankLocatorActivity extends AppCompatActivity {

    private EditText searchBox;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_activity);

        searchBox = findViewById(R.id.searchBox);
        searchButton = findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = searchBox.getText().toString();
                Toast.makeText(BankLocatorActivity.this, "Searching for banks near " + searchText, Toast.LENGTH_SHORT).show();
                new HttpRequestTask(
                        new HttpRequest("https://pfabankapi.app.cloud.gov/api/locations?filters=ZIP:\\\""+searchText+"\\\"", HttpRequest.GET),
                        new HttpRequest.Handler() {
                            @Override
                            public void response(HttpResponse response) {
                                if (response.code == 200) {

                                    JSONObject mainObject = null;
                                    try {
                                        mainObject = new JSONObject(response.body.toString());
                                        JSONArray res = mainObject.getJSONArray("data");
                                        JSONObject  data1 = res.getJSONObject(0);
                                        JSONObject dataBank1 = data1.getJSONObject("data");
                                        String bankName1 = dataBank1.getString("NAME");
                                        String address1 = dataBank1.getString("ADDRESS");
                                        TextView textbank1 = (TextView)findViewById(R.id.bank1);
                                        textbank1.setText(bankName1);
                                        TextView textaddress1 = (TextView)findViewById(R.id.address1);
                                        textaddress1.setText(address1);
                                        JSONObject  data2 = res.getJSONObject(1);
                                        JSONObject dataBank2 = data2.getJSONObject("data");
                                        String bankName2 = dataBank2.getString("NAME");
                                        String address2 = dataBank2.getString("ADDRESS");
                                        TextView textbank2 = (TextView)findViewById(R.id.bank2);
                                        textbank2.setText(bankName2);
                                        TextView textaddress2 = (TextView)findViewById(R.id.address2);
                                        textaddress2.setText(address2);

                                        JSONObject  data3 = res.getJSONObject(2);
                                        JSONObject dataBank3 = data3.getJSONObject("data");
                                        String bankName3 = dataBank3.getString("NAME");
                                        String address3 = dataBank3.getString("ADDRESS");
                                        TextView textbank3 = (TextView)findViewById(R.id.bank3);
                                        textbank3.setText(bankName3);
                                        TextView textaddress3 = (TextView)findViewById(R.id.address3);
                                        textaddress3.setText(address3);
                                        Log.d(this.getClass().toString(), "Request successful!" + bankName1 + address1);
                                    } catch (JSONException e) {
                                        throw new RuntimeException(e);
                                    }


                                } else {
                                    Log.e(this.getClass().toString(), "Request unsuccessful: " + response);
                                }
                            }
                        }).execute();
            }
        });
    }
}



