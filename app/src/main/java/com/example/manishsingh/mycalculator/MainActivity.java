package com.example.manishsingh.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    StringBuilder exp =new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.txt);
        init();

    }

    private void init() {
        findViewById(R.id.b1).setOnClickListener(this);
        findViewById(R.id.b2).setOnClickListener(this);
        findViewById(R.id.b3).setOnClickListener(this);
        findViewById(R.id.b4).setOnClickListener(this);
        findViewById(R.id.b5).setOnClickListener(this);
        findViewById(R.id.b6).setOnClickListener(this);
        findViewById(R.id.b7).setOnClickListener(this);
        findViewById(R.id.b8).setOnClickListener(this);
        findViewById(R.id.b9).setOnClickListener(this);
        findViewById(R.id.b0).setOnClickListener(this);
        findViewById(R.id.beq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calulate();
            }
        });
        findViewById(R.id.bdot).setOnClickListener(this);
        findViewById(R.id.badd).setOnClickListener(this);
        findViewById(R.id.bsub).setOnClickListener(this);
        findViewById(R.id.bmul).setOnClickListener(this);
        findViewById(R.id.bdiv).setOnClickListener(this);
        findViewById(R.id.bper).setOnClickListener(this);
        findViewById(R.id.bac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeOne();
            }
        });
        findViewById(R.id.bclr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                textView.setText("0");
            }
        });

    }

    @Override
    public void onClick(View view) {
        int id= view.getId();
        switch (id){
            case R.id.b1:exp.append(1);break;
            case R.id.b2:exp.append(2);break;
            case R.id.b3:exp.append(3);break;
            case R.id.b4:exp.append(4);break;
            case R.id.b5:exp.append(5);break;
            case R.id.b6:exp.append(6);break;
            case R.id.b7:exp.append(7);break;
            case R.id.b8:exp.append(8);break;
            case R.id.b9:exp.append(9);break;
            case R.id.b0:exp.append(0);break;
            case R.id.bdot:exp.append(".");break;
            case R.id.badd:if (verifyOp())exp.append("+");break;
            case R.id.bsub:if (verifyOp())exp.append("-");break;
            case R.id.bmul:if (verifyOp())exp.append("*");break;
            case R.id.bdiv:if (verifyOp())exp.append("/");break;
            case R.id.bper:if (verifyOp())exp.append("%");break;
        }
        textView.setText(exp);
        textView.setTextSize(40);
    }
    public void calulate(){
        ExpressionBuilder builder= new ExpressionBuilder(exp.toString());
        Expression expression = builder.build();
        int res= (int) expression.evaluate();
        textView.setText(exp.toString()+ "\n"+String.valueOf(res));



    }
    public void removeOne(){
        if (exp.length()>0){
            exp.deleteCharAt(exp.length()-1);
            textView.setText(exp.toString());
        }
    }
    public void clear(){
        exp.replace(0,exp.length(),"");
        textView.setText(exp.toString());

    }
    private boolean verifyOp(){
        if (exp.length()>0){
            char c=exp.charAt(exp.length()-1);
            if(c== '+'||c=='-'||c=='*'||c=='/'||c=='%')
            {
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
}

