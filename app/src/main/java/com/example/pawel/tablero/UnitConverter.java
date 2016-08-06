package com.example.pawel.tablero;

import android.content.res.Resources;
import android.opengl.Visibility;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class UnitConverter extends TableroActivity implements AdapterView.OnItemSelectedListener {
    private static int unit;
    private static int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = 0;
        unit = 0;
        setContentView(R.layout.activity_unit_converter);
        Spinner typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitTypes, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);
        typeSpinner.setOnItemSelectedListener(this);
        Spinner unitSpinner = (Spinner) findViewById(R.id.unitSpinner);
        unitSpinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if(parent.getId() == R.id.typeSpinner) {
            this.type = pos;
            refreshUnit();
        }
        else {
            this.unit = pos;
        }
        TextView resultHeader = (TextView) findViewById(R.id.resultsHeader);
        if(resultHeader.getVisibility() == View.VISIBLE) doConvertion(view);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    private void refreshUnit() {
        Resources res = getResources();
        ArrayAdapter<CharSequence> adapter;
        switch (this.type) {
            case 1:
                adapter = ArrayAdapter.createFromResource(this, R.array.massUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
            case 2:
                adapter = ArrayAdapter.createFromResource(this, R.array.areaUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
            case 3:
                adapter = ArrayAdapter.createFromResource(this, R.array.volumeUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
            case 4:
                adapter = ArrayAdapter.createFromResource(this, R.array.temperatureUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
            case 5:
                adapter = ArrayAdapter.createFromResource(this, R.array.pressureUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
            case 6:
                adapter = ArrayAdapter.createFromResource(this, R.array.timeUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
            case 7:
                adapter = ArrayAdapter.createFromResource(this, R.array.energyUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
            case 8:
                adapter = ArrayAdapter.createFromResource(this, R.array.powerUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
            case 9:
                adapter = ArrayAdapter.createFromResource(this, R.array.speedUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
            case 10:
                adapter = ArrayAdapter.createFromResource(this, R.array.dataStorageUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
            case 11:
                adapter = ArrayAdapter.createFromResource(this, R.array.dataStorageOldUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
            default:
                adapter = ArrayAdapter.createFromResource(this, R.array.lengthUnitsLong, R.layout.support_simple_spinner_dropdown_item);
                break;
        }
        this.unit = 0;
        Spinner unitSpinner = (Spinner) findViewById(R.id.unitSpinner);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);
    }

    public void clearInputs(View view) {
        EditText input = (EditText) findViewById(R.id.in);
        input.setText("");
    }

    public void lessDigits(View view) {
        TextView digitsBar = (TextView) findViewById(R.id.digitsBar);
        int max = Integer.parseInt(digitsBar.getText().toString());
        if(max > 1) {
            max--;
            DecimalFormat fmt = new DecimalFormat("#");
            digitsBar.setText(fmt.format(max));
            TextView out = (TextView) findViewById(R.id.resultsHeader);
            if(out.getVisibility() == View.VISIBLE) this.doConvertion(findViewById(R.id.calculateButton));
        }
    }

    public void moreDigits(View view) {
        TextView digitsBar = (TextView) findViewById(R.id.digitsBar);
        int max = Integer.parseInt(digitsBar.getText().toString());
        if(max < 40) {
            max++;
            DecimalFormat fmt = new DecimalFormat("#");
            digitsBar.setText(fmt.format(max));
            TextView out = (TextView) findViewById(R.id.resultsHeader);
            if(out.getVisibility() == View.VISIBLE) this.doConvertion(findViewById(R.id.calculateButton));
        }
    }

    public void doConvertion(View view) {
        BigDecimal value = getInputBigDecimal(R.id.in);
        BigDecimal valueNeutral, valueOut;
        TextView out = (TextView) findViewById(R.id.resultsHeader);
        out.setVisibility(View.VISIBLE);
        Spinner unitSpinner = (Spinner) findViewById(R.id.unitSpinner);
        String[] shortNames;
        Resources res = getResources();
        switch(this.type) {
            case 1: shortNames = res.getStringArray(R.array.massUnits); break;
            case 2: shortNames = res.getStringArray(R.array.areaUnits); break;
            case 3: shortNames = res.getStringArray(R.array.volumeUnits); break;
            case 4: shortNames = res.getStringArray(R.array.temperatureUnits); break;
            case 5: shortNames = res.getStringArray(R.array.pressureUnits); break;
            case 6: shortNames = res.getStringArray(R.array.timeUnits); break;
            case 7: shortNames = res.getStringArray(R.array.energyUnits); break;
            case 8: shortNames = res.getStringArray(R.array.powerUnits); break;
            case 9: shortNames = res.getStringArray(R.array.speedUnits); break;
            case 10: shortNames = res.getStringArray(R.array.dataStorageUnits); break;
            case 11: shortNames = res.getStringArray(R.array.dataStorageOldUnits); break;
            default: shortNames = res.getStringArray(R.array.lengthUnits); break;
        }
        out.setText(Html.fromHtml(value.toString() + prepareUnitName(shortNames[this.unit], type) + " " + res.getString(R.string.isEqual)));
        TextView digitsBar = (TextView) findViewById(R.id.digitsBar);
        Converter conwerter = new Converter(Integer.parseInt(digitsBar.getText().toString()));
        switch (type) {
            case 0: valueNeutral = conwerter.convertToMeter(unit, value); break;
            case 1: valueNeutral = conwerter.convertToKilogram(unit, value); break;
            case 2: valueNeutral = conwerter.convertToSquareMeter(unit, value); break;
            case 3: valueNeutral = conwerter.convertToLiter(unit, value); break;
            case 4: valueNeutral = conwerter.convertToCelsius(unit, value); break;
            case 5: valueNeutral = conwerter.convertToPascal(unit, value); break;
            case 6: valueNeutral = conwerter.convertToSecond(unit, value); break;
            case 7: valueNeutral = conwerter.convertToJoule(unit, value); break;
            case 8: valueNeutral = conwerter.convertToWatt(unit, value); break;
            case 9: valueNeutral = conwerter.convertToMeterPerSecond(unit, value); break;
            case 10: valueNeutral = conwerter.convertToTebibyte(unit, value); break;
            case 11: valueNeutral = conwerter.convertToOldTerabyte(unit, value); break;
            default: valueNeutral = new BigDecimal("0");
        }
        LinearLayout results = (LinearLayout) findViewById(R.id.results);
        results.removeAllViews();
        int j = 0;
        for(int i = 0; i < unitSpinner.getAdapter().getCount(); i++) {
            if(i != this.unit) {
                switch(type) {
                    case 0: valueOut = conwerter.convertFromMeter(i, valueNeutral); break;
                    case 1: valueOut = conwerter.convertFromKilogram(i, valueNeutral); break;
                    case 2: valueOut = conwerter.convertFromSquareMeter(i, valueNeutral); break;
                    case 3: valueOut = conwerter.convertFromLiter(i, valueNeutral); break;
                    case 4: valueOut = conwerter.convertFromCelsius(i, valueNeutral); break;
                    case 5: valueOut = conwerter.convertFromPascal(i, valueNeutral); break;
                    case 6: valueOut = conwerter.convertFromSecond(i, valueNeutral); break;
                    case 7: valueOut = conwerter.convertFromJoule(i, valueNeutral); break;
                    case 8: valueOut = conwerter.convertFromWatt(i, valueNeutral); break;
                    case 9: valueOut = conwerter.convertFromMeterPerSecond(i, valueNeutral); break;
                    case 10: valueOut = conwerter.convertFromTebibyte(i, valueNeutral); break;
                    case 11: valueOut = conwerter.convertFromOldTerabyte(i, valueNeutral); break;
                    default: valueOut = new BigDecimal("0");
                }
                if(j % 2 == 0) out = new TextView(new ContextThemeWrapper(this, R.style.converterBar2), null, 0);
                else out = new TextView(new ContextThemeWrapper(this, R.style.converterBar), null, 0);
                String name = this.prepareUnitName(unitSpinner.getAdapter().getItem(i).toString(), this.type);
                out.setText(Html.fromHtml(name + ": " + valueOut.toPlainString()));
                results.addView(out);
                j++;

                if(j % 2 == 0) out = new TextView(new ContextThemeWrapper(this, R.style.converterBar2), null, 0);
                else out = new TextView(new ContextThemeWrapper(this, R.style.converterBar), null, 0);
                name = this.prepareUnitName(unitSpinner.getAdapter().getItem(i).toString(), this.type);
                out.setText(Html.fromHtml(name + ": " + conwerter.round(valueOut.toPlainString())));
                results.addView(out);
                j++;
            }
        }
    }
}