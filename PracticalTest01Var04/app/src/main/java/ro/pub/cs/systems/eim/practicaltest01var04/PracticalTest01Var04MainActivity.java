package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

            if(firstCheckBox.isChecked())
                toDisplay += firstString;
            if(secondCheckBox.isChecked())
                toDisplay += secondString;

            switch(view.getId()) {
                case R.id.displayButton:
                        textView.setText(toDisplay);
                    break;
                case R.id.navigateButton:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
                    intent.putExtra("text_to_send", toDisplay);
                    startActivityForResult(intent, 2021);
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
        navigateButton.setOnClickListener(buttonClickListener);

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

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("firstEditText", firstEditText.getText().toString());
        savedInstanceState.putString("secondEditText", secondEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
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
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 2021) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}