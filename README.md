# gw4e.samples
Samples for GW4E

## Model Based Testing Overview

The Model Based Testing (MBT) is a test practice in the software industry to increase the effectiveness of the tests, both in
their coverage of the requirements and in the productivity for creating and maintaining test repositories.
Model Based Testing improves the test process by piloting the creation and maintenance of tests from modeling for the test.

![MBT](https://github.com/gw4e/gw4e.samples/blob/master/images/mbt.png "MBT")


The model describes all or part of the system. From the model are derived the abstract tests that are the basis of 
the executable tests that will test the black box, called system. Abstract tests are like the model, independent of the 
platform used. They are a common interface to the executable tests that will be generated; they represent a path in the use
of the system.

## GraphWalker & GW4E Overview

The purpose of the test design in MBT is to describe the expected behavior of the system under test. The result of design looks
like a graph model with a number of edges (aka arrow, arc or transition) and vertices (aka node or state) and how do they interact 
with each other. A model would remind you a popular in testing state transition diagram or a finite state diagram. 
An edge express an action with the SUT and a vertex express a state of the SUT which should be tested. 
When a test is generated from the model, a model derives to a java interface and a class implementation, and each graph element 
(Vertex or Edge) is converted to a java method.

![MBT](https://github.com/gw4e/gw4e.samples/blob/master/images/modeltojava.png "MBT")

When a test has been generated, it needs to be completed because generation ends up with a test skeleton. Once you've completed the test,
you will want to run it. At execution time GraphWalker walks thru the graph model, when it encounters a graph element (node, or vertex), it calls
the test java method having the name of the element. The way GrahpWalker walks thru the graph is determined by a PATHGENERATOR. The way it stops walking is 
handled by a STOPCONDITION. Path generators together with stop conditions will decide what strategy to use when generating a path through a model, and when
to stop generating that path. Different generators will generate different test sequences, and they will navigate in different ways.

#### Generators
There are many path generators offered by GraphWalker. The following are two examples :
##### random( some stop condition(s) )
Navigate through the model in a completely random manor. Also called “Drunkard’s walk”, or “Random walk”. This algorithm selects
an out-edge from a vertex by random, and repeats the process in the next vertex.
##### weighted_random( some stop condition(s) )
Same as the random path generator (see above), but, will use the weight property when generating a path. The weight 
is an edge property, and it represents the probability of an edge getting chosen.

#### Stop conditions
There are many stop conditions offered by GraphWalker. The following are two examples :
##### edge_coverage( an integer representing percentage of desired edge coverage )
The stop criteria is a percentage number. When, during execution, the percentage of traversed edges is reached, the test
 is stopped. If an edge is traversed more than one time, it still counts as 1, when calculating the percentage coverage.
##### vertex_coverage( an integer representing percentage of desired vertex coverage )
The stop criteria is a percentage number. When, during execution, the percentage of traversed states is reached, the 
test is stopped. If vertex is traversed more than one time, it still counts as 1, when calculating the percentage coverage.


#### Generator and Stop conditions usage
You have two options when using Generator and Stop Conditions.
1. You use it in the GraphWalker annotation
![GraphWalker annotation](https://github.com/gw4e/gw4e.samples/blob/master/images/graphwalkerannotation.png "GraphWalker annotation")
2. You use them with api in your test
![Generator and Stop condition Apis](https://github.com/gw4e/gw4e.samples/blob/master/images/generatorstopconditionapi.png "Generator and Stop condition Apis")

## The Distributor Sample.

Create a simple simulator of an automatic items dispensing machine. The machine maintains an inventory 
of items with fixed prices, and is able to deliver the item when enough money have been introduced in the machine. 
The user can select an item or deselect it if needed. He/She inserts coins and when enough money have been inserted
the item is ready to be delivered. When the total amount of inserted coins is upper than the item price, then the machine 
gives back the difference. 

This sample shows how to modelize this and how it is derived to generate a test. 

![Items Dispenser](https://github.com/gw4e/gw4e.samples/blob/master/images/dispenser.png "Items Dispenser")

## The Amazon ShoppingCart Sample.
This is a test that runs on the Amazon web site.

The use case is about 'Adding books to the shopping cart'.

The preconditions are 'A working Internet connection' and 'an installed Internet browser, like Chrome'.

1. The user browses to the Amazon site: http://www.amazon.com.
2. The user searches Amazon for books, using the string “model-based testing”. The site should return several hits.
3. The user selects one of the books. The site displays information about the book.
4. The user adds 1 book to the shopping cart.
5. The user selects to view his shopping cart.

As result, there should be 1 book in the cart.

There is an alternative path: 'Removing a book from the shopping cart'.

The preconditions are 'There must be a book in the shopping cart'
1. The user browses to view the shopping cart.
2. The user deletes one of the books from the shopping cart.
As result, there should be 1 book less in the shopping cart

![Amazon Shopping Cart](https://github.com/gw4e/gw4e.samples/blob/master/images/javaamazon.png "Amazon Shopping Cart")

