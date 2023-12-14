import 'package:flutter/material.dart';

import 'package:untitled/native_view_example.dart';
import 'package:untitled/native_view_ios.dart';
import 'package:untitled/navigation.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("NATIVE"),
        centerTitle: true,
        backgroundColor: Colors.red,
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Center(
            child: ElevatedButton(
                onPressed: ()
                {
                  print("pressed");
                  // Navigator.of(context).push(
                  //     MaterialPageRoute(builder: (context) => NativeFluttter()));
                  // Navigator.of(context).push(
                  //   MaterialPageRoute(builder: (context)=> NativeIOS())
                  // );
                  Navigator.of(context).push(
                      MaterialPageRoute(builder: (context)=> SampleNavigationApp())
                  );
                  },
                child: Text("Press")),
          )
        ],
      ),
    );
  }
}

