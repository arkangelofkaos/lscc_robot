Robot tournament setup files
======================

Setup files to help speed up playing the [Robot Tournament](https://github.com/mattwynne/robot_tournament)

### Initial config

required command line tools: __curl__ & __zip__

1. Choose a player name

2. Rename the __player__ folder to your player name

3. Edit __release.sh__:
 - make it executable eg: ```chmod +x release.sh```
 - set your player name
 - set the ip (this will be given to you in the session)

   ___optional___:  If using __Java__, __Scala__ or __C#__ uncomment the appropriate lines

4. Edit the __move__ file inside your player folder: uncomment the appropriate line for your language

That's it, now go and write some codes! You can use the __Main__ file with your language extension inside your player folder.


__P.s.__ _These files are meant to get you started quickly. Feel free to edit them or have a completely different deploy process. The _