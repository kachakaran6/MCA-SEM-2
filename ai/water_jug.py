def water_jug_dfs(x, y, z):
    stack = [(0, 0)]  # Start with both jugs empty
    visited = set()  # Keep track of visited states

    while stack:
        a, b = stack.pop()  # Get the current state

        if (a, b) in visited:  # Skip already visited states
            continue

        visited.add((a, b))  # Mark this state as visited

        # If we reach the target amount in either jug, return success
        if a == z or b == z:
            print(f"Solution found: {a}, {b}")
            return True

        # Possible operations:
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


# Example: Jug capacities 4L and 3L, target 2L
water_jug_dfs(4, 3, 2)
