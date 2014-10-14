# Alphatier (Java version)

Alphatier is a resource management library. It is designed to allow different schedulers to
share the resources of a pool of executors in order to execute tasks with those.

The detailed documentation is located at

* [http://alphatier.io](http://alphatier.io)

## Java version

This Java version is a statically typed wrapper around the [Alphatier](http://alphatier.io)
library. Please read its documentation to gain knowledge about its usage. The documented
namespaces from Alphatier are available through their respective Java interfaces.

* **io.alphatier.pools**
    * interface: io.alphatier.java.Pools
    * implementation: io.alphatier.java.InternalPools
* **io.alphatier.schedulers**
    * interface: io.alphatier.java.Schedulers
    * implementation: io.alphatier.java.InternalSchedulers
* **io.alphatier.constraints**
    * interface: io.alphatier.java.Constraints
    * implementation: io.alphatier.java.InternalConstraints
* **io.alphatier.executors**
    * interface: io.alphatier.java.Executors
    * implementation: io.alphatier.java.InternalExecutors

## Usage

The library is available in the
[central Maven repository](https://repo1.maven.org/maven2/io/alphatier/alphatier-java/0.1.0/):

    <dependency>
        <groupId>io.alphatier</groupId>
        <artifactId>alphatier-java</artifactId>
        <version>0.2.0</version>
    </dependency>

## Development

The source code is managed via [git](http://www.git-scm.com/) and hosted on
[Github](https://github.com/sarnowski/alphatier-java). See the
[Github help pages](https://help.github.com/articles/working-with-repositories) for more
information.

The source is tested on every update by [Travis-CI](https://travis-ci.org/sarnowski/alphatier-java).

[![Build Status](https://travis-ci.org/sarnowski/alphatier-java.svg?branch=master)](https://travis-ci.org/sarnowski/alphatier-java)

The build process of this library is managed by [Maven](http://maven.apache.org/). The
following commands have to be executed at the root of your project checkout:

### Cleanup your project

    mvn clean

The command deletes all generated files in order to guarantee a clean and defined project
state.

### Running the test suite

    mvn test

The test suite is implemented in the `src/test/` directory. The test command runs all implemented
unit tests.


### Building a jar artifact

    mvn package

The produced jar file can be used in other JVM based projects. It requires all other dependant
jars on the classpath (see pom.xml).

## License

Copyright (c) 2014 Tobias Sarnowski &lt;tobias@sarnowski.io&gt;

Permission to use, copy, modify, and distribute this software for any
purpose with or without fee is hereby granted, provided that the above
copyright notice and this permission notice appear in all copies.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
