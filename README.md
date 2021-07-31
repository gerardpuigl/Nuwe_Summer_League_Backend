# Nuwe Summer League Backend
CLI (Command Line Interface) application done in Java & Spring with connexion to GithubApi and Local MongoDB database.
Done for the Nuwe Summer League in Backend cathegory.

## 🔨 Technology stack
- JAVA
- SPRING
- Picocli
- MONGODB

## ✔️ Task

- **Task-1:** Configure db access to allow save user and project info.
- **Task-2:** Create user and project model.
- **Task-3:** Create login and register that allow authenticate user or create new user.
- **Task-4:** Implement a checking email solution.
- **Task-5:** Creatre nuwe submit_repository command that allow to save repository data to your account.
- **Task-6:** Create nuwe github_config command that allow to save github credentials in your user account.
- **Task-7:** [To do] Test your application (unit test, integration and/or E2E)

## ⚙️ How to Use 

  Important check that you have JVM installed. `java -version` and monogodb started on port 27000

### On windows: (recommended to test)

On your cmd open the application folder from this repository text any command to use.

### On mac or Linux:

On your termianl, open this application and use the commands but changing `nuwe` by `java -jar nuweCliApp.jar`

Example `java -jar nuweCliApp.jar login`

## 💬 Commands

### Help

Help menu that shows commands available.

`nuwe -h` or `nuwe --help`

### Login

Login dialog with username and password:

`nuwe login`

Login options to login directly with the initial command:

`nuwe login -u=<your_username> -p=<your_password>`

`nuwe login username=<your_username> password=<your_password>`


### Register

Register new user dialog with username, password and email:

`nuwe register`

Register new user options to register directly with the initial command:

`nuwe register -u=<your_username> -p=<your_password> -e=<your_email>`

`nuwe register username=<your_username> password=<your_password> email=<your_email>`


### Submit Repository

Submit repository dialog to save new project using github url repository:

`nuwe submit_repository`

Submit repository options to save new project directly with the intial command:

`nuwe submit_repository -u=<your_username> -p=<your_password> -url=<repository_url>`

`nuwe submit_repository username=<your_username> password=<your_password> url=<repository_url>`


### Github Configuration

Github config dialog that allows to add github credentials to your user account:

`nuwe github_config`

Github config dialog that allows to add github credentials direclty with the initial command:

`nuwe submit_repository -u=<your_username> -p=<your_password> -gu=<github_user>`

`nuwe submit_repository username=<your_username> password=<your_password> github_user=<github_user>`


