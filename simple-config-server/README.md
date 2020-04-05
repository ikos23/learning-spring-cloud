#### Simple Spring Cloud Config Server

---

Spring Cloud Config Server provides an HTTP resource-based API 
for external configuration (name-value pairs or 
equivalent YAML content). 

> With the Config Server you have a central place to manage 
external properties for applications across all environments. 
The concepts on both client and server map identically 
to the Spring "Environment" and "PropertySource" abstractions, 
so they fit very well with Spring applications, 
but can be used with any application running in any language.


###### Everything you need for this to work is:
* To create git repo with config files (.yml or .properties) for
your clients. Right now it is configured to [config-repo](https://github.com/ikos23/learning-spring-cloud/tree/master/config-repo).
What you keep in that repo must follow naming pattern 
`<spring.application.name>-profile`.
* Main class should be annotated with `@EnableConfigServer`.

###### Misc:
* All the configs are in `resources/application.yml`.
* When you start this server, you can test if it works
with a few simple REST endpoints (examples in `api-test-req.http`).

There is a simple client [hello-world-app](https://github.com/ikos23/learning-spring-cloud/tree/master/hello-world-app)
which uses this server to grab its configs from :)

More details can be found in [official docs](https://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.2.2.RELEASE/reference/html/#_quick_start).
