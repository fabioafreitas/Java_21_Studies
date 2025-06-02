# My demo to run OSGI bundles in Apache Felix

Attributions to [ferasalnaem](https://github.com/ferasalnaem/Felix-Tutorial) for creating this amazing tutorial, very educational for beginner like me in the OSGI framework. I Followed these videos ([intro](https://www.youtube.com/watch?v=JVwQ47wAuE4), [tutorial](https://www.youtube.com/watch?v=LfMS7XzwxpU)) to learn about the OSGI framework and how to actually build it within Felix.

## Building bundles with Maven

Run this command in project root. Since pom.xml have information regarding its modules, and the modules have information regarding its parent, maven will automatically know how to build each .jar for each module. The output bundles will ba stored in the /target folded within each module subfolder.
```bash
mvn clean install
```

## Download and running Apache Felix

Download the Apache Felix framework files from this [website](https://felix.apache.org/documentation/downloads.html). The time I tested this project, I downloaded the .zip binary file.

Extract it and open terminal in the root of felix directory. Is the one that contains the following folders: `/bin`, `/bundle`, `/conf`, `/doc`, `/felix-cache`. Within `/bin`, we'll find the `felix.jar` file. Run it using to open felix interactive terminal:

```bash
java -jar ./bin/felix.jar
```

Is from this terminal that we'll manage our OSGI bundles.

## Installing bundles

Keep in mind that I'm using windows. The commands below may change if in different OS.

```bash
install file:/C:/Users/fbioa/Desktop/personal/estudos_java_21/project_03_osgi/osgi-example-activator/target/osgi-example-activator-1.0.0.jar

install file:/C:/Users/fbioa/Desktop/personal/estudos_java_21/project_03_osgi/osgi-example-service/target/osgi-example-service-1.0.0.jar

install file:/C:/Users/fbioa/Desktop/personal/estudos_java_21/project_03_osgi/osgi-example-client/target/osgi-example-client-1.0.0.jar
```

Run below to see the id linking each installed bundle
```bash
lb
```

Run the following command to see the bundles lifecycle and to test them. Say we learned that activator bundle is id 8, service bundle is id 9 and client bundle is id 10.
```bash

# testing hello world
start 8
# should see its installation message
stop 8
# should see its deletion message

# running client without service down
start 10
# should see its installation message complaining about service unavailable
stop 10
# should see deletion message of client bundle

# running service
start 9
# should see its installation message

# running client without service up
start 10
# should see its installation message checking availability of service products
```
