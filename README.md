# Object Oriented Design Pattern CSE Roadmap Homework - Veterinary Appointment Organizer

This is small coding exercise with goal of learning how to use design patterns in code.

### Requirements:
The solution must make use of at least:
* 1 Creational GoF pattern
* 1 Structural GoF pattern
* 1 Behaverioral Gof pattern

The solution must make use of:
* 4 non-creational GoF patterns in total
* 5 GoF patterns in total at least

Don't use any input from user.
Output should be printed to standard console output.

### Used Patterns:
* 2 Creational Patterns: Abstract Factory and Factory Method
* 2 Structural Design Patterns: Decorator/Bridge Pattern and Facade Pattern
* 2 Behavior Design Patterns: State Pattern and Strategy Pattern

### What Does The App Do:
The app is a simulator of appointment planner in Veterinary Clinic. It plans 9 appointments for each of 3 doctors.

**Random generation is used for:**
* Timeslot selection
* Patient (animal) creation
* Also appointment type creation (house call, vaccine, check up, surgery)

**Logic:**
If the randomly selected timeslot number is 1-4 appointment is emergency appointment and the animal has to be wild animal.
All other appointments are regular appointments with domestic animals.
