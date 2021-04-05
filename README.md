# Note App Android Room Kotlin
![Web 1920 – 1](https://user-images.githubusercontent.com/51102459/113280500-92ffe080-930e-11eb-8a3b-1d8162da042a.png)
![Web 1920 – 2](https://user-images.githubusercontent.com/51102459/113280504-94310d80-930e-11eb-88e3-cbcb735eefe2.png)
![Web 1920 – 3](https://user-images.githubusercontent.com/51102459/113280507-94c9a400-930e-11eb-85fb-f9e5c1b55188.png)

## App Review
https://user-images.githubusercontent.com/51102459/113279315-22a48f80-930d-11eb-8fe9-da5af8f2c6e8.mp4

# Build.gradle (app)
  plugins
  id 'kotlin-kapt'
  // Room Components
  implementation "androidx.room:room-runtime:2.2.6"
  kapt "androidx.room:room-compiler:2.2.6"
  implementation "androidx.room:room-ktx:2.2.6"
  androidTestImplementation "androidx.room:room-testing:2.2.6"
  // Lifecycle components
  implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
  implementation "androidx.lifecycle:lifecycle-common-java8:2.3.1"
  implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
  // Kotlin components
  implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.21"
  api "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1"
  api "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1"
  // Circle image
  implementation 'de.hdodenhof:circleimageview:3.1.0'

## UI Design References by  Johny vino™
> https://dribbble.com/shots/6651598-Audio-Notes
