PLAYERNAME=ed_and_sandro
IP=10.100.84.125
FILENAME=Main

# Java:
/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/javac ed_and_sandro/Main.java

# Scala: 
# scalac -d PLAYERNAME/ PLAYERNAME/FILNENAME.scala

# C#
# gmcs PLAYERNAME/FILNENAME.cs

zip -r $PLAYERNAME.zip ./$PLAYERNAME
curl http://$IP:3000/players --data-binary @$PLAYERNAME.zip
