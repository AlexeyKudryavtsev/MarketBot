package ru.ahome.marketbot.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import ru.ahome.marketbot.R;
import ru.ahome.marketbot.model.Settings;


public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        final EditText botName_ET = (EditText) findViewById(R.id.bot_name_textbox);
        final EditText ApiKey_ET = (EditText) findViewById(R.id.api_key_textbox);

        final Settings settings = new Settings(this);
        botName_ET.setText(settings.getSetting("bot_name"));
        ApiKey_ET.setText(settings.getSetting("api_key"));

        botName_ET.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                settings.setSetting("bot_name",charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ApiKey_ET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                settings.setSetting("api_key",charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
