from abc import ABC, abstractmethod
from collections import deque

#we define the abstractmethod for the strategy design pattern
class SearchStrategy(ABC):
    @abstractmethod
    def search(self, graph, start, goal, parent, visited):
        pass # just placeholder

class BFSStrategy(SearchStrategy):
    def search(self, graph, start, goal, parent, visited):
        queue = deque([start])  #fill the queue with the start node
        visited[start] = True

        # loop while the queue is not empty
        while queue:
            current = queue.popleft()
        # the stop condition
            if current == goal: 
                break
        # check in order all the children of given node (BFS) and if the neighbor has not been visited fill the queue       
            for neighbor in range(len(graph[current])):
                if graph[current][neighbor] != -1 and not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True
                    parent[neighbor] = current

        return parent , current

class DFSStrategy(SearchStrategy):
    def search(self, graph, start, goal, parent, visited):
        stack = [start]  # fill the stack with the start node
        visited[start] = True

        # loop while the stack is not empty
        while stack:
            current = stack.pop()
            # the stop condition
            if current == goal:
                break
            # iterate over the neighbors of the current node in reverse order (DFS) and if the neighbor has not been visited push them to the stack
            for neighbor in range(len(graph[current])-1, -1, -1):
                if graph[current][neighbor] != -1 and not visited[neighbor]:
                    stack.append(neighbor)
                    visited[neighbor] = True
                    parent[neighbor] = current

        return parent, current

class UCSStrategy(SearchStrategy):
    def search(self, graph, start, goal, parent, visited):
        distances = [float('inf')] * len(graph) # in the start all distances from the start node are infinite 
        distances[start] = 0

        # loop while we didnt visited the goal node
        while not visited[goal]:
            current = -1
            # find the unvisited node with the smallest distance from the start
            for i in range(len(graph)):
                if not visited[i] and (current == -1 or distances[i] < distances[current]):
                    current = i

            # mark current node as visited
            visited[current] = True

            # check all the reachable nighbors of the current node and update their distances if necessary
            for neighbor in range(len(graph[current])):
                if graph[current][neighbor] != -1:
                    new_distance = distances[current] + graph[current][neighbor]
                    if new_distance < distances[neighbor]:
                        distances[neighbor] = new_distance
                        parent[neighbor] = current

        return parent, current
