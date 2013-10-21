Exercise 1
==========

In this exercise you will learn about a pattern known as *the Receptionist*.

The Receptionist has the following responsibilities:

- Receive messages from the outside world using some endpoint configuration. The receptionist receives messages and
delegates to child actors to do the work. The child actors respond back to the receptionist for request response cycle or
the receptionist signals child actors fire and forget.
- Supervise the child actors.
- Create the child actors.


Exercise
~~~~~~~~

- implement ping/pong.
  - define a PingActor
  - define Ping and Pong case class
  - Test Ping Pong
  - delegate ping request to PingActor
- Define a Main App which starts up the ActorSystem.
  - Start a Receptionist Actor that listens to an endpoint. (TBD direct Spray can or routes)
  - define reception of external message, translate to Pong
  - Start a component/worker Actor from the receptionist Actor that will do the work (the PingActor).
  - respond back to Receptionist, translate