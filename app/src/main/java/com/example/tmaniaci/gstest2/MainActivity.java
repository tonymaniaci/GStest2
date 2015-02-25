package com.example.tmaniaci.gstest2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Slot open_slot = new Slot();
        open_slot.slot_start = "10:00";
        open_slot.slot_end = "11:00";
        open_slot.slot_minutes = 60;
        open_slot.no_of_slots = 1;

        Gson gson = new Gson();

        String ops = gson.toJson(open_slot);

        Log.d("*** js ***", ops);

        JsonObject jsonObject = (new JsonParser()).parse(ops).getAsJsonObject();

        String start = jsonObject.get("slot_start").getAsString();

        Log.d("*** start ***", start);



    }

    public class Slot {
        private String slot_start;
        private String slot_end;
        private int slot_minutes;
        private int no_of_slots;

        public Slot(){
        }

        public Slot(String slot_start, String slot_end, int slot_minutes, int no_of_slots) {
            this.slot_start = slot_start;
            this.slot_minutes = slot_minutes;
            this.slot_end = slot_end;
            this.no_of_slots = no_of_slots;
        }

        public String getSlot_start() {
            return slot_start;
        }

        public void setSlot_start(String slot_start) {
            this.slot_start = slot_start;
        }

        public String getSlot_end() {
            return slot_end;
        }

        public void setSlot_end(String slot_end) {
            this.slot_end = slot_end;
        }

        public int getSlot_minutes() {
            return slot_minutes;
        }

        public void setSlot_minutes(int slot_minutes) {
            this.slot_minutes = slot_minutes;
        }

        public int getNo_of_slots() {
            return no_of_slots;
        }

        public void setNo_of_slots(int no_of_slots) {
            this.no_of_slots = no_of_slots;
        }
    }

    private class BlockedTimes {
        private int day_of_week;
        private Time start_of_day;
        private Time end_of_day;
    }




}