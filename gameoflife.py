import time
import random
import os

def norm(val, maxVal):
  if val == maxVal:
    return 0
  elif val < 0:
    return maxVal - 1
  else:
    return val

def printArea(area):
  _ = os.system("cls")

  for y in range(len(area)):
    for x in range(len(area[y])):
      print("#" if area[y][x] == 1 else " ", end = "" )
    print("")  


def main():
  '''
      Any live cell with fewer than two live neighbours dies, as if caused by under-population.
      Any live cell with two or three live neighbours lives on to the next generation.
      Any live cell with more than three live neighbours dies, as if by over-population.
      Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.'''
  run = True
  while run:
    try:
      width, height = (80, 50)
      area = [[random.randint(0, 1) for x in range(width)] for y in range(height)]

      generations = 0
      while True:
        printArea(area)

        newArea = [[0 for x in range(width)] for y in range(height)]
        for y in range(height):
          for x in range(width):
            current = area[y][x]
            next = 0

            neighbours = [
                area[norm(y - 1, height)][norm(x - 1, width)], area[norm(y - 1, height)][x], area[norm(y - 1, height)][norm(x + 1, width)],
                area[y                  ][norm(x - 1, width)],                               area[y                  ][norm(x + 1, width)],
                area[norm(y + 1, height)][norm(x - 1, width)], area[norm(y + 1, height)][x], area[norm(y + 1, height)][norm(x + 1, width)]
            ]
            
            s = sum(neighbours)
            
            if current == 1:
              next = 1 if s == 2 or s == 3 else 0
            elif current == 0:
              next = 1 if s == 3 else 0

            # print("c(%d,%d)=%d, n=%d" % (x, y, current, next))
            newArea[y][x] = next

        generations += 1
        area = newArea

        time.sleep(0.1)

        #ts = sum([sum(area[y]) for y in range(height)])
        #if ts == 0:


    except KeyboardInterrupt:
      run = True if input("again? (y/n) ").strip().lower() == "y" else False


if __name__ == "__main__":
  main()


