# Alchitry Au FPGA Register Interface Hello World - JavaFx

This project demonstrates a JavaFx application making use of the register interface to communicate
with an [Alchitry FPGA Board](https://www.sparkfun.com/search/results?term=alchitry). It turns
on and off LED0 on the Au board. This example also shows how to wire up the USB signals on the Au
board to the register interface through the uart components.

It has been tested to work on Windows 10 and should work on [OSX with some workarounds](https://forum.alchitry.com/thread-264.html?highlight=mac).

I walk though this project in detail [on Youtube](https://youtu.be/atH0MS5fdDA).

## Dependencies
* [Alchitry Au or Cu](https://www.sparkfun.com/products/16527)
* [Java 1.8 or better](https://java.com/en/download/manual.jsp)
* [Alchitry Labs](https://alchitry.com/pages/alchitry-labs) Note: Use version 1.2.4. You will also need a design synthisizer appropriate
for your board (see the Builders section at the bottom of the Alchitry Labs page).
* [Gradle](https://gradle.org/install/)
* An IDE like [VS Code](https://code.visualstudio.com/Download) if you want to experiment.

## Usage
1. Load the fpga/Hello World.alp project into Alchitry Labs.
2. You should be able to load the alchitry.bin file directly from the IDE. Bin file is included.
If not, build the project, then load.
3. From the host directory, `gradlew run` will start the JavaFx application.

You will need to modify the `reg.connect` statement within `HelloWorld.java` to match the serial port your OS mapped
for the Alchitry board.
