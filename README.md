# Text Timer

<img align="right" width="120" src="img/sample-icon.png">

The project is a simple Android application with two activities developed in [Kotlin](https://github.com/JetBrains/kotlin) as a training task at the very start of the Android App Development Course by the [Technotrack](https://track.mail.ru/) educational project. The application represents a stopwatch which counts upwards from zero for measuring elapsed time showing the time in the way how we pronounce it, e.g. _forty four_ for 44. The application has international and russian interface depending on the system language and will be useful for English or Russian beginners or just for fun.

## Usage

Special Screen                       | Before Start                       | After Start
:-----------------------------------:|:----------------------------------:|:---------------------------------:
![Special Screen](img/sample-01.png) | ![Before Start](img/sample-02.png) | ![After Start](img/sample-03.png)

When you stop the timer, you can continue from the point of stopping by clicking on the start. At the expiration of 1000 seconds, the timer will stop, and then you can start again from zero.

## Building

Run [Gradle](https://github.com/gradle/gradle) from the ßroot directory of the project to build

``` bash
./gradlew build
```

After building is done, there will be two directories in app/build/outputs/apk with apk files for debug and release

## License

[MIT](LICENSE) © [alxiw](https://github.com/alxiw)