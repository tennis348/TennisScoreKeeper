package com.example.android.tennisscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.tennisscorekeeper.R.id.games_federer;
import static com.example.android.tennisscorekeeper.R.id.points_federer;
import static com.example.android.tennisscorekeeper.R.id.points_nadal;

public class MainActivity extends AppCompatActivity {

    int clickCountFederer = 0;
    int clickCountNadal = 0;
    String point0 = "0";
    String point1 = "15";
    String point2 = "30";
    String point3 = "40";
    String point5 = "AD";
    String point_federer = "";
    String point_nadal = "";
    int game_federer = 0;
    int game_nadal = 0;
    int set_federer = 0;
    int set_nadal = 0;
    int set1_federer_info = 0;
    int set1_nadal_info = 0;
    int match_info_federer = 0;
    int match_info_nadal = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Click on the numbers under Points to count score", Toast.LENGTH_LONG).show();
    }



    public void pointFederer(View view){
        clickCountFederer = clickCountFederer + 1;

        if (clickCountFederer == 1){
            point_federer = point1;
            displayPointFederer(point_federer);
        }
        if (clickCountFederer == 2){
            point_federer = point2;
            displayPointFederer(point_federer);
        }

        if (clickCountFederer == 3){
            point_federer = point3;
            displayPointFederer(point_federer);
        }

//       Following code is for when both players are at Deuce and Federer gets Advantage.

        if ((clickCountFederer == 4) && (clickCountNadal == 3)){
            point_federer = point5;
            displayPointFederer(point_federer);
        }

        //        Following code when Nadal is at Advantage but Federer wins the next point thereby Deuce again

        if ((clickCountNadal == 4) && (clickCountFederer == 4)){
            point_federer = point3;
            displayPointFederer(point_federer);
            point_nadal = point3;
            displayPointNadal(point_nadal);
            clickCountFederer = 3;
            clickCountNadal = 3;
        }

//        Following code is when Federer wins the Deuce and accordingly the game

        if ((clickCountFederer == 5) && (clickCountNadal == 3)){
            point_federer = point0;
            point_nadal = point0;
            displayPointFederer(point_federer);
            displayPointNadal(point_nadal);
            game_federer = game_federer + 1;
            clickCountFederer = 0;
            clickCountNadal = 0;
            displayGameFederer(game_federer);
        }

//        Following code for when Federer will win the Game

        if ((clickCountFederer == 4) && (clickCountNadal < 3)){
            point_federer = point0;
            point_nadal = point0;
            displayPointFederer(point_federer);
            displayPointNadal(point_nadal);
            game_federer = game_federer + 1;
            clickCountFederer = 0;
            clickCountNadal = 0;
            displayGameFederer(game_federer);
        }

//        Following code for when Federer wins the set with 6 games

        if ((game_federer == 6) && (game_nadal <= 4)){
            set1_federer_info = game_federer;
            set1_nadal_info = game_nadal;
            game_federer = 0;
            game_nadal = 0;
            displayGameFederer(game_federer);
            displayGameNadal(game_nadal);
            set_federer = set_federer + 1;
            displaySetFederer(set_federer);
            Toast.makeText(this, "Federer wins the set " + set1_federer_info + "-" + set1_nadal_info, Toast.LENGTH_SHORT).show();
        }

//        Following code for the rule of difference of 2 to win a set

        if ((game_federer >= 6 && game_nadal >= 5) && (game_federer >= game_nadal + 2)){
            set1_federer_info = game_federer;
            set1_nadal_info = game_nadal;
            game_federer = 0;
            game_nadal = 0;
            displayGameFederer(game_federer);
            displayGameNadal(game_nadal);
            set_federer = set_federer + 1;
            displaySetFederer(set_federer);
            Toast.makeText(this, "Federer wins the set " + set1_federer_info + "-" + set1_nadal_info, Toast.LENGTH_SHORT).show();
            }

//            Following code when Federer wins the match

            if ((set_federer == 2) && (set_nadal <= 1)){
                match_info_federer = set_federer;
                match_info_nadal = set_nadal;
                set_federer = 0;
                set_nadal = 0;
                displaySetFederer(set_federer);
                displaySetNadal(set_nadal);
                Toast.makeText(this, "Federer wins " + match_info_federer + "-" + match_info_nadal,Toast.LENGTH_SHORT).show();
            }





    }

    public void pointNadal(View view) {
        clickCountNadal = clickCountNadal + 1;

        if (clickCountNadal == 1) {
            point_nadal = point1;
            displayPointNadal(point_nadal);
        }
        if (clickCountNadal == 2) {
            point_nadal = point2;
            displayPointNadal(point_nadal);
        }

        if (clickCountNadal == 3) {
            point_nadal = point3;
            displayPointNadal(point_nadal);
        }

//          Following code is for when both players are at Deuce and Nadal gets Advantage.

        if ((clickCountNadal == 4) && (clickCountFederer == 3)) {
            point_nadal = point5;
            displayPointNadal(point_nadal);
        }

        //        Following code when Federer is at Advantage but Nadal wins the next point thereby Deuce again

        if ((clickCountFederer == 4) && (clickCountNadal == 4)) {
            point_federer = point3;
            displayPointFederer(point_federer);
            point_nadal = point3;
            displayPointNadal(point_nadal);
            clickCountFederer = 3;
            clickCountNadal = 3;
        }

//          Following code is when Nadal wins the Deuce and accordingly the game

        if ((clickCountNadal == 5) && (clickCountFederer == 3)) {
            point_federer = point0;
            point_nadal = point0;
            displayPointFederer(point_federer);
            displayPointNadal(point_nadal);
            game_nadal = game_nadal + 1;
            clickCountFederer = 0;
            clickCountNadal = 0;
            displayGameNadal(game_nadal);
        }

//        Following code for when Nadal will win the Game

        if ((clickCountNadal == 4) && (clickCountFederer < 3)) {
            point_nadal = point0;
            point_federer = point0;
            displayPointNadal(point_nadal);
            displayPointFederer(point_federer);
            game_nadal = game_nadal + 1;
            clickCountFederer = 0;
            clickCountNadal = 0;
            displayGameNadal(game_nadal);
        }

//        Following code when Nadal wins the set with 6 games

        if ((game_nadal == 6) && (game_federer <= 4)) {
            set1_federer_info = game_federer;
            set1_nadal_info = game_nadal;
            game_federer = 0;
            game_nadal = 0;
            displayGameFederer(game_federer);
            displayGameNadal(game_nadal);
            set_nadal = set_nadal + 1;
            displaySetNadal(set_nadal);
            Toast.makeText(this, "Nadal wins the set " + set1_federer_info + "-" + set1_nadal_info, Toast.LENGTH_SHORT).show();
        }

//        Following code for the rule of difference of 2 to win a set

        if ((game_nadal >= 6 && game_federer >= 5) && (game_nadal >= game_federer + 2)) {
            set1_federer_info = game_federer;
            set1_nadal_info = game_nadal;
            game_federer = 0;
            game_nadal = 0;
            displayGameFederer(game_federer);
            displayGameNadal(game_nadal);
            set_nadal = set_nadal + 1;
            displaySetNadal(set_nadal);
            Toast.makeText(this, "Nadal wins the set " + set1_federer_info + "-" + set1_nadal_info, Toast.LENGTH_SHORT).show();
        }

//        Following code when Nadal wins the match

        if ((set_nadal == 2) && (set_federer <= 1)) {
            match_info_federer = set_federer;
            match_info_nadal = set_nadal;
            set_federer = 0;
            set_nadal = 0;
            displaySetFederer(set_federer);
            displaySetNadal(set_nadal);
            Toast.makeText(this, "Nadal wins " + match_info_federer + "-" + match_info_nadal, Toast.LENGTH_SHORT).show();
        }
    }

        public void reset_set_btn(View view){
            set_federer = 0;
            set_nadal = 0;
            displaySetFederer(set_federer);
            displaySetNadal(set_nadal);
    }

        public void reset_game_btn(View view){
            game_federer = 0;
            game_nadal = 0;
            displayGameFederer(game_federer);
            displayGameNadal(game_nadal);
        }

        public void reset_points_btn(View view){
            point_federer = point0;
            point_nadal = point0;
            displayPointFederer(point_federer);
            displayPointNadal(point_nadal);
        }




    private void displayPointFederer(String points){
        TextView point_federer = (TextView) findViewById(R.id.points_federer);
        point_federer.setText("" + points);
    }

    private void displayPointNadal(String points){
        TextView point_nadal = (TextView) findViewById(R.id.points_nadal);
        point_nadal.setText("" + points);
    }

    private void displayGameFederer(int games){
        TextView game_federer = (TextView) findViewById(R.id.games_federer);
        game_federer.setText("" + games);
    }

    private void displayGameNadal(int games){
        TextView game_nadal = (TextView) findViewById(R.id.games_nadal);
        game_nadal.setText("" + games);
    }

    private void displaySetFederer(int sets){
        TextView set_federer = (TextView) findViewById(R.id.sets_federer);
        set_federer.setText("" + sets);
    }

    private void displaySetNadal(int sets){
        TextView set_nadal = (TextView) findViewById(R.id.sets_nadal);
        set_nadal.setText("" + sets);
    }

}
