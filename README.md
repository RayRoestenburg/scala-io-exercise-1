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

- implement ReverseActor (reverse a string and send back to sender).
  - define ReverseActor
  - define Reverse case class and Reversed case class (isPalindrome?)
  - Test Reverse Actor
- Receptionist
  - create the child actor
  - remove the direct implementation and delegate to reverse request to ReverseActor. use ask pattern.
  - run the tests

- Define a Main App which starts up the ActorSystem.
  - Start a Receptionist Actor that listens to an endpoint. (TBD direct Spray can or routes)
  - define reception of external message, translate to Pong
  - Start a component/worker Actor from the receptionist Actor that will do the work (the PingActor).
  - respond back to Receptionist, translate
- Run the application
  - Test with httpie (or curl or your fav http command line tool)
