import 'package:flutter/material.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

class NativeIOS extends StatefulWidget {
  const NativeIOS({super.key});

  @override
  State<NativeIOS> createState() => _NativeIOSState();
}

class _NativeIOSState extends State<NativeIOS> {
  @override
  Widget build(BuildContext context) {
    // This is used in the platform side to register the view.
    const String viewType = '<platform-view-type>';
    // Pass parameters to the platform side.
    final Map<String, dynamic> creationParams = <String, dynamic>{};

    return UiKitView(
      viewType: viewType,
      layoutDirection: TextDirection.ltr,
      creationParams: creationParams,
      creationParamsCodec: const StandardMessageCodec(),
    );
  }
}
