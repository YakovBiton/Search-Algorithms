# A* Search Algorithm Implementation

This project implements the A* search algorithm to solve a pebble arrangement puzzle. The goal is to rearrange a sequence of black and white tokens (represented as "BBB0WWW" where 0 is the empty space) to a target configuration where no white token appears before any black token.

## Problem Description

- Initial state: `BBB0WWW` (three black tokens, an empty space, three white tokens)
- Goal: Arrange tokens so that all white tokens come before black tokens
- Rules: The empty space can jump 1, 2, or 3 positions in either direction
- Cost: Jumps of 1-2 spaces cost 1 unit, jumps of 3 spaces cost 2 units

## Algorithm Details

The implementation uses the A* search algorithm with:
- A custom heuristic that counts the number of white tokens that appear after black tokens
- A priority queue to manage states based on f(n) = g(n) + h(n)
- Path tracking to reconstruct the optimal solution

## Components

- **AStarMain.java**: Entry point of the application
- **Board.java**: Manages the game state and valid moves
- **Cost_Tracker.java**: Tracks costs and constructs solution paths
- **Game_Solver.java**: Core A* algorithm implementation
- **Heuristics.java**: Heuristic function definition
- **Solution.java**: Solution representation and output
- **StateNode.java**: State node representation with priority calculation

## Running the Program

```bash
javac *.java
java AStarMain
