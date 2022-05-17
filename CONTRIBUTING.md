# Contributing to Start DB

### Local Environment setup

Before build or test Start DB. Running environment need to be setup first.

Please follow [Docker Setup](docker/README.md) before following steps. And confirm

```
mvn clean package
```

run successfully.

### Importing the project into IntelliJ IDEA

Start DB builds using Java 8. When importing into IntelliJ you will need
to define an appropriate SDK.or more details
on defining an SDK in IntelliJ please refer to [their documentation](https://www.jetbrains.com/help/idea/sdk.html#define-sdk).

You can import the Start DB project into IntelliJ IDEA via:

- Select **File > Open**
- In the subsequent dialog navigate to the root `pom.xml` file
- In the subsequent dialog select **Open as Project**

#### Checkstyle

You can install [Checkstyle] plugin to check the Start DB code.

1. Open **File > Settings> Tools > CheckStyle**
2. Select CheckStyle version `9.3`
3. Import CheckStyle file `conventions/checkstyle.xml`
4. Click "OK"

### Formatting

Start DB code is automatically formatted with [spotless], backed by the Eclipse formatter. You can do the same in IntelliJ with the [Eclipse Code Formatter] so that you can apply the correct formatting directly in
your IDE. Or import it as IntelliJ code style setting.

1. Open **File > Settings/Preferences > Code Style > Java**
2. Gear icon > Import Scheme > Eclipse XML Profile
3. Navigate to the file `conventions/eclipse-formatter.xml`
4. Click "OK"

[checkstyle]: https://plugins.jetbrains.com/plugin/1065-checkstyle-idea
[spotless]: https://github.com/diffplug/spotless
[eclipse code formatter]: https://plugins.jetbrains.com/plugin/6546-eclipse-code-formatter
