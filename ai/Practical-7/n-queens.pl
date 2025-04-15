% N-Queens Problem in Prolog
% Entry point: solve the problem for N queens
n_queens(N, Solution) :-
    range(1, N, Ns),
    permutation(Ns, Solution),
    safe(Solution).

% Generate a list from Low to High
range(Low, High, [Low|Rest]) :-
    Low < High,
    Next is Low + 1,
    range(Next, High, Rest).
range(High, High, [High]).

% Check that no two queens attack each other
safe([]).
safe([Q|Others]) :-
    safe(Others),
    no_attack(Q, Others, 1).

% Check that a queen does not attack any others diagonally
no_attack(_, [], _).
no_attack(Q, [Q1|Others], D) :-
    Q =\= Q1,
    abs(Q - Q1) =\= D,
    D1 is D + 1,
    no_attack(Q, Others, D1).

% Permutation generator (built-in in some Prolog systems)
permutation([], []).
permutation(List, [H|Perm]) :-
    select(H, List, Rest),
    permutation(Rest, Perm).