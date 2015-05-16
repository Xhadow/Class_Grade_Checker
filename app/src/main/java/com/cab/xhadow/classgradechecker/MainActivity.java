package com.cab.xhadow.classgradechecker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    //floats to determine Final Grades
    private static float Final_Calc_A;
    private static float Final_Calc_B;
    private static float Final_Calc_C;

    //private  AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mAdView = (AdView) findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        //mAdView.resume();
    }

    @Override
    public  void onPause() {
        //mAdView.pause();
        super.onPause();
    }

    public void clickButton(View v) {
        //float to keep track of percentages given
        float[] Cperc_int = new float[15];
        float[] perc_int = new float[15];
        //EditTect array to take in inputs
        EditText[] Cperc = new EditText[15];
        EditText[] perc = new EditText[15];
        //Get the inputs for the class percentages
        Cperc[0] = (EditText) findViewById(R.id.editText2);
        Cperc[1] = (EditText) findViewById(R.id.editText4);
        Cperc[2] = (EditText) findViewById(R.id.editText6);
        Cperc[3] = (EditText) findViewById(R.id.editText8);
        Cperc[4] = (EditText) findViewById(R.id.editText10);
        Cperc[5] = (EditText) findViewById(R.id.editText12);
        Cperc[6] = (EditText) findViewById(R.id.editText14);
        Cperc[7] = (EditText) findViewById(R.id.editText16);
        Cperc[8] = (EditText) findViewById(R.id.editText18);
        Cperc[9] = (EditText) findViewById(R.id.editText20);
        Cperc[10] = (EditText) findViewById(R.id.editText22);
        Cperc[11] = (EditText) findViewById(R.id.editText24);
        Cperc[12] = (EditText) findViewById(R.id.editText26);
        Cperc[13] = (EditText) findViewById(R.id.editText28);
        Cperc[14] = (EditText) findViewById(R.id.editText30);
        for(int i = 0; i < Cperc.length; i++) {
            //turn the inputs into ints
            Cperc_int[i] = Integer.parseInt(Cperc[i].getText().toString());
        }
        if(!(checkPercent(Cperc_int))) {
            //send out erro that the class percentage is above 100%
            TextView errt = (TextView) findViewById(R.id.textView13);
            errt.setText("Error: Class Percentage over 100 W/O final");
        } else {
            //set error message to blank so it takes off any error messages already displayed
            TextView errt = (TextView) findViewById(R.id.textView13);
            errt.setText("");
            //Get the inputs for the assignment percentages
            perc[0] = (EditText) findViewById(R.id.editText);
            perc[1] = (EditText) findViewById(R.id.editText3);
            perc[2] = (EditText) findViewById(R.id.editText5);
            perc[3] = (EditText) findViewById(R.id.editText7);
            perc[4] = (EditText) findViewById(R.id.editText9);
            perc[5] = (EditText) findViewById(R.id.editText11);
            perc[6] = (EditText) findViewById(R.id.editText13);
            perc[7] = (EditText) findViewById(R.id.editText15);
            perc[8] = (EditText) findViewById(R.id.editText17);
            perc[9] = (EditText) findViewById(R.id.editText19);
            perc[10] = (EditText) findViewById(R.id.editText21);
            perc[11] = (EditText) findViewById(R.id.editText23);
            perc[12] = (EditText) findViewById(R.id.editText25);
            perc[13] = (EditText) findViewById(R.id.editText27);
            perc[14] = (EditText) findViewById(R.id.editText29);
            for(int i = 0; i < perc.length; i++) {
                //convert inputs into ints
                perc_int[i] = Integer.parseInt(perc[i].getText().toString());
            }
            //calculate the grade
            float gradesCalc = calcGrade(perc_int, Cperc_int);
            Final_Calc_A = checkGradeForA(gradesCalc, Cperc_int);
            Final_Calc_B = checkGradeForB(gradesCalc, Cperc_int);
            Final_Calc_C = checkGradeForC(gradesCalc, Cperc_int);
            //Display the grades from the calculations
            TextView gradeA = (TextView) findViewById(R.id.textView14);
            gradeA.setText(Final_Calc_A + "%");
            TextView gradeB = (TextView) findViewById(R.id.textView15);
            gradeB.setText(Final_Calc_B + "%");
            TextView gradeC = (TextView) findViewById(R.id.textView16);
            gradeC.setText(Final_Calc_C + "%");
        }
    }
    //Checks to see that the percents passed in don't exceed 100
    private boolean checkPercent(float[] perc) {
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
    //Caluclate the grades from assignment and their percentage worth
    private float calcGrade(float[] percPer, float[] percClass) {
        float calcGrade = 0;
        float curGrade = 0;
        float totalPerc = 0;
        float[] grades = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for(int i = 0; i < percPer.length; i++) {
            grades[i] = ((percPer[i]) * (percClass[i]/100));
            totalPerc += percClass[i];
        }
        for(int i = 0; i < grades.length; i++) {
            calcGrade += grades[i];
        }
        curGrade = calcGrade/(totalPerc/100);
        //display current grade
        TextView gradeA = (TextView) findViewById(R.id.textView18);
        gradeA.setText(curGrade + "%");
        return calcGrade;
    }

    //Calculate grade needed on final for that A
    private float checkGradeForA(float finalGrade, float[] classPerc) {
        float grade = 0;
        float gradeNeed = 0;
        int totalPerc = 0;
        int finalPerc = 0;
        for(int i = 0; i < classPerc.length; i++) {
            totalPerc += classPerc[i];
        }
        finalPerc = 100 - totalPerc;
        gradeNeed = 90 - finalGrade;
        grade = ((gradeNeed/finalPerc)*100);
        return grade;
    }

    //Calculate grade needed on final for that A
    private float checkGradeForB(float finalGrade, float[] classPerc) {
        float grade = 0;
        float gradeNeed = 0;
        int totalPerc = 0;
        int finalPerc = 0;
        for(int i = 0; i < classPerc.length; i++) {
            totalPerc += classPerc[i];
        }
        finalPerc = 100 - totalPerc;
        gradeNeed = 80 - finalGrade;
        grade = ((gradeNeed/finalPerc)*100);
        return grade;
    }

    //Calculate grade needed on final for that A
    private float checkGradeForC(float finalGrade, float[] classPerc) {
        float grade = 0;
        float gradeNeed = 0;
        int totalPerc = 0;
        int finalPerc = 0;
        for(int i = 0; i < classPerc.length; i++) {
            totalPerc += classPerc[i];
        }
        finalPerc = 100 - totalPerc;
        gradeNeed = 70 - finalGrade;
        grade = ((gradeNeed/finalPerc)*100);
        return grade;
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
