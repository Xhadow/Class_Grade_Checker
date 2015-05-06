package com.cab.xhadow.classgradechecker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    //String for if any error occurs.
    private static String errormsg;
    //floats to determine Final Grades
    private static float Final_Calc_A;
    private static float Final_Calc_B;
    private static float Final_Calc_C;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void clickButton(View v) {
        //Get the inputs for the class percentages
        EditText first_CPerc = (EditText) findViewById(R.id.editText2);
        EditText sec_CPerc = (EditText) findViewById(R.id.editText4);
        EditText third_CPerc = (EditText) findViewById(R.id.editText6);
        EditText four_CPerc = (EditText) findViewById(R.id.editText8);
        EditText fif_CPerc = (EditText) findViewById(R.id.editText10);
        EditText six_CPerc = (EditText) findViewById(R.id.editText12);
        EditText sev_CPerc = (EditText) findViewById(R.id.editText14);
        int first_Cperc_int = Integer.parseInt(first_CPerc.getText().toString());
        int sec_Cperc_int = Integer.parseInt(sec_CPerc.getText().toString());
        int third_Cperc_int = Integer.parseInt(third_CPerc.getText().toString());
        int four_Cperc_int = Integer.parseInt(four_CPerc.getText().toString());
        int fif_Cperc_int = Integer.parseInt(fif_CPerc.getText().toString());
        int six_Cperc_int = Integer.parseInt(six_CPerc.getText().toString());
        int sev_Cperc_int = Integer.parseInt(sev_CPerc.getText().toString());
        if(!(checkPercent(first_Cperc_int, sec_Cperc_int, third_Cperc_int, four_Cperc_int, fif_Cperc_int,
                six_Cperc_int, sev_Cperc_int))) {
            TextView errt = (TextView) findViewById(R.id.textView13);
            errt.setText("Error: Percentage in class is over 100");
        } else {
            //Get the inputs for their percentages
            EditText first_Perc = (EditText) findViewById(R.id.editText);
            EditText sec_Perc = (EditText) findViewById(R.id.editText3);
            EditText third_Perc = (EditText) findViewById(R.id.editText5);
            EditText four_Perc = (EditText) findViewById(R.id.editText7);
            EditText fif_Perc = (EditText) findViewById(R.id.editText9);
            EditText six_Perc = (EditText) findViewById(R.id.editText11);
            EditText sev_Perc = (EditText) findViewById(R.id.editText13);
            int first_perc_int = Integer.parseInt(first_Perc.getText().toString());
            int sec_perc_int = Integer.parseInt(sec_Perc.getText().toString());
            int third_perc_int = Integer.parseInt(third_Perc.getText().toString());
            int four_perc_int = Integer.parseInt(four_Perc.getText().toString());
            int fif_perc_int = Integer.parseInt(fif_Perc.getText().toString());
            int six_perc_int = Integer.parseInt(six_Perc.getText().toString());
            int sev_perc_int = Integer.parseInt(sev_Perc.getText().toString());
        }
    }

    private boolean checkPercent(int perc1, int perc2, int perc3, int perc4, int perc5, int perc6, int perc7) {
        boolean perc_ret;
        int perc_check;
        perc_check = perc1 + perc2 + perc3 + perc4 + perc5 + perc6 + perc7;
        if (perc_check > 100) {
            perc_ret = false;
        } else {
            perc_ret = true;
        }
        return perc_ret;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
