cd temp

DEL output.txt
DEL HelloWorld.class
 
javac HelloWorld.java >> output.txt 2>&1
java HelloWorld >> output.txt 2>&1


