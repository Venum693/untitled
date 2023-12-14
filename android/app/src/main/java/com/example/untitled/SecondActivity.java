package com.example.untitled;


import android.location.LocationListener;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineCallback;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.common.location.Location;
import com.mapbox.maps.MapView;
import com.mapbox.maps.MapboxMap;
import com.mapbox.maps.Style;
import com.mapbox.navigation.ui.maps.internal.ui.LocationComponent;

import java.util.List;


public class SecondActivity extends AppCompatActivity implements OnMapReadyCallback, LocationEngineCallback, LocationListener,PermissionsListener {

    private MapView mapView;

    private MapboxMap map;

    private PermissionsManager permissionsManager;

    private LocationEngine locationEngine;

    private LocationComponent locationComponent;

    private Location originloaction;



    //DISPLAYING MAPS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView = findViewById(R.id.mapView);
        if (mapView != null) {
            mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = MapboxMap;
    }

    @Override
    public void onPermissionResult(boolean granted) {

    }


    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }



    @Override
    public void onSuccess(Object result) {

    }


    @Override
    protected void onStart() {
        super.onStart();
        if (mapView != null) {
            mapView.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mapView != null) {
            mapView.onStop();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (mapView != null) {
            mapView.onLowMemory();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mapView != null) {
            mapView.onDestroy();
        }
    }



    @Override
    public void onFailure(@NonNull Exception exception) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onLocationChanged(@NonNull android.location.Location location) {

    }

    // NAVIGATION

//    //MapView mapView;
//    MaterialButton setRoute;
//    FloatingActionButton focusLocationBtn;
//    private final NavigationLocationProvider navigationLocationProvider = new NavigationLocationProvider();
//    private MapboxRouteLineView routeLineView;
//    private MapboxRouteLineApi routeLineApi;
//    private final LocationObserver locationObserver;
//
//    {
//        locationObserver = new LocationObserver() {
//            @Override
//            public void onNewRawLocation(@NonNull Location location) {
//
//            }
//
//            @Override
//            public void onNewLocationMatcherResult(@NonNull LocationMatcherResult locationMatcherResult) {
//                Location location = locationMatcherResult.getEnhancedLocation();
//                navigationLocationProvider.changePosition(location, locationMatcherResult.getKeyPoints(), null, null);
//                if (focusLocation) {
//                    updateCamera(Point.fromLngLat(location.getLongitude(), location.getLatitude()), (double) location.getBearing());
//                }
//            }
//        };
//    }
//
//    private final RoutesObserver routesObserver = new RoutesObserver() {
//        @Override
//        public void onRoutesChanged(@NonNull RoutesUpdatedResult routesUpdatedResult) {
//            routeLineApi.setNavigationRoutes(routesUpdatedResult.getNavigationRoutes(), new MapboxNavigationConsumer<Expected<RouteLineError, RouteSetValue>>() {
//                @Override
//                public void accept(Expected<RouteLineError, RouteSetValue> routeLineErrorRouteSetValueExpected) {
//                    Style style = mapView.getMapboxMap().getStyle();
//                    if (style != null) {
//                        routeLineView.renderRouteDrawData(style, routeLineErrorRouteSetValueExpected);
//                    }
//                }
//            });
//        }
//    };
//    boolean focusLocation = true;
//    private MapboxNavigation mapboxNavigation;
//    private void updateCamera(Point point, Double bearing) {
//        MapAnimationOptions animationOptions = new MapAnimationOptions.Builder().duration(1500L).build();
//        CameraOptions cameraOptions = new CameraOptions.Builder().center(point).zoom(18.0).bearing(bearing).pitch(45.0)
//                .padding(new EdgeInsets(1000.0, 0.0, 0.0, 0.0)).build();
//
//        getCamera(mapView).easeTo(cameraOptions, animationOptions);
//    }
//    private final OnMoveListener onMoveListener = new OnMoveListener() {
//        @Override
//        public void onMoveBegin(@NonNull MoveGestureDetector moveGestureDetector) {
//            focusLocation = false;
//            getGestures(mapView).removeOnMoveListener(this);
//            focusLocationBtn.show();
//        }
//
//        @Override
//        public boolean onMove(@NonNull MoveGestureDetector moveGestureDetector) {
//            return false;
//        }
//
//        @Override
//        public void onMoveEnd(@NonNull MoveGestureDetector moveGestureDetector) {
//
//        }
//    };
//    private final ActivityResultLauncher<String> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
//        @Override
//        public void onActivityResult(Boolean result) {
//            if (result) {
//                Toast.makeText(SecondActivity.this, "Permission granted! Restart this app", Toast.LENGTH_SHORT).show();
//            }
//        }
//    });
//
//    private MapboxSpeechApi speechApi;
//    private MapboxVoiceInstructionsPlayer mapboxVoiceInstructionsPlayer;
//
//    private MapboxNavigationConsumer<Expected<SpeechError, SpeechValue>> speechCallback = new MapboxNavigationConsumer<Expected<SpeechError, SpeechValue>>() {
//        @Override
//        public void accept(Expected<SpeechError, SpeechValue> speechErrorSpeechValueExpected) {
//            speechErrorSpeechValueExpected.fold(new Expected.Transformer<SpeechError, Unit>() {
//                @NonNull
//                @Override
//                public Unit invoke(@NonNull SpeechError input) {
//                    mapboxVoiceInstructionsPlayer.play(input.getFallback(), voiceInstructionsPlayerCallback);
//                    return Unit.INSTANCE;
//                }
//            }, new Expected.Transformer<SpeechValue, Unit>() {
//                @NonNull
//                @Override
//                public Unit invoke(@NonNull SpeechValue input) {
//                    mapboxVoiceInstructionsPlayer.play(input.getAnnouncement(), voiceInstructionsPlayerCallback);
//                    return Unit.INSTANCE;
//                }
//            });
//        }
//    };
//
//    private MapboxNavigationConsumer<SpeechAnnouncement> voiceInstructionsPlayerCallback = new MapboxNavigationConsumer<SpeechAnnouncement>() {
//        @Override
//        public void accept(SpeechAnnouncement speechAnnouncement) {
//            speechApi.clean(speechAnnouncement);
//        }
//    };
//
//    VoiceInstructionsObserver voiceInstructionsObserver = new VoiceInstructionsObserver() {
//        @Override
//        public void onNewVoiceInstructions(@NonNull VoiceInstructions voiceInstructions) {
//            speechApi.generate(voiceInstructions, speechCallback);
//        }
//    };
//
//    private boolean isVoiceInstructionsMuted = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
//
//
//        mapView = findViewById(R.id.mapView);
//        focusLocationBtn =findViewById(R.id.focusLocation);
//        setRoute = findViewById(R.id.focusLocation);
//
//        MapboxRouteLineOptions options = new MapboxRouteLineOptions.Builder(this).withRouteLineResources(new RouteLineResources.Builder().build())
//                .withRouteLineBelowLayerId(LocationComponentConstants.LOCATION_INDICATOR_LAYER).build();
//        routeLineView = new MapboxRouteLineView(options);
//        routeLineApi = new MapboxRouteLineApi(options);
//
//        speechApi = new MapboxSpeechApi(SecondActivity.this, getString(R.string.mapbox_access_token), Locale.US.toLanguageTag());
//        mapboxVoiceInstructionsPlayer = new MapboxVoiceInstructionsPlayer(SecondActivity.this, Locale.US.toLanguageTag());
//
//        NavigationOptions navigationOptions = new NavigationOptions.Builder(this).accessToken(getString(R.string.mapbox_access_token)).build();
//
//        MapboxNavigationApp.setup(navigationOptions);
//        mapboxNavigation = new MapboxNavigation(navigationOptions);
//
//        mapboxNavigation.registerRoutesObserver(routesObserver);
//        mapboxNavigation.registerLocationObserver(locationObserver);
//        mapboxNavigation.registerVoiceInstructionsObserver(voiceInstructionsObserver);
//
//        MapboxSoundButton soundButton = findViewById(R.id.soundButton);
//        soundButton.unmute();
//        soundButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                isVoiceInstructionsMuted = !isVoiceInstructionsMuted;
//                if (isVoiceInstructionsMuted) {
//                    soundButton.muteAndExtend(1500L);
//                    mapboxVoiceInstructionsPlayer.volume(new SpeechVolume(0f));
//                } else {
//                    soundButton.unmuteAndExtend(1500L);
//                    mapboxVoiceInstructionsPlayer.volume(new SpeechVolume(1f));
//                }
//            }
//        });
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            if (ActivityCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
//                activityResultLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
//            }
//        }
//
//        if (ActivityCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            activityResultLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
//            activityResultLauncher.launch(Manifest.permission.ACCESS_COARSE_LOCATION);
//        } else {
//            mapboxNavigation.startTripSession();
//        }
//
//        focusLocationBtn.hide();
//        LocationComponentPlugin locationComponentPlugin = getLocationComponent(mapView);
//        getGestures(mapView).addOnMoveListener(onMoveListener);
//
//        setRoute.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(SecondActivity.this, "Please select a location in map", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        mapView.getMapboxMap().loadStyleUri(Style.SATELLITE, new Style.OnStyleLoaded() {
//            @Override
//            public void onStyleLoaded(@NonNull Style style) {
//                mapView.getMapboxMap().setCamera(new CameraOptions.Builder().zoom(20.0).build());
//                locationComponentPlugin.setEnabled(true);
//                locationComponentPlugin.setLocationProvider(navigationLocationProvider);
//                getGestures(mapView).addOnMoveListener(onMoveListener);
//                locationComponentPlugin.updateSettings(new Function1<LocationComponentSettings, Unit>() {
//                    @Override
//                    public Unit invoke(LocationComponentSettings locationComponentSettings) {
//                        locationComponentSettings.setEnabled(true);
//                        locationComponentSettings.setPulsingEnabled(true);
//                        return null;
//                    }
//                });
//                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.location_pin);
//                AnnotationPlugin annotationPlugin = AnnotationPluginImplKt.getAnnotations(mapView);
//                PointAnnotationManager pointAnnotationManager = PointAnnotationManagerKt.createPointAnnotationManager(annotationPlugin, mapView);
//                addOnMapClickListener(mapView.getMapboxMap(), new OnMapClickListener() {
//                    @Override
//                    public boolean onMapClick(@NonNull Point point) {
//                        pointAnnotationManager.deleteAll();
//                        PointAnnotationOptions pointAnnotationOptions = new PointAnnotationOptions().withTextAnchor(TextAnchor.CENTER).withIconImage(bitmap)
//                                .withPoint(point);
//                        pointAnnotationManager.create(pointAnnotationOptions);
//
//                        setRoute.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                fetchRoute(point);
//                            }
//                        });
//                        return true;
//                    }
//                });
//                focusLocationBtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        focusLocation = true;
//                        getGestures(mapView).addOnMoveListener(onMoveListener);
//                        focusLocationBtn.hide();
//                    }
//                });
//            }
//        });
//    }
//
//    @SuppressLint("MissingPermission")
//    private void fetchRoute(Point point) {
//        LocationEngine locationEngine = LocationEngineProvider.getBestLocationEngine(SecondActivity.this);
//        locationEngine.getLastLocation(new LocationEngineCallback<LocationEngineResult>() {
//            @Override
//            public void onSuccess(LocationEngineResult result) {
//                Location location = result.getLastLocation();
//                setRoute.setEnabled(false);
//                setRoute.setText("Fetching route...");
//                RouteOptions.Builder builder = RouteOptions.builder();
//                Point origin = Point.fromLngLat(Objects.requireNonNull(location).getLongitude(), location.getLatitude());
//                builder.coordinatesList(Arrays.asList(origin, point));
//                builder.alternatives(false);
//                builder.profile(DirectionsCriteria.PROFILE_DRIVING);
//                builder.bearingsList(Arrays.asList(Bearing.builder().angle(location.getBearing()).degrees(45.0).build(), null));
//                applyDefaultNavigationOptions(builder);
//
//                mapboxNavigation.requestRoutes(builder.build(), new NavigationRouterCallback() {
//                    @Override
//                    public void onRoutesReady(@NonNull List<NavigationRoute> list, @NonNull RouterOrigin routerOrigin) {
//                        mapboxNavigation.setNavigationRoutes(list);
//                        focusLocationBtn.performClick();
//                        setRoute.setEnabled(true);
//                        setRoute.setText("Set route");
//                    }
//
//                    @Override
//                    public void onFailure(@NonNull List<RouterFailure> list, @NonNull RouteOptions routeOptions) {
//                        setRoute.setEnabled(true);
//                        setRoute.setText("Set route");
//                        Toast.makeText(SecondActivity.this, "Route request failed", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onCanceled(@NonNull RouteOptions routeOptions, @NonNull RouterOrigin routerOrigin) {
//
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//
//            }
//        });
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mapboxNavigation.onDestroy();
//        mapboxNavigation.unregisterRoutesObserver(routesObserver);
//        mapboxNavigation.unregisterLocationObserver(locationObserver);
//    }
}
