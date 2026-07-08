# REST - Country Web Service Walkthrough

## 1. What happens in the controller method?
When a client (like Chrome or Postman) makes a `GET` request to `http://localhost:8083/country`, the Spring `DispatcherServlet` intercepts it and delegates the request to the `getCountryIndia()` method in `CountryController` because of the `@RequestMapping("/country")` annotation. 
Inside the method:
1. An `ApplicationContext` is created by reading `country.xml` from the classpath.
2. The `Country` bean (with ID "country") is retrieved from the context. This bean is configured in the XML with `code="IN"` and `name="India"`.
3. The method returns this Java `Country` object directly.

## 2. How the bean is converted into a JSON response?
Spring Boot Web relies on a library called **Jackson**. Because the controller class is annotated with `@RestController` (which is a combination of `@Controller` and `@ResponseBody`), Spring knows it needs to serialize the returned object into a format suitable for the HTTP response body.
Jackson inspects the `Country` object's standard getter methods (`getCode()`, `getName()`) and automatically serializes the Java object into a JSON string format:
```json
{
  "code": "IN",
  "name": "India"
}
```

## 3. HTTP Header Details in Network Tools

### Chrome Developer Tools (Network Tab)
To view HTTP headers in Google Chrome:
1. Open Developer Tools (`F12`), go to the **Network** tab.
2. Go to `http://localhost:8083/country`.
3. Click the `country` request and go to the **Headers** tab on the right.
   * **Response Headers:** You will notice `Content-Type: application/json`, which was automatically set by Spring/Jackson indicating the response is JSON.

### Postman
To view HTTP headers in Postman:
1. Make a **GET** request to `http://localhost:8083/country` and click **Send**.
2. Click the **Headers** tab in the lower panel (response area).
   * Just like in Chrome, you will clearly see `Content-Type: application/json`.
   * You can also inspect the Request headers in the upper panel to see what Postman is sending.
