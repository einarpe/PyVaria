
import random
import os

def norm(val, max):
  if val == max - 1:
    return 0
  elif val == 0:
    return max - 1
  else:
    return val
  # return 0 if val == max - 1 else (max - 1 if val == 0 else val)

def printArea(area):

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

  width, height = (10, 10)
  area = [[random.randint(0, 1) for x in range(width)] for y in range(height)]

  generations = 0
  while generations < 1:
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

        print("c(%d,%d)=%d, n=%d" % (x, y, current, next))
        newArea[y][x] = next

    generations += 1
    area = newArea



if __name__ == "__main__":
  main()


