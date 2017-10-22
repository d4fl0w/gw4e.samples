# gw4e.samples
Samples for GW4E

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

This sample shows how to modelize this and how it is derived to generate a test.

![Amazon Shopping Cart](https://github.com/gw4e/gw4e.samples/blob/master/images/javaamazon.png "Amazon Shopping Cart")

