
jeszcze = True
while jeszcze:
  age = int(input("Wiek psa zapodaj: "))
  if age < 1:
    print("To niemożliwe!")
  elif age == 1:
    print("To nastolatek.")
  elif age == 2:
    print("Młodzieniec w sile wieku.")
  elif age > 2:
    h = 22 + (age - 2) * 5
    print("Wiek psa w przeliczeniu na lata ludzkie: ", h, " lat ludzkich.")
  
  jeszcze = input("Jeszcze raz (t/n)? ").strip().lower() == "t"


