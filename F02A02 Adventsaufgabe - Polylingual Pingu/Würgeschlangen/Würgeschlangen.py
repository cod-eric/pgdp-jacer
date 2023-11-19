###########
# Imports #
###########

from __future__ import annotations
from typing import Union

import datetime as dt
import random as rnd


#######################
# Classes declaration #
#######################

class Snake:
    """
    This class represents a Snake with:
    - name
    - genus
    - mother
    - father
    - date born
    """

    snake_genera = ["Zwergpython", "Baumpython", "Schwarzkopfpython", "Wasserpython", "Raupenpython", "Netzpython"]

    # a Snake constructor which requires a name, genus, parents tuple and birthday
    def __init__(self, name: str, genus: str, parents: (Union[Snake, None], Union[Snake, None]), birthday: int) -> None:
        self.name = name
        if genus not in self.snake_genera:
            print("This looks like a weird mutation...")
            self.genus = self.snake_genera[0]
        else:
            self.genus = genus
        self.mother, self.father = parents
        self.birthday = birthday

    # lets the snake make a "hiss" sound on the console
    def hiss(self) -> None:
        print("💤" + self.name + " hisses!")

    # lets the snake slither around
    def slither(self) -> None:
        print("🐍", self.name, "slithers!")

    # breeds this egg with another Snake and returns a new Egg
    def breed(self, other_snake: Snake) -> Egg:
        return Egg(rnd.choice(self.snake_genera), (self, other_snake))

class Egg:
    """
    This class represents a (Snake) Egg with:
    - information about the days until it hatches
    - genus
    - mother
    - father
    """

    next_name_index = 0
    next_snake_names = ["Sssusan", "Zzzoe", "Sssteven", "Franc-hiss"]

    # automatically generates an incrementing name for an egg
    def get_next_name(self) -> str:
        Egg.next_name_index += 1
        return Egg.next_snake_names[Egg.next_name_index]

    # an Egg constructor requiring a genus and parents tuple
    def __init__(self, genus: str, parents: (Snake, Snake)) -> None:
        self.days_until_hatch = 5
        self.currentlyIncubated = False
        self.genus = genus
        self.mother, self.father = parents

    # a method that slowly hatches the egg when incubated and always returns the "current entity",
    # i.e. either the yet-to-hatch Egg or a Snake once hatched
    def incubate(self, current_day: int) -> Union[Egg, Snake]:
        if rnd.randrange(2) == 0:
            self.days_until_hatch -= 1
            print("🥚 The egg cracked a little. It will hatch soon!")
        if self.days_until_hatch <= 0:
            return Snake(
                self.get_next_name(),
                self.genus,
                (self.mother, self.father),
                current_day
            )
        else:
            return self


##################
# Code procedure #
##################

# set up the terrarium
terrarium = {
    "snakes" : [],
    "eggs" : []
}

# two initial snakes - Adam and Eve
adam = Snake("Adam", "Zwergpython", (None, None), 0)
eve = Snake("Eve", "Wasserpython", (None, None), 0)
terrarium["snakes"].append(adam)
terrarium["snakes"].append(eve)
print(adam.name + " and " + eve.name + " moved into the terrarium.")


# let Adam and Eve lay 3 eggs
for i in range(3):
    terrarium["eggs"].append(adam.breed(eve))
    print("🪺 An egg was laid!")


# now incubate the eggs until all the baby snakes hatched
print("The eggs will now be incubated")
day = 0
while not len(terrarium["eggs"]) == 0:
    print("☀️ A new day " + str(day) + " begins")
    for i in range(len(terrarium["eggs"])):
        print("Incubating egg in the hatchery station at position", str(i),
              " - needs", str(terrarium["eggs"][i].days_until_hatch), "more days to hatch"
              )
        egg_or_snake = terrarium["eggs"][i].incubate(day)
        if type(egg_or_snake) == Snake:
            print("Placing the new snake into the terrarium")
            terrarium["snakes"].append(egg_or_snake)
            terrarium["snakes"][-1].slither()
    for egg in terrarium["eggs"]:
        print("🧹 Cleaning up the eggshells of hatched snakes")
        terrarium["eggs"] = [x for x in terrarium["eggs"] if x.days_until_hatch > 0]
    day += 1


# let's simulate the snakes living in the terrarium until the visitor leaves
print("The terrarium is now opened to visitors")
visitor_still_watching = True
while visitor_still_watching:
    for _ in range(rnd.randrange(1, 4)):
        snake_taking_action = rnd.choice(terrarium["snakes"])
        snake_taking_action.hiss() if rnd.randrange(2) == 0 else snake_taking_action.slither()

    user_input = ""
    while True:
        user_input = input("🤵 The museum curator asks: Do you want to keep watching the [s]nakes or [l]eave? ")
        if user_input == "l":
            exit()
        elif user_input == "s":
            break
        else:
            print("The museum curator did not understand what you said.")
