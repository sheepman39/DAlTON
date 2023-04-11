Site.class: Site.java Unit.class GenericNode.class GenericQ.class GenericLL.class
	javac -g Site.java

Unit.class: Unit.java
	javac -g Unit.java

GenericLL.class: GenericLL.java GenericNode.class
	javac -g GenericLL.java

GenericQ.class: GenericQ.java GenericNode.class
	javac -g GenericQ.java

GenericNode.class: GenericNode.java
	javac -g GenericNode.java


run: Site.class
	java Site

clean:
	rm *.class *.jar

debug: Site.class
	jdb Site
