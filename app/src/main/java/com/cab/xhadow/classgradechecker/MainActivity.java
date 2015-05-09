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
        int[] Cperc_int = new int[7];
        int[] perc_int = new int[7];
        EditText[] Cperc = new EditText[7];
        EditText[] perc = new EditText[7];
        //Get the inputs for the class percentages
        Cperc[0] = (EditText) findViewById(R.id.editText2);
        Cperc[1] = (EditText) findViewById(R.id.editText4);
        Cperc[2] = (EditText) findViewById(R.id.editText6);
        Cperc[3] = (EditText) findViewById(R.id.editText8);
        Cperc[4] = (EditText) findViewById(R.id.editText10);
        Cperc[5] = (EditText) findViewById(R.id.editText12);
        Cperc[6] = (EditText) findViewById(R.id.editText14);
        for(int i = 0; i < Cperc.length; i++) {
            Cperc_int[i] = Integer.parseInt(Cperc[i].getText().toString());
        }
        if(!(checkPercent(Cperc_int))) {
            TextView errt = (TextView) findViewById(R.id.textView13);
            errt.setText("Error: Percentage in class is over 100");
        } else {
            //Get the inputs for their percentages
            TextView errt = (TextView) findViewById(R.id.textView13);
            errt.setText("");
            perc[0] = (EditText) findViewById(R.id.editText);
            perc[1] = (EditText) findViewById(R.id.editText3);
            perc[2] = (EditText) findViewById(R.id.editText5);
            perc[3] = (EditText) findViewById(R.id.editText7);
            perc[4] = (EditText) findViewById(R.id.editText9);
            perc[5] = (EditText) findViewById(R.id.editText11);
            perc[6] = (EditText) findViewById(R.id.editText13);
            for(int i = 0; i < perc.length; i++) {
                perc_int[i] = Integer.parseInt(perc[i].getText().toString());
            }

            calcGrade(perc_int, Cperc_int);
        }
    }

    private boolean checkPercent(int[] perc) {
        boolean perc_ret;
        int perc_check = 0;
        for(int i = 0; i < perc.length; i++)
        {
            perc_check += perc[i];
        }
        if (perc_check > 100) {
            perc_ret = false;
        } else {
            perc_ret = true;
        }
        return perc_ret;
    }

    private int calcGrade(int[] percPer, int[] percClass) {
        int calcGraded;
        return calcGraded;
    }

    private int checkGradePerc(int persGrade, int classGrade) {
        int gradePerc;
        return gradePerc;
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
