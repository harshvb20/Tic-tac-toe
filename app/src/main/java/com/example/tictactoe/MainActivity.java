package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0:cross, 1:zero
    int a=0;
    int c=0;
    int[] g={2,2,2,2,2,2,2,2,2};
    int [][] wp={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    boolean ga=true;
    public void dropIn (View view) {
        ImageView c= (ImageView) view;
        int tc=Integer.parseInt(c.getTag().toString());
        if(g[tc]==2&&ga)
        {
            g[tc]=a;
            c.setTranslationY(-1500);
            if(a==0){
                c.setImageResource(R.drawable.cross);
                a=1;
            }
            else {
                c.setImageResource(R.drawable.zero);
                a=0;
            }
            c.animate().translationYBy(1500).rotation(3600).setDuration(300);
            for(int[] w:wp)
            {
                if(g[w[0]]==g[w[1]]&&g[w[1]]==g[w[2]]&&g[w[0]]!=2)
                {
                    c++;
                    TextView textView=(TextView) findViewById(R.id.textView);
                    String win="";
                    if(a==0)
                        textView.setText("O has won!");
                    else if(a==1)
                        textView.setText("X has won!");
                    else if(c>=8)
                        textView.setText("Draw");
                    ga=false;
                    Button button= (Button) findViewById(R.id.button);
                    button.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                }
            }
        }

    }
    public void pa(View view)
    {
        Button button= (Button) findViewById(R.id.button);
        TextView textView=(TextView) findViewById(R.id.textView);
        button.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        GridLayout grid=(GridLayout) findViewById(R.id.grid);
        for(int i=0;i<grid.getChildCount();i++)
        {
            ImageView c=(ImageView) grid.getChildAt(i);
            c.setImageResource(0);
        }
        for(int i=0;i<g.length;i++)
            g[i]=2;
        a=0;
        ga=true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}