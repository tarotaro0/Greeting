package jp.ac.titech.itpro.sdl.greeting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView outputView;
    private EditText inputName;
    private Button okButton;
    private static final String TAG = "MainActivity";
    private final static String KEY_NAME = "MainActivity.name";
    private String name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputView = (TextView) findViewById(R.id.output_view);
        inputName = (EditText) findViewById(R.id.input_name);
        okButton = (Button) findViewById(R.id.ok_button);

        if (savedInstanceState != null)
            name = savedInstanceState.getString(KEY_NAME);
    }


    public void greet(View v) {
        String name = inputName.getText().toString();
        if (name.length() > 0)
            outputView.setText("Hello, " + name + "\nNice to see you!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        set_greet();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_NAME, name);
    }

    private void set_greet() {
        if (name != null && name.length() > 0)
            outputView.setText("Hello , " + name + "\nNice to see you again!");
    }
}
