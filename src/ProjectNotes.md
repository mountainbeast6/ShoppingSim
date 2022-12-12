## Project Notes

### Project Summary

 Simulate a supermarket where customers enter after  some random interval, 
 shop for a random interval of time, get into line, and check out for a random interval of time
 
### Classes

* Customer (threaded)
* CustomerFactory
* Cashiers(threaded)
  * Needs to be written

### Data Structures

* Arraylist of Customers 
* Queue of Customer as they check out
  * want to use ConcurrentLinkedQueue because it is Serializable

### Key Terms

* Thread - A piece of code, a class. an object, ect. that runs on its own processor thread
* Serializable - a function or data structure that is Thread safe
  * It locks and unlocks access as different threads interact with it
### End Result

* A list of stats
  * Total customers
  * Total number of Cashiers used
  * Average shop time per customer
  * Average process time per customer
  * Average wait time in the Queue per customer
    * not implemented
    * we need to add time-stamps to Customer when they
      * Enter Queue
      * Exit Queue
  * Average down-time per Cashier (stretch goal)