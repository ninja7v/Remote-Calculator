# Remote Calculator

GUI for a remote calculator coded in Java by Luc PREVOST.

![remote_calculator](https://user-images.githubusercontent.com/52052772/141867267-e179cb66-737c-4c00-9a8d-0fe2dcd2bffa.png)

📃 INSTRUCTIONS
============
## 🚀Execution
Remote Calculator uses the folowing libraries :
- [Awt](https://docs.oracle.com/javase/7/docs/api/java/awt/package-summary.html)
- [Rmi](https://docs.oracle.com/javase/tutorial/rmi/index.html)
- [Swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)
- [Util](https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html)

To execute it, compile every file in the server repertory, place the '.class' files in the client repertory, and compile the 'GUI.java' file in the client side. Finally, run the 'ServerCalculation.java' on the server side, then the 'GUI.java' file on the client side. This is roughly the procedure described by [Oracle](https://docs.oracle.com/javase/7/docs/technotes/guides/rmi/hello/hello-world.html).

As a result, a window pops up on the client side.

## ⚙️Usage
This program supports integer number only. To enter an operation, you can use the buttons or type it. The input must have the template: a␣operator␣b. If you type it, don't forget the spaces. An invalid form entry will result in an error. Also, an exception is created in case of a division by zero.

Now it is your turn to use it !

Thank you for using Remote calculator 🙂

Just compute !
