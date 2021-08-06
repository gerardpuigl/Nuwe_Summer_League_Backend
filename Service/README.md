# Nuwe Summer League Backend
CLI (Command Line Interface) application done in Java & Spring with connexion to GithubApi and Local MongoDB database.
Done for the Nuwe Summer League in Backend cathegory.

## 🔨 Technology stack
- JAVA
- SPRING
- Picocli
- MONGODB

## ✔️ Task

- **Task-1:** Create a Timer to advice the user that is time to rest or go home with the commands: 
  - "rest_time": Configurate and hour to recive a warning to advice the user to stop to work.
  - "break_time": Configurate a loop to recive a warning to advice the user to do a break.
- **Task-2:** [To do] Create command to configurate the timers: (for Java complexity I can't implement it)
  - "timer_config": allow to change the hour or the loop minutes for the previous advices.
- **Task-3:** At the sheduled time, the user should recive and console command with one of both options.
  (I chose JOptionPane to leave console free to work). 
- **Task-4:** [To do] Create endpoints to control this functionality from other applications.

## ⚙️ How to Use 

  Important check that you have JVM installed. `java -version` and local monogodb started on port 27000.

### On windows: (recommended to test)

Open the cmd, open the application folder from this repository and text any command.

### On mac or Linux:

On the termianl, open this application and text any commands but changing `nuwe` by `java -jar nuweCliApp.jar`

Example `java -jar nuweCliApp.jar login`

## 💬 Commands

### Alarm at Date & Time

Alarm dialog to add date & time:

`nuwe rest_time`

Rest Timer options to set the alarm directly with the initial command:

`nuwe rest_time -t=<hores:minutes> -d=<day-month-year> -m=<custom message>`

`nuwe rest_time time=<hores:minutes> date=<day-month-year> message=<custom message>`


### Loop Alarm every XX minutes

Loop alarm dialog to start a warning every XX minutes:

`nuwe break_time`

Loop alarm options to set directly with the initial command:

`nuwe break_time -t=<minutes> -m=<custom message>`

`nuwe break_time time=<minutes> message=<custom message>`

