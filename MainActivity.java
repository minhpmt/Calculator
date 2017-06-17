package thangcoder.com.calculator;

import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNumber;
    private TextView tvResult;

    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnNumber0;

    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;

    private Button btnPoint;
    private Button btnResult;
    private Button btnClear;
    private Button btnClearAll;

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnNumber0:
                //To do
                edtNumber.append("0");
            break;
            case R.id.btnNumber1:
                //To do
                edtNumber.append("1");
                break;
            case R.id.btnNumber2:
                //To do
                edtNumber.append("2");
                break;
            case R.id.btnNumber3:
                //To do
                edtNumber.append("3");
                break;
            case R.id.btnNumber4:
                //To do
                edtNumber.append("4");
                break;
            case R.id.btnNumber5:
                //To do
                edtNumber.append("5");
                break;
            case R.id.btnNumber6:
                //To do
                edtNumber.append("6");
                break;
            case R.id.btnNumber7:
                //To do
                edtNumber.append("7");
                break;
            case R.id.btnNumber8:
                //To do
                edtNumber.append("8");
                break;
            case R.id.btnNumber9:
                //To do
                edtNumber.append("9");
                break;

            case R.id.btnCong:
                //To do
                edtNumber.append("+");
                break;
            case R.id.btnTru:
                //To do
                edtNumber.append("-");
                break;
            case R.id.btnNhan:
                //To do
                edtNumber.append("*");
                break;
            case R.id.btnChia:
                //To do
                edtNumber.append("/");
                break;

            case R.id.btnPoint:
                //To do
                edtNumber.append(".");
                break;
            case R.id.btnResult:
                //To do
                //int numberA= Integer.parseInt(String.valueOf(edtNumber.getText()));
                double result=0;
                DecimalFormat df=new DecimalFormat("###.#######");
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());

                if (arrNumber.size()<=arrOperation.size()||arrOperation.size()==0)
                    tvResult.setText("Lỗi định dạng");
                    else {
                    for (int i = 0; i < arrNumber.size() - 1; i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }

                    }


                    tvResult.setText(df.format(result)+"");

                }
            case R.id.btnClear:
                //To do
//                String numberAfterRemove=deleteANumber(edtNumber.getText().toString());
//                edtNumber.setText(numberAfterRemove);
                BaseInputConnection textFieldInputConnection=new BaseInputConnection(edtNumber,true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnClearAll:
                //To do
                edtNumber.setText("");
                break;
            default:
                break;

        }
    }

   /* public String deleteANumber(String number){
        int length=edtNumber.length();
        String temp=number.substring(0,length-1);
        return temp;
    }*/

   public ArrayList<String> arrOperation;
    public ArrayList<Double> arrNumber;

    public int addOperation(String input){
        arrOperation=new ArrayList<>();
        char[] cArray= input.toCharArray();
        for( int i=0;i<cArray.length;i++)
        {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i]+"");
                    break;
                case '-':
                    arrOperation.add(cArray[i]+"");
                    break;
                case '*':
                    arrOperation.add(cArray[i]+"");
                    break;
                case '/':
                    arrOperation.add(cArray[i]+"");
                    break;
                default:
                    break;

            }
        }
        return 0;
    }

    public void addNumber(String stringInput){
        arrNumber=new ArrayList<>();
        Pattern regex= Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher=regex.matcher(stringInput);
        while (matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWiget();
        setEventClickViews();
    }

    public void setEventClickViews(){
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);

        btnPoint.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
        btnResult.setOnClickListener(this);


    }

    public void initWiget(){

        edtNumber=(EditText)findViewById(R.id.edit_input);
        tvResult=(TextView)findViewById(R.id.tv_result);

        btnNumber0 =(Button)findViewById(R.id.btnNumber0);
        btnNumber1 =(Button)findViewById(R.id.btnNumber1);
        btnNumber2 =(Button)findViewById(R.id.btnNumber2);
        btnNumber3 =(Button)findViewById(R.id.btnNumber3);
        btnNumber4 =(Button)findViewById(R.id.btnNumber4);
        btnNumber5 =(Button)findViewById(R.id.btnNumber5);
        btnNumber6 =(Button)findViewById(R.id.btnNumber6);
        btnNumber7 =(Button)findViewById(R.id.btnNumber7);
        btnNumber8 =(Button)findViewById(R.id.btnNumber8);
        btnNumber9 =(Button)findViewById(R.id.btnNumber9);

        btnCong =(Button)findViewById(R.id.btnCong);
        btnTru =(Button)findViewById(R.id.btnTru);
        btnNhan =(Button)findViewById(R.id.btnNhan);
        btnChia =(Button)findViewById(R.id.btnChia);

        btnPoint =(Button)findViewById(R.id.btnPoint);
        btnResult =(Button)findViewById(R.id.btnResult);
        btnClear =(Button)findViewById(R.id.btnClear);
        btnClearAll =(Button)findViewById(R.id.btnClearAll);
    }
}
