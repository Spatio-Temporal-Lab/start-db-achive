# Contributing to START-DB

### Running environment setup

Running environment need to be setup before build or test START-DB.

1. Please follow [Docker Setup](docker/local/README.md) and confirm
2. init mysql schema

```shell
mvn test exec:java -f start-db-test/start-db-test-embedded-mysql/pom.xml
```

then

```
mvn clean package
```

run successfully.

### Importing the project into IntelliJ IDEA

START-DB builds using Java 8. When importing into IntelliJ you will need to define an appropriate SDK.or more details on
defining an SDK in IntelliJ please refer
to [their documentation](https://www.jetbrains.com/help/idea/sdk.html#define-sdk).

You can import the START-DB project into IntelliJ IDEA via:

- Select **File > Open**
- In the subsequent dialog navigate to the root `pom.xml` file
- In the subsequent dialog select **Open as Project**

#### Checkstyle

You can install [Checkstyle] plugin to check the START-DB code.

1. Open **File > Settings> Tools > CheckStyle**
2. Select CheckStyle version `9.3`
3. Import CheckStyle file `conventions/checkstyle.xml`
4. Click "OK"

### Formatting

START-DB code is automatically formatted with [spotless], backed by the Eclipse formatter. You can do the same in
IntelliJ with the [Eclipse Code Formatter] so that you can apply the correct formatting directly in your IDE.

**Java Code Style**

1. Open **File > Settings/Preferences > Plugins**
2. Install **Adapter for Eclipse Code Formatter** from marketplace
3. Open **File > Settings/Preferences > Adapter for Eclipse Code Formatter**
4. Click "Use the Eclipse Code Formatter"
5. Use default "Boundled Eclipse"
6. Under "Eclipse formatter config", select "Eclipse workspace/project folder or config file"
7. Click "Browse", and navigate to the file `conventions/eclipse-formatter.xml`
8. **IMPORTANT** - make sure "Optimize Imports" is **NOT** selected.
9. Click "OK"

**Scala Code Style**

1. Open **File > Settings/Preferences > Code Style > Scala**
2. Change **Formatter** to `scalafmt`
3. Set **Configguration** to file `conventions/scalafmt.conf`
4. Click "OK"

Formatting will be triggered when running command `mvn package`. Or you can do format only with
command `mvn spotless:apply`.

[checkstyle]: https://plugins.jetbrains.com/plugin/1065-checkstyle-idea

[spotless]: https://github.com/diffplug/spotless

[eclipse code formatter]: https://plugins.jetbrains.com/plugin/6546-eclipse-code-formatter
