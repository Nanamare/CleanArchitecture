# Android Clean Architecture Study

This is a sample project for studying clean architecture & simple movie recommendation and search app.
There are some parts that are not properly understood, and are implemented experimentally.
Base architecture is mvvm (Google blueprint)

### Display

![화면-기록-2020-04-25-오전-2 42 59](https://user-images.githubusercontent.com/17498974/80241146-109e8380-869e-11ea-911a-91dfba7dbe43.gif)

![화면-기록-2020-04-25-오전-2 02 06](https://user-images.githubusercontent.com/17498974/80239438-370eef80-869b-11ea-91c5-30da654bf7af.gif)


### Architecture
<img width="1091" alt="스크린샷 2020-04-25 오전 2 07 13" src="https://user-images.githubusercontent.com/17498974/80239052-8274ce00-869a-11ea-8c48-986b48f3eb17.png">


### Feature Tech & Library [Link](https://github.com/Nanamare/CleanArchitecture/blob/master/build.gradle)
- Minimum SDK level 21
- Target SDK level 29
- [Kotlin](https://kotlinlang.org/) based + RxJava for asynchronous task
- Android JetPack
  - LiveData 
  - Lifecycle 
  - Paging
  - ViewModel 
- Architecture
  - Clean Architecture base on MVVM (Model - View - ViewModel - DataBinding)
  - Repository pattern
  - [Koin](https://github.com/InsertKoinIO/koin) - dependency injection
    - Scope, ViewModel, Fragment, Ext
- [Retrofit2 & Gson](https://github.com/square/retrofit)
- [OkHttp3](https://github.com/square/okhttp)
- [Glide](https://github.com/bumptech/glide)
- CircleImageView
- ExpendableTextview
- ExoPlayer
- [Lottie](https://github.com/airbnb/lottie-android)
- [RxBinding](https://github.com/JakeWharton/RxBinding)

