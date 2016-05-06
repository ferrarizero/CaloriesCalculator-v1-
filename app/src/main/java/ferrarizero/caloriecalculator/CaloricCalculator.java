package ferrarizero.caloriecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class CaloricCalculator extends AppCompatActivity implements View.OnClickListener {

    Button btnCalculate;
    Switch swGender, swActivity;
    EditText etAge, etHeight, etWeight;
    int activity, gender;
    TextView tvResult;
    float a, b, c;
    double wynik, wynik1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_calor);

        btnCalculate = (Button)findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);
        tvResult = (TextView)findViewById(R.id.tvResult);
        etAge = (EditText)findViewById(R.id.etAge);
        etHeight = (EditText)findViewById(R.id.etHeight);
        etWeight = (EditText)findViewById(R.id.etWeight);

        swGender = (Switch)findViewById(R.id.swGender);
        swGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    gender = 1;
                } else {
                    gender = 2;
                }
            }
        });

        swActivity = (Switch)findViewById(R.id.swActivity);
        swActivity.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    activity = 1;
                } else {
                    activity = 0;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(TextUtils.isEmpty(etAge.getText().toString()) || TextUtils.isEmpty(etHeight.getText().toString()) || TextUtils.isEmpty(etWeight.getText().toString())){
            Toast.makeText(CaloricCalculator.this, "Error! Fields are empty", Toast.LENGTH_LONG).show();
            return;
        }

        a = Float.parseFloat(etHeight.getText().toString());
        b = Float.parseFloat(etAge.getText().toString());
        c = Float.parseFloat(etWeight.getText().toString());

        switch (v.getId()){
            case R.id.btnCalculate:
                if (gender == 1){
                    wynik = 9.99 * c + 6.25 * a - 4.92 * b - 161;
                } else {
                    wynik = 9.99 * c + 6.25 * a - 4.92 * b + 5;
                }
                if (activity == 0){
                    wynik1 = wynik * 1.375;
                } else {
                    wynik1 = wynik * 1.725;
                }
                String result = String.valueOf(wynik1);
                tvResult.setText(result);
            default:
                break;
        }
    }
}
