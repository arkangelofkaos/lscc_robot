# PLAYER is the name for your chosen player
# IP is the ip of the server given to you at the start of the session

# NodeJS: node frankie/Main.java
# C#: mcs PLAYER/Main.cs


PLAYERNAME=player
IP=0.0.0.0
FILENAME=Main

# Java: 
# javac PLAYERNAME/FILNENAME.java

# Scala: 
# scalac -d PLAYERNAME/ PLAYERNAME/FILNENAME.scala

# C#
# gmcs PLAYERNAME/FILNENAME.cs

zip -r PLAYERNAME.zip ./PLAYERNAME
curl http://IP:3000/players --data-binary @PLAYERNAME.zip
