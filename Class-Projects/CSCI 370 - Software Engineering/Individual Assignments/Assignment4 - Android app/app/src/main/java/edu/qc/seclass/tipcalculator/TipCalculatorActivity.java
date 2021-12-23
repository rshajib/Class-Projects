package edu.qc.seclass.tipcalculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.qc.seclass.tipcalculator.databinding.ActivityTipCalculatorBinding;

public class TipCalculatorActivity extends AppCompatActivity {

    ActivityTipCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_tip_calculator);
        setUpListener();
    }

    private void setUpListener() {
        binding.buttonCompute.setOnClickListener(view -> {
            if (TextUtils.isEmpty(binding.checkAmountValue.getText().toString())){
                Toast.makeText(this, "Check amount field can not be empty!", Toast.LENGTH_SHORT).show();
            }else if (TextUtils.isEmpty(binding.partySizeValue.getText().toString())){
                Toast.makeText(this, "Party size field can not be empty!", Toast.LENGTH_SHORT).show();
            }else {
               int checkAmount=Integer.parseInt(binding.checkAmountValue.getText().toString().trim());
               int partySize=Integer.parseInt(binding.partySizeValue.getText().toString().trim());

              int tipForFifteen= CalculationForTip(checkAmount,partySize,15);
              int tipForTwenty= CalculationForTip(checkAmount,partySize,20);
              int tipForTwentyFive= CalculationForTip(checkAmount,partySize,25);

              binding.fifteenPercentTipValue.setText(String.valueOf(tipForFifteen));
              binding.twentyPercentTipValue.setText(String.valueOf(tipForTwenty));
              binding.twentyfivePercentTipValue.setText(String.valueOf(tipForTwentyFive));


              int totalValueForFifteen= CalculateTotalValue(checkAmount,partySize,tipForFifteen);
              int totalValueForTwenty= CalculateTotalValue(checkAmount,partySize,tipForTwenty);
              int totalValueForTwentyFive= CalculateTotalValue(checkAmount,partySize,tipForTwentyFive);


              binding.fifteenPercentTotalValue.setText(String.valueOf(totalValueForFifteen));
              binding.twentyPercentTotalValue.setText(String.valueOf(totalValueForTwenty));
              binding.twentyfivePercentTotalValue.setText(String.valueOf(totalValueForTwentyFive));
            }
        });
    }

    private int CalculateTotalValue(int checkAmount, int partySize, int tip) {

        double initialValue= (double) ( ((double)checkAmount) / ((double)partySize));
        int finalTotal=(int)Math.round(initialValue);
        return finalTotal+tip;
    }

    private int CalculationForTip(int checkAmount, int partySize, int percent) {

        int initialAmount=checkAmount*percent;
        int secondInitialAmount=partySize*100;
        double finalTipCalculation= (double) ( ((double)initialAmount) / ((double)secondInitialAmount));
        return (int) Math.round(finalTipCalculation);
    }
}