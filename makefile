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

run: Week.class
	java Week

clean:
	rm *.class *.jar

debug: Week.class
	jdb Week
