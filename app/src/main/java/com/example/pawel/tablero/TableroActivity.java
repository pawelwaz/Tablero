package com.example.pawel.tablero;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import java.math.BigDecimal;

/**
 * Created by pawel on 2016-02-15.
 */
public class TableroActivity extends AppCompatActivity {

    public BigDecimal getInputBigDecimal(int id) {
        EditText input = (EditText) findViewById(id);
        if(input.length() == 0) {
            input.setText("1");
            return new BigDecimal("1");
        }
        else return new BigDecimal(input.getText().toString());
    }

    public String prepareUnitName(String name, int type) {
        switch(type) {
            case 2:
            case 5:
                name = name.replace("2", "<small><sup>2</sup></small>");
                break;
            case 3:
                name = name.replace("3", "<small><sup>3</sup></small>");
                break;
            case 4:
                name = name.replace("o", "<small><sup>o</sup></small>");
                break;
        }
        return name;
    }
}
