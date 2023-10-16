rm -rf apkset.apks
adb uninstall com.example.unity3d
java -jar ~/Library/Android/sdk/tools/bundletool.jar build-apks --local-testing --bundle app/build/outputs/bundle/debug/app-debug.aab --output apkset.apks
java -jar ~/Library/Android/sdk/tools/bundletool.jar install-apks --apks apkset.apks
