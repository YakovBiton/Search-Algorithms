```markdown
# Graph Search Strategies

This project implements three different graph search algorithms using the Strategy design pattern. It can find paths in a graph from a start node to a goal node using Breadth-First Search (BFS), Depth-First Search (DFS), or Uniform Cost Search (UCS).

## Problem Description

The program reads a graph structure from a file and finds a path from a specified start node to a goal node using the selected algorithm.

## Features

- **Strategy Design Pattern**: Easily switch between different search algorithms
- **Multiple Search Algorithms**:
  - Breadth-First Search (BFS): Explores all neighbors at the present depth before moving to nodes at the next depth
  - Depth-First Search (DFS): Explores as far as possible along each branch before backtracking
  - Uniform Cost Search (UCS): Explores in order of increasing path cost
- **Path Reconstruction**: Shows the complete path from start to goal

## Components

- **Main_Question2.py**: Driver program that reads the graph and handles user input
- **Search_Strategy.py**: Implements the Strategy pattern with the search algorithms
- **array.txt**: Example graph data

## Running the Program

```bash
python Main_Question2.py
