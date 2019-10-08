from collections import deque

class Vertex(object):
    def __init__(self, data):
        self.data = data
        self.neighbors = []
        self.isVisited = False

    def addEdge(self, v):
        self.neighbors.append(v)

    def setVisited(self, val):
        self.isVisited = val

class Graph(object):
    def __init__(self):
        self.V = []

    def addVertex(self, v):
        self.V.append(v)

    def addEdge(self,start, end):
        self.V[start].addEdge(self.V[end])
        self.V[end].addEdge(self.V[start])

    def BFS(self):
        count = 0
        currentIdx = 0
        s = self.V[currentIdx]
        s.setVisited(True)
        queue = deque()
        queue.append(currentIdx)

        while queue:
            currentIdx = queue.popleft()
            s = self.V[currentIdx]

            for nIdx, n in enumerate(s.neighbors):
                if not n.isVisited:
                    n.setVisited(True)
                    queue.append(int(n.data) - 1)
                    count += 1

        return count

    def printEdges(self):
        for v in self.V:
            for e in v.neighbors:
                print(v.data, "->", e.data, end=", ")
            print()

if __name__ == "__main__":
    with open("F.in", "r") as file:
        testCases = int(file.readline())
        for i in range(testCases):
            cities, pilots = file.readline().strip('\n').split()
            cities = int(cities)
            pilots = int(pilots)
            g = Graph()
            for k in range(cities):
                v = Vertex(str(k+1));
                g.addVertex(v);
            for j in range(pilots):
                src, dest = file.readline().strip('\n').split()
                src = int(src) - 1
                dest = int(dest) - 1
                g.addEdge(src, dest);
            print(g.BFS());
