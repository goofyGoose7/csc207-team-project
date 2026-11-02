# CityGuesser

Please keep this up-to-date with information about your project throughout the term.

The readme should include information such as:
- a summary of what your application is all about
- a list of the user stories, along with who is responsible for each one
- information about the API(s) that your project uses 
- screenshots or animations demonstrating current functionality

By keeping this README up-to-date,
your team will find it easier to prepare for the final presentation
at the end of the term.

# Project Name
## Team Information
### Team Members
- Regan Alexandra Medcof
- Nikola Kraincanic
- Elliot Gamache
- Felix Hansen
- Ingrid Wilkinson
---
## Project Description
### Entertainment
Guess the city game where a player is shown a satellite image of a city with 5 tries to guess correctly, slightly zooming out with each wrong answer.

---
## User Stories
### User Story 1
As a player, I want to start a new game from the welcome page, so that I can begin guessing right away.
### User Story 2
As a player, I want to be told when I guess correctly, so that I am shown a screen displaying information about the correctly guessed location and accumulate points to my profile if I am signed in.
### User Story 3 - Nikola
As a player, I want the game to get easier with every wrong answer that I make.
### User Story 4 - Regan
As a player, I want to have an account with a username and profile picture so that I can be identified. I want to be able to change my username and profile picture later in case I want to express myself differently.
### User Story 5
As a player, I want to be able to view my rating and a leaderboard of the ratings of the top players of the game to see how good I am, relatively, at the game.
### User Story 6
As a player, I want to see a satellite image of a famous place with no labels, so that I have to figure out where it is from the image alone and then guess the name of the city.
### User Story 7
As a player, I want to be able to see the accounts of other players.

---
## Use Cases
### Use Case 1 - Play game
Primary Actor: Player choosing to play the game
Preconditions:
Trigger:
Success Outcome: Displays a question for a city satellite and checks the player’s answer
Main Success Scenario:


Extensions:

### Use Case 2 - Correct Answer
Primary Actor: Player
Preconditions: 
Player input the correct city name
Player has not exceeded allotted guesses (5)
Trigger:
Player guess matches city in dataset
Success Outcome:
A message outputs that the 
Main Success Scenario:
Display that 
Increase player rating
Extensions:

### Use Case 3 - Incorrect Answer
Primary Actor:
Preconditions: 
Player has input an incorrect city name
Trigger:
Success Outcome: User is given more information about the city
Main Success Scenario: 
Zooms out on the satellite image by a constant amount.
Shows the distance from the guessed city to the target city, with a direction.
Extensions:

### Use Case 4 - 
Primary Actor:
Preconditions: 
Trigger:
Success Outcome:
Main Success Scenario:
Extensions:

### Use Case 4 - Make an account
Primary actor: a player opens the app for the first time
Preconditions:
 The player does not have an existing account
Trigger: a player selects “make an account”
Success outcome: an account is created
Upon account creation, the player is prompted to fill out a username. 
If the username is already taken, the player is prompted to enter a different username.
The player is prompted to add a profile picture (optional).
The player’s account is saved to the system and their rating is set to an initial value.

(Add additional use cases as needed.)
---
## Minimal Viable Product (MVP)
| Team Member | MVP Use Case |
|-------------|--------------|
| Felix | Use Case 1 | 
| Elliot | Use Case 2 | 
| Nikola | Use Case 3 | 
| Regan | Use Case ? | 
| Ingrid | Use Case ? | 


---
## Entities
### Entity 1 
Player
### Entity 2
Location (image they’re trying to guess)
### Entity 3
The game
### Entity 4
Guess box (where you input answers)
---
## API Usage
**API Name: Mapbox**

**Documentation:** [https://docs.mapbox.com/api/maps/static-images/]

**How it is used in the program:** 
This API will be used in addition to a JSON dataset containing popular cities longitude and latitude. Then those coordinates will help build a URL query to get the satellite image.

---
## Design Diagrams
### UML Class Diagram
### Sequence Diagrams
---
## How to Run
[Instructions for running the program.]
---
## Notes
[Any additional project information.]

MVP Description:

Users are greeted with a home page where they click a button to start the game. It’s a single player game where the user guesses the city and is scored based on how many guesses it takes them to guess the correct city. The user gets 5 tries to guess the correct city. Every incorrect guess provides the user with a clue, by zooming out on the satellite image and listing the distance from their guessed city to the target city, with a direction. The user doesn’t have an account. A correct answer opens up a window showing the user their final score, with a button to play again and a button to return home.




