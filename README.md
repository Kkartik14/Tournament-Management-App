# F1 Management System Readme

## Overview
The F1 Management System is a Java console application that allows users to manage a fictional Formula 1 Championship. The system supports two roles: Manager and Team Manager. The Manager can add/delete races and teams, while the Team Manager can manage pitstop crews, drivers, and team details within a championship.

## Features
- **Championship Management**: Create and manage F1 championships, add/delete races, and add/delete teams.
- **Team Management**: For Team Managers, the system supports managing pitstop crews for races, editing crew details, and adding/updating driver details.

## Structure
The application is structured with several classes representing entities such as Race, Team, PitstopCrew, Driver, Championship, Manager, and TeamManager. The main class, `Main`, handles the user interface and interaction.

## Database Integration
The system is integrated with a MySQL database using JDBC. The database connection is established at the beginning of the application. Races can be inserted into the database using the `insertRaceIntoDatabase` method.

## Usage
1. Upon running the application, users are prompted to choose a role: Manager or Team Manager.
2. Managers can then manage championships by adding/deleting races and teams.
3. Team Managers can manage pitstop crews, edit crew details, and add/update driver details within a championship.
4. The application displays the current state of races and teams in the championship.

## How to Run
1. Ensure that the MySQL server is running.
2. Update the database connection details in the `Main` class (`JDBC_DRIVER`, `DB_URL`, `USER`, `PASS`).
3. Run the `Main` class.

## Dependencies
- Java SE Development Kit
- MySQL Server
- JDBC Driver for MySQL

## JDBC Documentation
For more information on JDBC, refer to the official JDBC documentation: [JDBC Documentation](https://docs.oracle.com/en/java/javase/14/docs/api/java.sql/java/sql/package-summary.html)

## Notes
- The system includes exception handling for invalid input types and choices.
- The ASCII art in the `Main` class provides a fun and creative welcome message.

Feel free to explore and customize the application according to your needs!
