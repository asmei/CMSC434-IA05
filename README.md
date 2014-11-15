CMSC434-IA05
============
Angela Mei, Ambily Bose

Clock One- 

Clock Two- Custom View clock with twelve circles representing each hour. For the current hour, the circle is red while the previous hours are black and the future hours are gray. The hour circle's radius increases based on the second and the opacity of the circle gets darker as the minute approaches the next hour. 

MyActivity is the main class which creates a Timer that is used in the refresh() function. In this function, postInvalidate() is called for the CircleView in order to update the view every second. 

CircleView: Custom View class that creates the twelve circles in the onDraw() method. There is a counter within that keeps track of global variables seconds, minutes, and hour. Based on the time, the onDraw() method will create different views. There are also functions defaultCircles (which creates the static circles) and findCos() and findSin() which is used to help create the position of the circles based on the degree from the origin. 

activity_my.xml: XML file detailing the layout of the app. 
