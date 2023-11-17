already_bred = ["Baumpython", "Schwarzkopfpython"]
# egg: (days of breeding left, breeding status, genus)
eggs = [(5, True, "Zwergpython"), (2, True, 'Wasserpython'), (8, False, 'Raupenpython'), (4, False, "Netzpython")]

free_breeding_stations = 1

days_left, breeding_status, genus = eggs[-1]
breeding_status = not breeding_status
days_left -= 1

eggs[3] = days_left, breeding_status, genus
free_breeding_stations = "All occupied"


def breed_for_one_day(egg):
    if type(free_breeding_stations) is not int:
        return

    # free_breeding_stations -= 1

    days_left, breeding_status, genus = eggs[-1]
    breeding_status = True

    if egg[0] == 0:
        already_bred.append(egg)
        eggs.remove(egg)

    days_left -= 1


print(str(eggs))
