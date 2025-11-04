package essths.li3.tp1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    Button add, sub, mul, div;
    TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.INT1);
        num2 = findViewById(R.id.INT2);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        
        res = findViewById(R.id.Result);
        View.OnClickListener listener = v -> {
            if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                return;
            }
            double a = Double.parseDouble(num1.getText().toString());
            double b = Double.parseDouble(num2.getText().toString());
            double result = 0;


            int id = v.getId();
            if (id == R.id.add) {
                result = a + b;
            } else if (id == R.id.sub) {
                result = a - b;
            } else if (id == R.id.mul) {
                result = a * b;
            } else if (id == R.id.div) {
                if (b==0){
                    Toast.makeText(this, "Cant Divide by Zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = a / b;
            }
            res.setText(String.valueOf(result));

        };
        add.setOnClickListener(listener);
        sub.setOnClickListener(listener);
        mul.setOnClickListener(listener);
        div.setOnClickListener(listener);

    }

}