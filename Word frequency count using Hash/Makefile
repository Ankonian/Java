Bard: Bard.class
	echo Main-class: Bard > Manifest
	jar cvfm Bard.jar Manifest Bard.class Frequency.class
	rm Manifest

Bard.class: Bard.java
	javac -Xlint Bard.java
Frequency.class: Frequency.java
	javac -Xlint Frequency.java
clean:
	rm Bard.jar Bard.class Frequency.java
