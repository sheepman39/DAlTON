Hill.class: Hill.java Site.class Unit.class GenericNode.class GenericQ.class GenericLL.class Basic.class
	javac -g Hill.java
Site.class: Site.java Unit.class GenericNode.class GenericQ.class GenericLL.class Basic.class
	javac -g Site.java

Unit.class: Unit.java Basic.class
	javac -g Unit.java

GenericLL.class: GenericLL.java GenericNode.class
	javac -g GenericLL.java

GenericQ.class: GenericQ.java GenericNode.class
	javac -g GenericQ.java

GenericNode.class: GenericNode.java
	javac -g GenericNode.java

Basic.class: Basic.java
	javac -g Basic.java


run: Hill.class
	java Hill

clean:
	rm *.class *.jar

debug: Hill.class
	jdb Hill
