package com.example.tanmay.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int x=0;
    boolean gameIsActive = true;
    int state[] = {2,2,2,2,2,2,2,2,2};
    int [][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropIn(View view)
    {
        ImageView counter= (ImageView) view;
        int tag= Integer.parseInt(counter.getTag().toString());
        if(state[tag]==2 && gameIsActive)
        {
            state[tag]=x;

            counter.setTranslationY(-1000f);
            if (x == 0) {
                counter.setImageResource(R.drawable.mul);
                x = 1;
            } else {
                counter.setImageResource(R.drawable.oimg);
                x = 0;

            }
            counter.animate().translationYBy(1000f).setDuration(500);
            for(int [] pos : winpos)
            {
                if(state[pos[0]]==state[pos[1]] && state[pos[1]]==state[pos[2]]
                        && state[pos[0]]!=2)
                {

                    gameIsActive = false;
                    String winner = Main2Activity.name2.getText().toString();

                    if (state[pos[0]]==0) {
                        winner = Main2Activity.name1.getText().toString();
                    }

                    TextView winnerMessage = findViewById(R.id.textView2);
                    winnerMessage.setText(winner+" Has Won");
                    LinearLayout layout = findViewById(R.id.llayout);
                    layout.setVisibility(View.VISIBLE);

                }
                else{
                    Boolean gameOver=true;
                    for(int counterState: state)
                    {
                        if(counterState==2)
                            gameOver=false;
                    }
                    if(gameOver)
                    {
                        TextView winnerMessage = findViewById(R.id.textView2);
                        winnerMessage.setText("Match Draw");
                        LinearLayout layout= findViewById(R.id.llayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }
    public void again(View view){
        gameIsActive=true;
        LinearLayout layout= findViewById(R.id.llayout);
        layout.setVisibility(View.INVISIBLE);
        for (int i=0;i<state.length;i++)
        {
            state[i]=2;
        }
        android.support.v7.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);
        for (int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView viewImage = (ImageView) gridLayout.getChildAt(i);
            viewImage.setImageDrawable(null);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}