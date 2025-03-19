def water_jug_dfs(x, y, z):
    stack = [(0, 0)]  
    visited = set()  

    while stack:
        a, b = stack.pop()  

        if (a, b) in visited:  
            continue

        visited.add((a, b))  

       
        if a == z or b == z:
            print(f"Solution found: {a}, {b}")
            return True

       
        # 1. Fill jug X (a -> x)
        stack.append((x, b))

        # 2. Fill jug Y (b -> y)
        stack.append((a, y))

        # 3. Empty jug X (a -> 0)
        stack.append((0, b))

        # 4. Empty jug Y (b -> 0)
        stack.append((a, 0))

        # 5. Pour water from X to Y
        stack.append((a - min(a, y - b), b + min(a, y - b)))

        # 6. Pour water from Y to X
        stack.append((a + min(b, x - a), b - min(b, x - a)))

    print("No solution possible.")
    return False



water_jug_dfs(4, 3, 2)
