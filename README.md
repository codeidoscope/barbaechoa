## Barbaechoa

A tasty Echo server

This is an 8th Light Apprenticeship project used as a stepping stone to learn about sockets and I/O streams before
tackling the creation of an HTTP server. 

If you wonder what on earth the name means, I invite you to find the nearest Mexican restaurant and have yourself some
[barbacoa](https://en.wikipedia.org/wiki/Barbacoa) (#sorrynotsorry #teamcrappypuns).

## Setup

#### Requirements
- Java 10 (I used Homebrew to install it)

(I'm intending to have this run on Mac, so if you're on Linux or Windows, please report back as to how it works!)

#### Running it
In order to have your very own Barbaechoa server, you will need to clone, download or fork this repository. 
Pick your weapon and let's get started!

Once you have managed to copy the repository onto your local machine, run the following:
- `./gradlew jar` - to package the file
- `java -jar build/server.jar --port <port number>` - Run this in your terminal window, and pick a port number
(don't forget the port number!) - It has to be started before the next step.
- `nc 0.0.0.0 <port number>` OR `telnet 0.0.0.0 <port number>` - Run this in a different terminal window that is running
in parallel with your first terminal window. A couple of notes on this:

- `nc` stands for Netcat. If you're on Mac, it should be installed by default.
- If like my mentor, you want to use `telnet`, you'll likely have to install it
(I used Homebrew to do so - `brew install telnet`)
- `0.0.0.0` is the address of your local machine. Feel free to use whatever other address you fancy but it might not
work if (like me) you're not sure what you're doing because networking's tough.
- The first command (`java -jar ...`) will start a connection to a server, whereas the `nc`/`telnet` command opens a
connection to a client. They need to run at the same time, which is why you'll need two windows because I'm not using
threads to have them run concurrently.

#### Using it

Once you've got your server and your client running concurrently, you can type whatever you want in the client window.
This particular server is configured to do three things in response to your message:
- Reply with `ECHO` if you input `ECHO`;
- Reply with `POLO` if you input `MARCO`;
- Do absolutely nothing if you input anything else.