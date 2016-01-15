package com.example.android.recat;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.content.Intent;
import com.example.android.recat.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


import java.util.Random;

public class Speed100Activity extends AppCompatActivity {

    Random rand = new Random();
    String [] catList = {"S", "G", "H", "K", "M", "L"};

    int catLeader = rand.nextInt(6);
    int catFollower = rand.nextInt(6);
    int score = 0;
    int tries =0;

    int[][] catTable = {{3, 4, 5, 5, 6, 8},
            {3, 3, 4, 4, 5, 7},
            {3, 3, 3, 3, 4, 6},
            {3, 3, 3, 3, 3, 5},
            {3, 3, 3, 3, 3, 4},
            {3, 3, 3, 3, 3, 3}};

    String[] catS = { "A380" };
    String[] catG = { "B777", "B747", "B787", "A340", "A330", "A350"};
    String[] catH = { "B757", "B767", "A310", "A300", "MD11"};
    String[] catK = { "B736", "B737", "B738", "B739", "A318", "A319", "A320", "A321", "C130", "MD80", "MD90"};
    String[] catM = { "B733", "B735", "AT42", "AT72", "DH8", "BA46", "RJ45", "RJ1H", "CRJ1", "CRJ2", "CRJ7", "CRJ9", "E135" , "E145", "E195", "F70", "F100", "GLDF2", "GLF4", "CL30", "CL60" };
    String[] catL = { "FA10", "C560", "LJ35", "C56X", "D328", "C680", "H25B", "LJ35", "LJ45", "SF34", "SW4", "BE40", "E120"};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed100);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        displayForLeader(catLeader);
        displayLeaderType(catLeader);
        displayForFollower(catFollower);
        displayFollowerType(catFollower);

        /*
        This change the color of the status bar by the colorPrimaryDark
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;


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

    /**
     * Displays the score.
     */

    public void displayScore(int score) {


        TextView scoreView = (TextView) findViewById(R.id.score);
        int percents = 100 * score / tries;
        scoreView.setText(String.valueOf(score) + " / " + String.valueOf(tries) + " (" + percents + "%)");
    }




    /**
     * Displays the category of the leader.
     */

    public void displayForLeader(int catLeader) {


        TextView catLeaderView = (TextView) findViewById(R.id.leader);
        catLeaderView.setText(catList[catLeader]);
    }

    /**
     * Displays the type of the leader.
     */

    public void displayLeaderType(int catLeader) {


        TextView leaderTypeView = (TextView) findViewById(R.id.leaderType);
        leaderTypeView.setText(typeByCat(catLeader));
    }


    /**
     * Displays the category of the follower.
     */

    public void displayFollowerType(int catFollower) {
        TextView followerTypeView = (TextView) findViewById(R.id.followerType);
        followerTypeView.setText(typeByCat(catFollower));
    }


    /**
     * Displays the category of the follower.
     */

    public void displayForFollower(int catFollower) {
        TextView catFollowerView = (TextView) findViewById(R.id.follower);
        catFollowerView.setText(catList[catFollower]);
    }


    /**
     * Displays the category of the follower.
     *
     */

    public String typeByCat(int cat) {
        switch (cat)
        {
            case 0 :
                return catS[rand.nextInt(catS.length)];

            case 1 :
                return catG[rand.nextInt(catG.length)];

            case 2 :
                return catH[rand.nextInt(catH.length)];

            case 3 :
                return catK[rand.nextInt(catK.length)];

            case 4 :
                return catM[rand.nextInt(catM.length)];

            case 5 :
                return catL[rand.nextInt(catL.length)];

            default:
                return "A321";

        }
    }




    public void spacing3(View view) {

        if (catTable[catLeader][catFollower] == 3)
        {
            catLeader = rand.nextInt(6);
            catFollower = rand.nextInt(6);
            displayForLeader(catLeader);
            displayLeaderType(catLeader);
            displayForFollower(catFollower);
            displayFollowerType(catFollower);

            score++;
        }

        tries++;
        displayScore(score);

    }


    public void spacing4(View view) {
        if (catTable[catLeader][catFollower] == 4)
        {
            catLeader = rand.nextInt(6);
            catFollower = rand.nextInt(6);
            displayForLeader(catLeader);
            displayLeaderType(catLeader);
            displayForFollower(catFollower);
            displayFollowerType(catFollower);
            score++;
        }

        tries++;
        displayScore(score);
    }

    public void spacing5(View view) {
        if (catTable[catLeader][catFollower] == 5)
        {
            catLeader = rand.nextInt(6);
            catFollower = rand.nextInt(6);
            displayForLeader(catLeader);
            displayLeaderType(catLeader);
            displayForFollower(catFollower);
            displayFollowerType(catFollower);
            score++;
        }

        tries++;
        displayScore(score);
    }

    public void spacing6(View view) {
        if (catTable[catLeader][catFollower] == 6)
        {
            catLeader = rand.nextInt(6);
            catFollower = rand.nextInt(6);
            displayForLeader(catLeader);
            displayLeaderType(catLeader);
            displayForFollower(catFollower);
            displayFollowerType(catFollower);
            score++;
        }

        tries++;
        displayScore(score);
    }

    public void spacing7(View view) {
        if (catTable[catLeader][catFollower] == 7)
        {
            catLeader = rand.nextInt(6);
            catFollower = rand.nextInt(6);
            displayForLeader(catLeader);
            displayLeaderType(catLeader);
            displayForFollower(catFollower);
            displayFollowerType(catFollower);
            score++;
        }

        tries++;
        displayScore(score);
    }

    public void spacing8(View view) {
        if (catTable[catLeader][catFollower] == 8)
        {
            catLeader = rand.nextInt(6);
            catFollower = rand.nextInt(6);
            displayForLeader(catLeader);
            displayLeaderType(catLeader);
            displayForFollower(catFollower);
            displayFollowerType(catFollower);
            score++;
        }

        tries++;
        displayScore(score);
    }



}
