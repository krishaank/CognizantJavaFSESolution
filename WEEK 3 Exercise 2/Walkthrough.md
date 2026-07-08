# Spring Core - XML Configuration Walkthrough

## 1. Spring XML Bean Configuration
In our `country.xml` file, we configured a Spring bean. Here is a breakdown of the XML elements and attributes used:
* **`<bean>` tag**: This tag instructs the Spring IoC container to create and manage an object (a "bean").
* **`id` attribute**: A unique identifier for the bean within the Spring context (`"country"`). We use this ID to fetch the bean programmatically.
* **`class` attribute**: The fully qualified class name of the object to be instantiated (`"com.cognizant.springlearn.Country"`). Spring uses reflection to call the default constructor of this class.
* **`<property>` tag**: Used inside the `<bean>` tag to perform Setter Dependency Injection. It tells Spring to populate the fields of the bean.
* **`name` attribute**: Corresponds to the name of the variable/property in the Java class (`"code"`, `"name"`). Spring looks for the corresponding setter method (e.g., `setCode()`, `setName()`).
* **`value` attribute**: The actual primitive or String value to inject into the property (`"IN"`, `"India"`).

## 2. Spring IoC Containers
* **`ApplicationContext`**: This is the central interface of the Spring IoC (Inversion of Control) container. It is responsible for instantiating, configuring, and assembling beans. It is a superset of the older `BeanFactory` and provides additional enterprise-specific functionality (like resolving text messages from properties files and publishing application events).
* **`ClassPathXmlApplicationContext`**: This is a specific implementation of `ApplicationContext`. It is used to load XML configuration files that are located on the application's classpath (such as `country.xml` in our `src/main/resources` folder).

## 3. What Happens When `context.getBean()` is Invoked?
When `context.getBean("country", Country.class)` is executed, the following sequence occurs under the hood:
1. **Lookup**: The `ApplicationContext` searches its internal registry for a bean mapped to the ID `"country"`.
2. **Type Safety Validation**: Because we passed `Country.class` as the second argument, the container checks if the retrieved bean is actually of type `Country`. If it isn't, it throws a `BeanNotOfRequiredTypeException` early, saving us from a runtime `ClassCastException`.
3. **Retrieval**: By default, beans in Spring are singletons. The container checks if the `"country"` bean has already been instantiated.
   * If it was eager-initialized during startup (which is default for `ApplicationContext`), it simply returns the cached reference.
   * If it hasn't been instantiated yet (e.g. if it was marked as lazy), Spring uses reflection to call the empty constructor (`Inside Country Constructor.` is logged), then calls the setters (`Inside setCode.`, `Inside setName.` are logged), caches the bean, and finally returns the reference to our application code.
