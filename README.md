# Here are the steps to execute and test API -

1. Run lumen-challenge\src\main\java\com\ctl\lumenchallenge\LumenChallengeApplication.java file from eclipse.
2. Open Browser
3. Go to - http://localhost:9000/github/followers?id=maddox
4. It will display all data for GitHub Id (i.e. maddox) and it's followers in JSON format.

Note:
1. This application is set to 9000 port.
2. Default URL - http://localhost:9000/github/followers?id=maddox
3. If you want to get more or less follower, you can use count attribute. e.g. http://localhost:9000/github/followers?id=maddox&count=7
4. Use java1.8 if you face any compilation issue.