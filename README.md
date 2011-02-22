Dijkstra
========

A Java implementation of Dijkstra's algorithm, based on the description at [Wikipedia](http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Algorithm).

Design
------

The algorithm talks about nodes, edges and graphs, so it seemed sensible to model these directly with classes.

- Edge.java
- Graph.java
- Node.java

The solution to the problem is implemented in the Graph class, and is accessible via DijkstraClient.java.

User Interface
--------------

The input and output is currently text based. I may enhance this to provide a graphical UI at a later date. If you feel the urge to do this, then fork the project and get stuck in!

_Stewart Wright_