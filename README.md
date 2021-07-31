# Nuwe Summer League Backend
CLI (Command Line Interface) application done in Java & Spring with connexion to GithubApi and Local MongoDB database.
Done for the Nuwe Summer League in Backend cathegory.

## 🔨 Technology stack
- JAVA
- SPRING
- Picocli
- MONGODB

## ✔️ Task

- **Task-1:** Configurar el acceso a una base de datos, que permita guardar toda la información del usuario.
- **Task-2:** Crear modelos de user y project.
- **Task-3:** Crear un login y register que permita al usuario iniciar sesión o crear un usuario a través del los siguientes comandos:
- **Task-4:** Implementar una solución para revisar que el correo implementado tiene el formato correcto
- **Task-5:** Crear el comando nuwe submit_repository [url] | Comando que permite al usuario guardar los datos de un respositorio en su cuenta.
- **Task-6:** Crear el comando nuwe github_config | Comando que le permite al usuario introducir los datos de parámeto github (username y url).
- **Task-7:** Hacer testing de la aplicación (unitario, integracióny y/o E2E)

## ⚙️ How to Use 

  Important check that you have JVM installed. `java -version` and monogodb started on port 27000

### On windows: (recommended to test)

On your cmd open the application folder from this repository text any command to use.

### On mac or Linux

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


