def print_board(board):
 print("\n")
 print(f" {board[0]} | {board[1]} | {board[2]} ")
 print("---+---+---")
 print(f" {board[3]} | {board[4]} | {board[5]} ")
 print("---+---+---")
 print(f" {board[6]} | {board[7]} | {board[8]} ")
 print("\n")
# Function to check if the current player has won
def check_win(board, player):
    win_conditions = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8],  # Horizontal
        [0, 3, 6], [1, 4, 7], [2, 5, 8],  # Vertical
        [0, 4, 8], [2, 4, 6]  # Diagonal
    ]

    for condition in win_conditions:
        if board[condition[0]] == board[condition[1]] == board[condition[2]] == player:
            return True  # If a winning condition is met, return True

    return False  # Return False only after checking all conditions


# Function to check if the board is full
def is_board_full(board):
 return " " not in board

# Function to handle player's move
def player_move(board, player):
 while True:
    try:
        move = int(input(f"Player {player}, choose your position (1-9): ")) - 1
        if board[move] == " ":
            board[move] = player
            break
        else:
             print("That position is already taken. Try again.")
    except (ValueError, IndexError):
         print("Invalid move. Please choose a number between 1 and 9.")

# Main function to play the game
def play_game():
 board = [" "] * 9
 current_player = "X"

 print("Welcome to Tic-Tac-Toe!")
 print_board(board)

 while True:
    player_move(board, current_player)
    print_board(board)
    if check_win(board, current_player):
        print(f"Player {current_player} wins!")
        break
    elif is_board_full(board):
        print("It's a tie!")
        break

# Function to check if the board is full
def is_board_full(board):
 return " " not in board


# Function to handle player's move
def player_move(board, player):
 while True:
    try:
        move = int(input(f"Player {player}, choose your position (1-9): ")) - 1
        if board[move] == " ":
            board[move] = player
            break
        else:
            print("That position is already taken. Try again.")
    except (ValueError, IndexError):
        print("Invalid move. Please choose a number between 1 and 9.")


# Main function to play the game
def play_game():
 board = [" "] * 9
 current_player = "X"

 print("Welcome to Tic-Tac-Toe!")
 print_board(board)

 while True:
    player_move(board, current_player)
    print_board(board)
    if check_win(board, current_player):
        print(f"Player {current_player} wins!")
        break
    elif is_board_full(board):
        print("It's a tie!")
        break
    # Switch player
    current_player = "O" if current_player == "X" else "X"

# Start the game
if __name__ == "__main__":
 play_game()