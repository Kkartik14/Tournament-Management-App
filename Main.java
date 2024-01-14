import java.sql.*;
import java.util.*;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class InvalidRaceNumberException extends Exception {
    public InvalidRaceNumberException(String message) {
        super(message);
    }
}

class InvalidTeamNameException extends Exception {
    public InvalidTeamNameException(String message) {
        super(message);
    }
}

class InvalidDriverDataException extends Exception {
    public InvalidDriverDataException(String message) {
        super(message);
    }
}

class Race {
    private int RaceNumber;
    private String location;
    private String track;

    public Race(int RaceNumber, String location, String track) {
        this.RaceNumber = RaceNumber;
        this.location = location;
        this.track = track;
    }

    public int getRaceNumber() {
        return RaceNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getTrack() {
        return track;
    }
}

class Team {
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class PitstopCrew {
    private String name;
    private String role;
    private Race race;

    public PitstopCrew(String name, String role, Race race) {
        this.name = name;
        this.role = role;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Race getRace() {
        return race;
    }
}

class Driver {
    private String name;
    private String nationality;

    public Driver(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}

class Championship {
    private String name;
    private List<Race> races;
    private List<Team> teams;

    public Championship(String name) {
        this.name = name;
        this.races = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public void addRace(Race race) {
        races.add(race);
        System.out.println(
                "Race added: RaceNumber " + race.getRaceNumber() + ", Location: " + race.getLocation() + ", Track: "
                        + race.getTrack());
    }

    public void deleteRace(int RaceNumber) {
        Race raceToDelete = null;
        for (Race race : races) {
            if (race.getRaceNumber() == RaceNumber) {
                raceToDelete = race;
                break;
            }
        }
        if (raceToDelete != null) {
            races.remove(raceToDelete);
            System.out.println("Race deleted: RaceNumber " + raceToDelete.getRaceNumber() + ", Location: "
                    + raceToDelete.getLocation() + ", Track: " + raceToDelete.getTrack());
        } else {
            System.out.println("Race not found for RaceNumber " + RaceNumber);
        }
    }

    public void addTeam(Team team) {
        teams.add(team);
        System.out.println("Team added: " + team.getName());
    }

    public void deleteTeam(String teamName) {
        Team teamToDelete = null;
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                teamToDelete = team;
                break;
            }
        }
        if (teamToDelete != null) {
            teams.remove(teamToDelete);
            System.out.println("Team deleted: " + teamToDelete.getName());
        } else {
            System.out.println("Team not found: " + teamName);
        }
    }

    public Team getTeamByName(String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        return null;
    }

    public Race getRaceByRaceNumber(int RaceNumber) {
        for (Race race : races) {
            if (race.getRaceNumber() == RaceNumber) {
                return race;
            }
        }
        return null;
    }

    public void display() {
        System.out.println("Championship: " + name);

        System.out.println("Races:");
        for (Race race : races) {
            System.out.println(
                    "RaceNumber: " + race.getRaceNumber() + ", Location: " + race.getLocation() + ", Track: "
                            + race.getTrack());
        }

        System.out.println("Teams:");
        for (Team team : teams) {
            System.out.println("Team Name: " + team.getName());
        }
    }
}

interface Introducible {
    void introduce();
}

class Manager implements Introducible {
    private String name;
    private int age;

    public Manager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Manager: " + name + ", Age: " + age);
    }

    public void manageChampionship(Championship championship) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nManager: " + name);
            System.out.println("1. Add a race");
            System.out.println("2. Delete a race");
            System.out.println("3. Add a team");
            System.out.println("4. Edit a team");
            System.out.println("5. Delete a team");
            System.out.println("6. Display races and teams");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:

                    System.out.print("Enter the RaceNumber of the race: ");
                    int RaceNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the location: ");
                    String location = sc.nextLine();
                    System.out.print("Enter the track: ");
                    String track = sc.nextLine();
                    championship.addRace(new Race(RaceNumber, location, track));
                    break;
                case 2:
                    // Delete a race
                    System.out.print("Enter the RaceNumber of the race to delete: ");
                    RaceNumber = sc.nextInt();
                    sc.nextLine();
                    championship.deleteRace(RaceNumber);
                    break;
                case 3:
                    // Add a team
                    System.out.print("Enter the team name: ");
                    String teamName = sc.nextLine();
                    championship.addTeam(new Team(teamName));
                    break;
                case 4:
                    // Edit a team
                    System.out.print("Enter the team name to edit: ");
                    teamName = sc.nextLine();
                    Team teamToEdit = championship.getTeamByName(teamName);
                    if (teamToEdit != null) {
                        System.out.print("Enter the new name for the team: ");
                        String newTeamName = sc.nextLine();
                        teamToEdit.setName(newTeamName);
                    } else {
                        System.out.println("Team not found.");
                    }
                    break;
                case 5:
                    // Delete a team
                    System.out.print("Enter the team name to delete: ");
                    teamName = sc.nextLine();
                    championship.deleteTeam(teamName);
                    break;
                case 6:
                    // Display races and teams
                    championship.display();
                    break;
                case 0:
                    System.out.println("Exiting manager mode.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}

class TeamManager implements Introducible {
    private String name;
    private int age;
    private Team team;
    private List<PitstopCrew> pitstopCrew;
    private List<Driver> drivers;

    public TeamManager(String name, int age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.pitstopCrew = new ArrayList<>();
        this.drivers = new ArrayList<>();
    }

    public void introduce() {
        System.out.println("Team Manager: " + name + ", Age: " + age + ", Team: " + team.getName());
    }

    public Team getTeam() {
        return team;
    }

    public void manageTeam(Championship championship) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTeam Manager: " + name);
            System.out.println("1. Add Pitstop Crew for a Race");
            System.out.println("2. Edit Pitstop Crew for a Race");
            System.out.println("3. Add/Update Driver Details");
            System.out.println("4. Display Details");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // Add Pitstop Crew for a Race
                    System.out.print("Enter the RaceNumber of the race: ");
                    int RaceNumber = sc.nextInt();
                    sc.nextLine();
                    Race race = championship.getRaceByRaceNumber(RaceNumber);

                    if (race != null) {
                        System.out.println("Enter Pitstop Crew Details:");
                        System.out.print("Name: ");
                        String crewName = sc.nextLine();
                        System.out.print("Role: ");
                        String role = sc.nextLine();
                        pitstopCrew.add(new PitstopCrew(crewName, role, race));
                        System.out.println("Pitstop Crew added for RaceNumber " + RaceNumber);
                    } else {
                        System.out.println("Race not found for RaceNumber " + RaceNumber);
                    }
                    break;

                case 2:
                    // Edit Pitstop Crew for a Race
                    System.out.print("Enter the RaceNumber of the race: ");
                    RaceNumber = sc.nextInt();
                    sc.nextLine();
                    race = championship.getRaceByRaceNumber(RaceNumber);

                    if (race != null) {
                        System.out.println("Enter Pitstop Crew Details to edit:");
                        System.out.print("Name: ");
                        String crewNameToEdit = sc.nextLine();

                        for (PitstopCrew crew : pitstopCrew) {
                            if (crew.getRace() == race && crew.getName().equals(crewNameToEdit)) {
                                System.out.println("Enter new details:");
                                System.out.print("Name: ");
                                String newCrewName = sc.nextLine();
                                System.out.print("Role: ");
                                String newRole = sc.nextLine();

                                crew.setName(newCrewName);
                                crew.setRole(newRole);

                                System.out.println("Pitstop Crew details updated for RaceNumber " + RaceNumber);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Race not found for RaceNumber " + RaceNumber);
                    }
                    break;

                case 3:
                    // Add/Update Driver Details
                    System.out.print("Enter the driver's name: ");
                    String driverName = sc.nextLine();
                    Driver driverToUpdate = null;

                    for (Driver driver : drivers) {
                        if (driver.getName().equals(driverName)) {
                            driverToUpdate = driver;
                            break;
                        }
                    }

                    if (driverToUpdate != null) {
                        System.out.println("Enter new driver details:");
                        System.out.print("Nationality: ");
                        String newNationality = sc.nextLine();
                        driverToUpdate.setNationality(newNationality);

                        System.out.println("Driver details updated.");
                    } else {
                        // Driver doesn't exist, add a new driver
                        System.out.print("Enter the driver's nationality: ");
                        String nationality = sc.nextLine();
                        drivers.add(new Driver(driverName, nationality));
                        System.out.println("Driver added.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting Team Manager mode.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}

public class Main {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/race";
    static final String USER = "root";
    static final String PASS = "Kkartik@14";

    static Connection conn = null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    static {
        System.out.println("                        __");
        System.out.println("                _.--/'/'  |");
        System.out.println("  .----.     _.-'   |///| |.--.");
        System.out.println("  |kg14|__.-'   _________|  |_)  _______________");
        System.out.println(" |  .-^^-.^^^^^ ___,    `----'^))   __   .-^^-.^^^^--._ ");
        System.out.println(" '-' ,--. `    |tic|   .---.       |:.| ' ,--. `      _`.");
        System.out.println("  ( (    ) ) __|tac|__ //|// _..--  // ( (    ) )--._^.-.");
        System.out.println("   . `--' ;/__________________..--------. `--' ;--------'");
        System.out.println("    `-..-'                               `-..-'");

        System.out.println("---------------------------------------------------------");
        System.out.println("-------------WELCOME TO F1 MANAGMENT SYSTEM--------------");
        System.out.println("---------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Welcome to the F1 Management System!");
            System.out.println("Choose your role:");
            System.out.println("1. Manager");
            System.out.println("2. Team Manager");
            System.out.print("Enter your choice (1 or 2): ");
            int userChoice = sc.nextInt();

            Championship championship = null;

            if (userChoice == 1) {
                System.out.println("Enter the championship name: ");
                sc.nextLine();
                String championshipName = sc.nextLine();
                championship = new Championship(championshipName);

                System.out.println("Enter manager name");
                String a = sc.nextLine();
                System.out.println("Enter manager's age");
                int b = sc.nextInt();
                Manager manager = new Manager(a, b);
                manager.manageChampionship(championship);

            } else if (userChoice == 2) {
                // User chose to operate as a Team Manager
                System.out.println("Enter the championship name: ");
                sc.nextLine();
                String championshipName = sc.nextLine();
                championship = new Championship(championshipName);

                System.out.println("Enter Team manager name");
                String a = sc.nextLine();
                System.out.println("Enter Team manager's age");
                int b = sc.nextInt();

                TeamManager teamManager = new TeamManager(a, b, new Team("Team A"));
                teamManager.manageTeam(championship);

            } else {
                throw new InvalidInputException("Invalid choice. Exiting...");
            }

            if (championship != null) {
                championship.display();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter a valid number.");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
    public static void insertRaceIntoDatabase(Race race) {
        try {
            String sql = "INSERT INTO Race (RaceNumber, location, track) " + "VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, race.getRaceNumber());
                preparedStatement.setString(2, String.valueOf(race.getLocation()));
                preparedStatement.setString(3, race.getTrack());

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows == 0) {
                    System.out.println("Creating Race failed, no rows affected.");
                } else {
                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int id = generatedKeys.getInt(1);
                            System.out.println("Race details added to the database. Generated ID: " + id);
                        } else {
                            System.out.println("Loading Race failed, no ID obtained.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
