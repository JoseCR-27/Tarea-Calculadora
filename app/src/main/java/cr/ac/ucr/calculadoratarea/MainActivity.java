package cr.ac.ucr.calculadoratarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView screen;
    private Button AC, sum, sub, div, mul, equal, point, one, two, three, four, five, six, seven, eight, nine, zero;
    private String input, answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);

        AC = findViewById(R.id.bt_ac);
        sum = findViewById(R.id.bt_sum);
        sub = findViewById(R.id.bt_sub);
        div = findViewById(R.id.bt_div);
        mul = findViewById(R.id.bt_mul);
        equal = findViewById(R.id.bt_equal);
        point = findViewById(R.id.bt_point);
        one = findViewById(R.id.bt_one);
        two = findViewById(R.id.bt_two);
        three = findViewById(R.id.bt_three);
        four = findViewById(R.id.bt_four);
        five = findViewById(R.id.bt_five);
        six = findViewById(R.id.bt_six);
        seven = findViewById(R.id.bt_seven);
        eight = findViewById(R.id.bt_eight);
        nine = findViewById(R.id.bt_nine);
        zero = findViewById(R.id.bt_zero);



    }

    public void onClick(View view){

        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data){
            case "AC":
                input="";
                break;
            case "x":
                solveProblem();
                input += "*";
                break;
            case "=":
                solveProblem();
                answer = input;
                break;
            default:
                if (input == null){
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")){
                    solveProblem();
                }
                input += data;
        }
        screen.setText(input);

    }

    private void solveProblem() {
        //Multiplicacion
        if (input.split("\\*").length == 2){
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul + "";
            }catch (Exception e){

            }
        }

        //División
        else if (input.split("/").length == 2){
            String number[] = input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            }catch (Exception e){

            }
        }


        //Suma
        else if (input.split("\\+").length == 2){
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum + "";
            }catch (Exception e){

            }
        }

        //Resta
        else if (input.split("-").length > 1){
            String number[] = input.split("-");

            //Para poder restar numeros negativos
            if (number[0] == "" & number.length==2){
                number[0] = 0 + "";
            }

            try {
                double sub = 0;

                if (number.length == 2){
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if (number.length == 3){
                    sub = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = sub + "";
            }catch (Exception e){

            }
        }

        //Para que de numeros enteros cm 1 de 1.0
        String n[] = input.split("\\.");
        if (n.length>1){
            if (n[1].equals("0")){
                input = n[0];
            }
        }
        screen.setText(input);
    }
}