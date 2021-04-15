package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private EditText firstEditText, secondEditText;
    private Button navigateButton, displayButton;
    private CheckBox firstCheckBox, secondCheckBox;
    private TextView textView;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String firstString = String.valueOf(firstEditText.getText().toString());
            String secondString = String.valueOf(secondEditText.getText().toString());
            String toDisplay = "";

            switch(view.getId()) {
                case R.id.displayButton:
                    if(firstCheckBox.isChecked())
                        toDisplay += firstString;
                    if(secondCheckBox.isChecked())
                        toDisplay += secondString;

                        textView.setText(toDisplay);
                    break;
                case R.id.navigateButton:
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        firstEditText = (EditText)findViewById(R.id.firstEditText);
        secondEditText = (EditText)findViewById(R.id.secondEditText);

        navigateButton = (Button)findViewById(R.id.navigateButton);
        displayButton = (Button)findViewById(R.id.displayButton);

        firstCheckBox = (CheckBox)findViewById(R.id.firstCheckBox);
        secondCheckBox = (CheckBox)findViewById(R.id.secondCheckBox);

        //firstEditText.setText(String.valueOf(""));
        //secondEditText.setText(String.valueOf(0));

        textView = (TextView) findViewById(R.id.textView);

        displayButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("firstEditText")) {
                firstEditText.setText(savedInstanceState.getString("firstEditText"));
            } else {
                firstEditText.setText(String.valueOf(""));
            }
            if (savedInstanceState.containsKey("secondEditText")) {
                secondEditText.setText(savedInstanceState.getString("secondEditText"));
            } else {
                secondEditText.setText(String.valueOf(""));
            }
        } else {
            firstEditText.setText(String.valueOf(""));
            secondEditText.setText(String.valueOf(""));
        }
    }
}