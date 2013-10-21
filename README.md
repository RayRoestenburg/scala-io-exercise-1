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
- Run the application
  - Test with httpie (or curl or your fav http command line tool)


What is already prepared:

- A Main App which starts up the ActorSystem.
  - Starts a Receptionist Actor that listens to an endpoint.
  - Receptionist defines reception of external message


Ideas (For next exercises):
  - add a counter (how many times was reverse called, fire and forget (event Stream or tell) and request the number of counts)

  - define one string that crashes your dear ReverseActor. create a supervisorStrategy that restarts X times, after which the
    'reverse service' is taken offline or switches behavior. (using Stop after x times, death watch and create a new child which
    does something else than reverse, like sending ReverseError back which turns into a status code)

  - do a reverse, then uppercase 'flow'.
