# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /home/mohsen/NEWANDROID/Tools/android-sdk-linux/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
    # Keep - Library. Keep all public and protected classes, fields, and methods.
-dontshrink
-dontwarn  ir.easyapp.android.easyauth.*
-dontnote
-keep class ir.easyapp.android.easyauth.EasyAuth {
    void getAuthKey(android.support.v7.app.AppCompatActivity,ir.easyapp.android.easyauth.OnAuthKeyReadyListener);
}
-keep class ir.easyapp.android.easyauth.OnAuthKeyReadyListener {
    void *(***);
}

