from Search_Strategy import *

def create_graph(size):
    # Read details from file
    with open('array.txt') as f:
        graph_details = f.readlines()

    # Create matrix --

    # Create 2D Matrix and fill it with -1 
    graph = [[-1] * size for _ in range(size)]
    # change the values to the correct Matrix values
    for i in range(size):
        line = graph_details[i].strip().split(',')
        for j in range(size):
            if line[j] != '-1':
                graph[i][j] = int(line[j])

    return graph


def select_strategy(algo):
    if algo == "BFS":
        return BFSStrategy()
    elif algo == "DFS":
        return DFSStrategy()
    elif algo == "UCS":
        return UCSStrategy()
    else:
        raise ValueError("Error: Unknown algorithm")
    

def searchGraph(graph, start, goal):
    # Map nodes to alphabet characters
    node_map = {i: chr(65+i) for i in range(len(graph))}
    start, goal = ord(start) - 65, ord(goal) - 65

    # We crate two 1d arrays for the visited nodes and the parents nodes
    visited = [False] * len(graph)
    parent = [-1] * len(graph)

    algo = input("please enter the algorithm you want to use (BFS, DFS, UCS): ")
    strategy = select_strategy(algo)
    parent, current = strategy.search(graph, start, goal, parent, visited)
    
    # create the path from start to goal
    path = []
    current = goal
    while current != start:
        path.append(node_map[current])
        current = parent[current]
    path.append(node_map[start])
    path.reverse()

    return ">".join(path)


if __name__ == "__main__":
    size = 6     # the size of the graph
    graph = create_graph(size)
    print(searchGraph(graph, 'A', 'E'))