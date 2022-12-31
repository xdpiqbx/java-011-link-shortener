# java-011-link-shortener

`hosts` file
```
127.0.0.1       lnkshort
```

Tomcat `server.xml`
```xml
<Host name="lnkshort" appBase="webapps\lnkshort" unpackWARs="true" autoDeploy="true" >
    <Context docBase="${catalina.base}\webapps\lnkshort" path="" reloadable="true"/>
</Host>
```

[All that is used here](https://github.com/xdpiqbx/java-011-link-shortener/blob/main/link-shortener_11_class_work.drawio.pdf)

