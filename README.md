# YAWP!

A lightweight REST API framework focused on productivity and scalability. 

[![Build Status](https://travis-ci.org/feroult/yawp.svg)](https://travis-ci.org/feroult/yawp)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.yawp/yawp/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.yawp/yawp/)
[![Join the chat at https://gitter.im/feroult/yawp](https://badges.gitter.im/feroult/yawp.svg)](https://gitter.im/feroult/yawp?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

## Guides

Here you can find the complete [__YAWP!__ Guides](http://yawp.io/guides).

## Getting Started

1. At the command prompt, create a new YAWP! API application:

        $ mvn archetype:generate \
            -DarchetypeGroupId=io.yawp \
            -DarchetypeArtifactId=yawp \
            -DarchetypeVersion=LATEST \
            -DgroupId=yawpapp \
            -DartifactId=yawpapp \
            -Dversion=1.0-SNAPSHOT            

2. Change directory to `yawpapp` and start the yawp development server:

        $ cd yawpapp
        $ mvn yawp:devserver

3. Using a browser, go to `http://localhost:8080/api` to check if everything is OK.

4. Using a scaffolder, create a simple endpoint model:

        $ mvn yawp:endpoint -Dmodel=person

    **Output:**

    ``` java
    @Endpoint(path = "/people")
    public class Person {
        @Id
        IdRef<Person> id;
    }    
    ```
    **Try it:**

        $ curl http://localhost:8080/api/people

5. Follow the guidelines to start developing your API:
    * [Your First API](http://yawp.io/guides/getting-started/your-first-api)
    * [The Javascript Client](http://yawp.io/guides/tutorials/the-javascript-client)
    * [Todo App List Tutorial](http://yawp.io/guides/tutorials/todo-list-app)
    * [API Documentation](http://yawp.io/guides/api/models)    

## Contributing

Everyone willing to contribute with YAWP! is welcome. To start developing you
will need an environment with:

* JDK 1.8+
* Maven 3.3+
* PostgreSQL 9.4+
* phantomjs 2+

For postgres, you need to create a database and user accessible for your Unix user (you need to be able to run psql with no args). A simple tutorial for Arch can be found [here](http://www.netarky.com/programming/arch_linux/Arch_Linux_PostgreSQL_database_setup.html).

Phantomjs can be installed from [pacman](https://www.archlinux.org/packages/community/x86_64/phantomjs/) on Arch.

Then follow the [travis-ci build script](../master/.travis.yml) to get your build working.

## IRC

Feel free to contact the developers at the IRC channel __#yawp__ at __chat.freenode.net__

## License

YAWP! is released under the [MIT license](https://opensource.org/licenses/MIT).
