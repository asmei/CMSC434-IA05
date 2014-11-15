package me.ambily.cmsc434clock1;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private Handler _uiHandler = new Handler();
    private Timer _timerCount = new Timer();
   // private TimerTask timerTask;

    SharedPreferences prefs;

    private String updated_timeconvention;
    private String _prefTimezone;
    private Calendar calendar;
    TimeZone _timeZone;

    String amorpm = "";
    boolean is12hr = true;
    boolean showSecs = false;
    int updated_hour;
    private int _hour;
    private int _min;
    private int _sec;

    private int _year;
    private String _month;
    private int _dayOfMonth;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.registerOnSharedPreferenceChangeListener(this);


        _prefTimezone = prefs.getString("timezone", "EST");
        updated_timeconvention = prefs.getString("timeconvention", "12");
        setIs12hr();
        showSecs = prefs.getBoolean("showsecs", false);

        resetPreferences();
        incrementTime();
    }

    public void setIs12hr() {
        if (updated_timeconvention.equals("12")) {
            is12hr = true;
        } else if (updated_timeconvention.equals("24")) {
            is12hr = false;
        }
    }

    public void resetPreferences() {
        initializeCal();
        initializeDay();
        initializeTime();
    }

    public void initializeCal() {
        _timeZone = TimeZone.getTimeZone(_prefTimezone);
        calendar = new GregorianCalendar(_timeZone);

        TextView timeLabel = (TextView) findViewById(R.id.timezone);
        timeLabel.setText(_timeZone.getID());
    }

    public void initializeDay() {
        _year = calendar.get(Calendar.YEAR);
        _month = new SimpleDateFormat("MMM").format(calendar.getTime());
        _dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        TextView dateLabel = (TextView) findViewById(R.id.dateToday);
        dateLabel.setText(_dayOfMonth + " " + _month + ", " + _year);
    }

    public void initializeTime() {
        _hour = calendar.get(Calendar.HOUR_OF_DAY);
        _min = calendar.get(Calendar.MINUTE);
        _sec = calendar.get(Calendar.SECOND);
    }


    public void incrementTime() {
        _timerCount.schedule(new TimerTask() {

            public void run() {
                _sec++;
                if (_sec > 59) {
                    _sec = 0;
                    _min++;
                    if (_min > 59) {
                        _min = 0;
                        _hour++;
                        if (_hour > 24) {
                            _hour = 1;
                            //reinitialize date
                            initializeDay();
                        }
                    }
                }
                updated_hour = _hour;
                if (is12hr) {
                    if (_hour > 12) {
                        updated_hour = _hour - 12;
                        amorpm = "PM";
                    } else {
                        amorpm = "AM";
                    }
                    if (_hour < 1) {
                        updated_hour = 12;
                    }
                } else {
                    amorpm = "";
                }

                // Use the handler to marshal/invoke the Runnable code on the UI thread
                _uiHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        TextView timeLabel = (TextView) findViewById(R.id.timeNow);
                        timeLabel.setText(String.format("%02d", updated_hour) + ":");
                        timeLabel.append(String.format("%02d", _min) );
                        if (showSecs == true) {
                            timeLabel.append(String.format(":%02d", _sec));
                        } else {
                            timeLabel.append("");
                        }
                        TextView amorpmLabel = (TextView) findViewById(R.id.amorpm);
                        amorpmLabel.setText(amorpm);
                    }
                });
            }
        }, 0, 1000);
    }


    /* Getting new preferences */
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("timezone")) {
            _prefTimezone = sharedPreferences.getString(key, "EST");
            resetPreferences();
        } else if (key.equals("timeconvention")) {
            updated_timeconvention = sharedPreferences.getString(key, "12");
            setIs12hr();
            resetPreferences();
        } else if (key.equals("showsecs")) {
            showSecs = prefs.getBoolean("showsecs", false);
            resetPreferences();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.preferences:
                Intent intent = new Intent();
                intent.setClassName(this, "me.ambily.cmsc434clock1.MyPreferenceActivity");
                startActivity(intent);
                return true;

            case R.id.clock:
                Intent intent1 = new Intent();
                intent1.setClassName(this, "me.ambily.cmsc434clock1.MainActivity");
                startActivity(intent1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void openPreferences() {
        Intent intent = new Intent();
        intent.setClassName(this, "me.ambily.cmsc434clock1.MyPreferenceActivity");
        startActivity(intent);
    }
}



