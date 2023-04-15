
Main.jar: Main.class Week.class Hill.class Site.class Unit.class GenericNode.class GenericQ.class GenericLL.class Collection.class Basic.class
	jar -cvfm Main.java manifest.txt *.*

Main.class: Main.java Week.class Hill.class Site.class Unit.class GenericNode.class GenericQ.class GenericLL.class Collection.class Basic.class
	javac -g Main.java

Week.class: Week.java Hill.class Site.class Unit.class GenericNode.class GenericQ.class GenericLL.class Collection.class Basic.class
	javac -g Week.java

Hill.class: Hill.java Site.class Unit.class GenericNode.class GenericQ.class GenericLL.class Collection.class Basic.class
	javac -g Hill.java

Site.class: Site.java Unit.class GenericNode.class GenericQ.class GenericLL.class Collection.class Basic.class
	javac -g Site.java

Unit.class: Unit.java Collection.class Basic.class
	javac -g Unit.java

GenericLL.class: GenericLL.java GenericNode.class
	javac -g GenericLL.java

GenericQ.class: GenericQ.java GenericNode.class
	javac -g GenericQ.java

GenericNode.class: GenericNode.java
	javac -g GenericNode.java

Collection.class: Collection.java Basic.class
	javac -g Collection.java

Basic.class: Basic.java
	javac -g Basic.java

run: Main.jar
	java -jar Main.jar

clean:
	rm *.class *.jar

debug: Main.jar
	jdb Main.jar
