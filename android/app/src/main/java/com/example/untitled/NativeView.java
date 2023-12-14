package com.example.untitled;
//
//
//class NativeView implements PlatformView {
//    @NonNull private final TextView textView;
//
//    private MapView mapView;
//       NativeView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams) {
//        textView = new TextView(context);
//        textView.setTextSize(32);
//        textView.setBackgroundColor(Color.rgb(255, 255, 255));
//        textView.setText("Rendered Venu on a native Android view (id: " + id + ")");
//    }
//
//    @NonNull
//    @Override
//    public View getView() {
//        return textView;
//    }
//}

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mapbox.maps.MapView;
import com.mapbox.navigation.ui.maps.location.NavigationLocationProvider;
import com.mapbox.navigation.ui.maps.route.line.api.MapboxRouteLineApi;
import com.mapbox.navigation.ui.maps.route.line.api.MapboxRouteLineView;

import java.util.Map;

import io.flutter.Log;
import io.flutter.plugin.platform.PlatformView;

class NativeView implements PlatformView {

    MapView mapView;
    MaterialButton setRoute;
    FloatingActionButton focusLocationBtn;
    private final NavigationLocationProvider navigationLocationProvider = new NavigationLocationProvider();
    private MapboxRouteLineView routeLineView;
    private MapboxRouteLineApi routeLineApi;

    //private final TextView textView;

    private final Button button;
    private final RelativeLayout layout;

    @RequiresApi(api = Build.VERSION_CODES.O)
    NativeView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams) {
//        textView = new TextView(context);
//        textView.setTextSize(32);
//        textView.setBackgroundColor(Color.rgb(255, 255, 255));
//        textView.setText("Rendered on a native Android view (id: " + id + ")");

        //myButton = findViewById(R.id.myButton);

        layout = new RelativeLayout(context);

        // Set layout parameters for the button
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        // Align the button to the top of the view
        buttonParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        button = new Button(context);
        button.setText("Click - me");
        button.setTextSize(32);
        button.setVisibility(View.VISIBLE);


        button.setBackgroundColor(Color.rgb(255,20,2));
        //setButtonTextColor(Color.WHITE);

        button.setLayoutParams(buttonParams);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("NativeView", "Button clicked!");

                // Start a new activity when the button is clicked
                Intent intent = new Intent(context, SecondActivity.class);
                context.startActivity(intent);
            }
        });

        // Add the button to the RelativeLayout only if it hasn't been added before
        if (button.getParent() == null) {
            layout.addView(button);
        }

        // Return the RelativeLayout as the view
        //return layout;

    }
//
//    @Nullable
//    @Override
//    public View getView() {
//        return null;
//    }
//
//    @Nullable
//    @Override
//    public View getView() {
//        return button;
//    }

    @Override
    public void onFlutterViewAttached(@NonNull View flutterView) {
        PlatformView.super.onFlutterViewAttached(flutterView);
    }

    @Override
    public void onFlutterViewDetached() {
        PlatformView.super.onFlutterViewDetached();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onInputConnectionLocked() {
        PlatformView.super.onInputConnectionLocked();
    }

    @Override
    public void onInputConnectionUnlocked() {
        PlatformView.super.onInputConnectionUnlocked();
    }

    @Override
    public View getView() {
        return layout;
    }
}
