# xkcd Comics Application
A MVP to easy browse/view xkcd comics which contains the following feature:
  *Browsing throug the comics.
  *Search the comic number you need.
  *Navigate to comic explaination.
  *You can share a comic to otheres.
  *Add your favourite comic to a bookmark.
  
  Screenshots
-----------
<p align="center">
  <img src="https://github.com/siifii/xkcd-comics/blob/main/screenshots/Screenshot_1632037125.png" width="250">
  <img src="https://github.com/siifii/xkcd-comics/blob/main/screenshots/Screenshot_1632037199.png" width="250">
 <img src="https://github.com/siifii/xkcd-comics/blob/main/screenshots/Screenshot_1632037175.png" width="250">

</p>

* Tech-stack
    * [100% Kotlin](https://kotlinlang.org/) + [RxJava](https://github.com/ReactiveX/RxAndroid) - perform background operations
    * [Retrofit](https://square.github.io/retrofit/) - networking
    * [Jetpack](https://developer.android.com/jetpack)
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - in-app navigation
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
        * [Room](https://developer.android.com/jetpack/androidx/releases/room) - store offline cache
    * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - dependency injection
    * [Glide](https://github.com/bumptech/glide) - image loading library
* Modern Architecture
    * Clean Architecture (at feature module level)
    * Single activity architecture using [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started)
    * MVVM
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation))
    * [Android KTX](https://developer.android.com/kotlin/ktx) - Jetpack Kotlin extensions

## Author
[Kareem Alsaifi](https://github.com/siifii)
