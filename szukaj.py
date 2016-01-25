import random

zakres = 123456789
igla = int(zakres * random.random()) + 1
strzal = 0
while strzal != igla:
  strzal = int(input("Podaj liczbe: "))
  if strzal > 0:
    if strzal > igla:
      print("Podales liczbe wieksza od szukanej!")
    elif strzal < igla:
      print("Podales liczbe mniejsza od szukanej!")
  else:
    print("Koniec.")
    break
else:
  print("Zgadles!!!")



