def tower_of_hanoi(n, A, B, C):
<<<<<<< HEAD
    if (n == 1):
        print(f"Move disc {n} from {A} to {C} ")
        return

    tower_of_hanoi(n - 1, A, C, B)
    print(f"Move disc {n} from {A} to {C} ")
    tower_of_hanoi(n - 1, B, A, C)


tower_of_hanoi(3, 'Red', 'Green', "Blue")
=======
      if (n == 1):
          print(f"Move disc {n} from {A} to {C} ")
          return
  
      tower_of_hanoi(n - 1, A, C, B)
      print(f"Move disc {n} from {A} to {C} ")
      tower_of_hanoi(n - 1, B, A, C)
  
  
  tower_of_hanoi(3, 'Red', 'Green', "Blue")
>>>>>>> 1bee1b621eb79397577115a69073bb05b7154039
