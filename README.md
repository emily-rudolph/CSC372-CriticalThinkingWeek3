## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Setup Notes 

In order to run a JavaFX program you must first follow some setup steps 

1 - Make sure the latest Jave JDK is installed 
2 - Download the latest JavaFX from https://openjfx.io/
3 - Install the JavaFX extension if you are working in VS Code 
3 - Set the vmArgs in the launch.JSON file to the path where your downloads /lib file can be found 
4 - Add the .jar files to Referenced Libraries for the java project 

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
