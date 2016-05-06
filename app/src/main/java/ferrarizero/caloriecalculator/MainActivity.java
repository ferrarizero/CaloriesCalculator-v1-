package ferrarizero.caloriecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCalcCalor;
    Button btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcCalor = (Button)findViewById(R.id.btnCalcCalor);
        btnCalcCalor.setOnClickListener(this);
        btnQuit = (Button)findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCalcCalor:
                Intent intent = new Intent(this, CaloricCalculator.class);
                startActivity(intent);
                break;
            case R.id.btnQuit:
                finish();
                System.exit(0);
            default:
                break;
        }
    }
}
