package ctec.stateapplication.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

import ctec.stateapplication.model.AndroidSaveState;

public class BackPageActivity extends Activity {

    private TextView userText;
    private Button backButton;

    private AndroidSaveState saveState;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_page);

        saveState = (AndroidSaveState) getApplication();
        backButton = (Button) findViewById(R.id.backButton);
        userText = (TextView) findViewById(R.id.userText);

        loadContent();

        setupListeners();
    }

    /**
     * Loads the content from the last saved state.
     */
    private void loadContent()
    {
        userText.setText( saveState.getUserName() + " is " + saveState.getAge()
                + " years old " + " and her/his tired setting is " + saveState.getIsTired());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_back_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Setups the listeners for the next page.
     */
    private void setupListeners()
    {
        backButton.setOnClickListener(new View.OnClickListener()
        {
            //Close this screen and return.
            public void onClick(View clickView){
                Intent returnIntent = new Intent();
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
