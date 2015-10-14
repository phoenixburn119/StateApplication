package ctec.stateapplication.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.view.View;
import android.content.Intent;

import ctec.stateapplication.model.AndroidSaveState;

public class FrontPageActivity extends Activity
{
    private Button nextScreenButton;
    private EditText nameText;
    private EditText ageText;
    private CheckBox isTiredBox;

    private AndroidSaveState saveState;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        //Access to the save state.
        saveState = (AndroidSaveState) getApplication();

        nextScreenButton = (Button) findViewById(R.id.submitButton);
        nameText = (EditText) findViewById(R.id.nameText);
        ageText = (EditText) findViewById(R.id.ageText);
        isTiredBox = (CheckBox) findViewById(R.id.isTiredBox);


        setupListeners();
    }

    /**
     * Retrieves all user input from fields.
     */
    private void grabInput()
    {
        String name = nameText.getText().toString();
        int age = Integer.parseInt(ageText.getText().toString());
        boolean isTired = isTiredBox.isChecked();

        saveState.setUserName(name);
        saveState.setAge(age);
        saveState.setIsTired(isTired);
    }

    private void setupListeners()
    {
        nextScreenButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View clickView)
            {
                //grab user info
                grabInput();

                //Opens the next screen.
                Intent changeScreen = new Intent(clickView.getContext(), BackPageActivity.class);
                startActivityForResult(changeScreen, 0);

            }
        });
    }
}
