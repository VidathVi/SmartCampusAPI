Part 1
Q1. JAX-RS Resource Lifecycle
By default, JAX-RS instantiates a new instance for every incoming request. The DataStore class stores the non-static variables created per request using static collections. Synchronisation is maintained using ConcurrentHashMaps, which support multi-threaded servers that can modify multiple static maps simultaneously.

Q2. The Hallmark of HATEOAS 
HATEOAS allows developers to navigate the API dynamically instead of hardcoding URLs. Static documentation can also become outdated. HATEOAS does not become outdated since it makes the API self-descriptive.
Part 2
Q1. IDs vs Full Objects
Returning only IDs reduces network bandwidth and the initial payload size, but if the client needs to display a list. It must issue a separate GET request for each ID, increasing overall latency. Returning full objects reduces the total number of HTTP calls, but it requires more bandwidth and results in a much larger payload. 

Q2. Multiple DELETE requests
When the server receives the first DELETE request, it removes the specified room from the server and returns a “204 No Content” response. If the server receives the same request again, it returns a “404 Not Found” response. Even if the HTTP status code is different, the state of the server is identical after both requests (the resource is gone). An operation is idempotent if multiple identical requests have the same effect as a single request.


Part 3
Q1. Data format mismatch
If data is sent using a format that isn’t JSON, the JAX-RS runtime rejects the request and returns a “HTTP 415 Unsupported Media Type” status code.

Q2. Query parameters
Using query parameters like “ ?Type=CO2 ” is considered semantically superior for filtering because they act as modifiers to a resource collection rather than identifiers of a unique, specific object. While path parameters are used to define the actual "address" or identity of a resource, query parameters provide the flexibility to search and filter data across multiple attributes without forcing the API into a rigid or overly complex URL structure. This approach keeps your API endpoints clean and predictable, allowing clients to dynamically refine their results while the base resource path remains stable and intuitive. 






Part 4
Q1. Architectural Benefits of Sub-Resource Locators
It prevents classes from becoming “God Classes”, which are harder to read, test and debug. Modularity of sub-resource locators solves these issues.


Part 5
Q1. HTTP 422 vs 404
404 Not Found means the URL path provided by the client does not exist on the server, while 422 Unprocessable Entity means the server understands the request and syntax is correct, but there are semantic errors (missing relationships, etc). Therefore, 422 makes it easier to understand what is actually causing the error status.

Q2. Cybersecurity Risks of Exposing Stack Traces
A stack trace can reveal internal class names, the specific JAX-RS implementation version (e.g., Jersey 2.x), directory structures, and even specific lines of code where a failure occurred. An attacker can use this to identify known vulnerabilities (CVEs) in those specific library versions to launch a targeted exploit.

Q3. Advantages of JAX-RS Filters

Using ContainerRequestFilter and ContainerResponseFilter handles cross-cutting concerns centrally. Instead of writing Logger.info() in multiple methods, a single filter class can automatically intercept every request and response. It also ensures that logging is applied uniformly across the entire API, even for new resources added in the future, without requiring the developer to remember to add logging code each time.
 


