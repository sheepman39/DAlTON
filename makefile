Unit.class: Unit.java
	javac -g Unit.java

run: Unit.class
	java Unit

clean:
	rm *.class *.jar

debug: Unit.class
	jdb Unit
