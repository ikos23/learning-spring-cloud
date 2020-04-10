#### Simple Spring Cloud Config Client

---

Exposes a simple `/hello` REST endpoint, check `HelloWorldController`.
All the config props are provided by a config server.

Important configs are in `resources/bootstrap.properties`.

```
# This is the name that is used by conf server to figure out
# which files represent configs for this particular app.
spring.application.name=hello-world-app
spring.profiles.active=dev

# Config server url :) 
spring.cloud.config.uri=http://localhost:8001
```

