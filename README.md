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
  - define Reverse case class and Reversed case class
  - Test Reverse Actor
- Receptionist
  - create the child actor
  - remove the direct implementation and delegate to reverse request to ReverseActor. use ask pattern, mapTo future, complete with Future.
  - run the tests

- Define a Main App which starts up the ActorSystem.
  - Start a Receptionist Actor that listens to an endpoint. (TBD direct Spray can or routes)
  - define reception of external message, translate to Pong
  - Start a component/worker Actor from the receptionist Actor that will do the work (the PingActor).
  - respond back to Receptionist, translate
- Run the application
  - Test with httpie (or curl or your fav http command line tool)

Ideas (For next exercises):

  - define one string that crashes your dear ReverseActor. create a supervisorStrategy that restarts X times, after which the
    'reverse service' is taken offline or switches behavior. (using Stop after x times, death watch and create a new child which
    does something else than reverse, like sending ReverseError back which turns into a status code)

  - do a reverse, then uppercase 'flow'.
