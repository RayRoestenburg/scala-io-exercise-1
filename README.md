If you don't have a working Scala developemtn setup yet, please see the [setup instructions](SETUP.md)

Exercise 1
==========

In this exercise you will learn about a pattern known as **the Receptionist**.

The Receptionist has the following responsibilities:

- Receive messages from the outside world using some endpoint.
- Create child actors.
- delegate to child actors to do the work. The child actors respond back to the receptionist for a request/response interaction (or
the receptionist notifies child actors 'fire and forget style' which is not part of this exercise.)
- Supervise the child actors. (the default supervision strategy is used, supervision is not part of this exercise.)

###Objective

The objective of this exercise is to get familiar with the **Receptionist** pattern. 
You will learn how a child actor is created by the Receptionist and how work is delegated to the child actor.
Although [Spray](http://spray.io) is used in the exercise it is not required to know Spray to complete the exercise, since all required code to hook up to HTTP is provided.

###What is already prepared

A **Main** App which uses the Spray-can HTTP IO extension. This Main app creates the ActorSystem, starts the HTTP extension and registers the **Receptionist** Actor as HTTP listener.
If you comment out the **ReverseActorSpec** the /reverse path should work.
The Receptionist listens on the path "/reverse" for a HTTP POST of a JSON entity, for instance:
  
    
    { 
      "value" : "reverse this!"
    }   

An example using the **httpie** command line tool:

      http POST localhost:8000/reverse value="reverse this\\!"

The result should be something like:

    HTTP/1.1 200 OK
    {
      "value": "!siht esrever"
    }

In  this exercise you will replace the default string reversal code inside the ReverseRoute (which is mixed into the Receptionist) with a call to a child actor: the ReverseActor.
 
###The Exercise

Look for the TODO's in the project and follow the instructions.
The following tasks will need to be completed:

Implement the ReverseActor (reverse a string and send back to sender).

- define ReverseActor
- define Reverse case class and ReverseResult case class
- Make the existing ReverseActorSpec pass.
- create the child reverse actor in the Receptionist
- remove the direct implementation and delegate to the ReverseActor.

The Receptionist receives a ReverseRequest which needs to be converted to the message that the ReverseActor understands.

  - use the ask pattern, mapTo a typed future
  - run the tests, all tests should pass

Run the application

  - Run the application by using 'sbt run' from the project root (this starts the spray-can server on localhost:8000)
  - Test with httpie (or curl or your fav HTTP command line tool)
The example below shows a call using httpie:  
  
      http POST localhost:8000/reverse value="reverse this\\!"


###Next Exercise
A better way to create the child **ReverseActor** for easier unit testing of the Receptionist. Go to [Exercise 2](https://github.com/RayRoestenburg/scala-io-exercise-2)
