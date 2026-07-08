# Hello World RESTful Web Service Walkthrough

## HTTP Headers in REST APIs
When you make a request to a REST API like `http://localhost:8083/hello`, it is crucial to understand the metadata being exchanged between the client and the server. This metadata is transmitted through HTTP headers.

### 1. Using Chrome Developer Tools (Network Tab)
To view HTTP headers in a standard web browser like Google Chrome:
1. **Open Developer Tools:** Press `F12` or right-click anywhere on the page and select **Inspect**.
2. **Navigate to the Network Tab:** Click on the **Network** tab at the top of the Developer Tools panel.
3. **Make the Request:** Enter `http://localhost:8083/hello` in the URL bar and hit Enter.
4. **Inspect the Headers:** Look for the request named `hello` in the list of network activity. Click on it. On the right-hand panel, you will see a **Headers** tab.
    * **General:** Shows the Request URL, Request Method (GET), Status Code (200 OK).
    * **Response Headers:** Metadata sent *back* by the Spring Boot application (e.g., `Content-Type: text/plain;charset=UTF-8`, `Content-Length`, `Date`).
    * **Request Headers:** Metadata your browser sent *to* the server (e.g., `Accept`, `User-Agent`, `Host`).

### 2. Using Postman
Postman is a popular tool dedicated to API testing, providing an even clearer view of HTTP requests and responses.
1. **Create the Request:** Open Postman, set the HTTP method to **GET**, and enter `http://localhost:8083/hello` as the request URL.
2. **Send the Request:** Click the blue **Send** button.
3. **View Response Headers:** In the lower section where the response body ("Hello World!!") is displayed, click on the **Headers** tab.
    * This tab presents the Response Headers received from the server in a clean, key-value tabular format. You'll see headers similar to those in Chrome, such as `Content-Type: text/plain;charset=UTF-8` and `Keep-Alive`.
4. **View Request Headers (Optional):** You can also see exactly what Postman sent to the server by clicking the **Headers** tab in the *upper* section (the request configuration area) and looking at the "hidden" auto-generated headers (like `Postman-Token` or `Accept: */*`).
