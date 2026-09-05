package com.aether.client;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Switch;

public class MainActivity extends Activity {

    int bg = Color.rgb(15, 16, 20);
    int card = Color.rgb(25, 27, 33);
    int text = Color.WHITE;
    int sub = Color.rgb(160, 165, 175);

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        showMenu();
    }

    TextView label(String value, float size) {
        TextView v = new TextView(this);
        v.setText(value);
        v.setTextColor(text);
        v.setTextSize(size);
        v.setPadding(20, 16, 20, 16);
        return v;
    }

    GradientDrawable rounded(int color) {
        GradientDrawable g = new GradientDrawable();
        g.setColor(color);
        g.setCornerRadius(28);
        return g;
    }

    View module(String name, String description) {

        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setPadding(18, 12, 12, 12);
        box.setBackground(rounded(card));

        LinearLayout.LayoutParams bp =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        bp.setMargins(12, 8, 12, 8);
        box.setLayoutParams(bp);

        LinearLayout row = new LinearLayout(this);
        row.setGravity(Gravity.CENTER_VERTICAL);

        LinearLayout info = new LinearLayout(this);
        info.setOrientation(LinearLayout.VERTICAL);

        TextView title = label(name, 17);
        TextView desc = label(description, 12);
        desc.setTextColor(sub);

        info.addView(title);
        info.addView(desc);

        Switch sw = new Switch(this);
        sw.setChecked(false);

        row.addView(info, new LinearLayout.LayoutParams(
                0, -2, 1));

        row.addView(sw);

        box.addView(row);

        return box;
    }

    void showMenu() {

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(14, 20, 14, 20);
        root.setBackgroundColor(bg);

        TextView title = label("AETHER", 30);
        title.setTypeface(null, 1);

        TextView version = label(
                "CLIENT 3.0  •  ANDROID",
                12);

        version.setTextColor(sub);

        root.addView(title);
        root.addView(version);

        TextView performance =
                label("⚡  PERFORMANCE", 15);

        performance.setTypeface(null, 1);
        root.addView(performance);

        ScrollView scroll = new ScrollView(this);

        LinearLayout list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);

        list.addView(module(
                "Render Culling",
                "Reduce unnecessary rendering workload"));

        list.addView(module(
                "Entity Culling",
                "Skip entities that are outside the useful view"));

        list.addView(module(
                "Particle Optimizer",
                "Reduce particle rendering workload"));

        list.addView(module(
                "Animation Optimization",
                "Reduce unnecessary animation updates"));

        list.addView(module(
                "Smart FPS",
                "Prioritize stable frame time"));

        list.addView(module(
                "FPS Stabilizer",
                "Keep frame pacing more consistent"));

        TextView hud =
                label("📊  HUD", 15);

        hud.setTypeface(null, 1);
        list.addView(hud);

        list.addView(module(
                "FPS Counter",
                "Display current FPS"));

        list.addView(module(
                "Ping",
                "Display network latency"));

        list.addView(module(
                "CPS",
                "Display clicks per second"));

        TextView settings =
                label("⚙  SETTINGS", 15);

        settings.setTypeface(null, 1);
        list.addView(settings);

        list.addView(module(
                "Dark Theme",
                "Use the Aether dark interface"));

        scroll.addView(list);

        root.addView(
                scroll,
                new LinearLayout.LayoutParams(
                        -1, 0, 1));

        setContentView(root);
    }
}
