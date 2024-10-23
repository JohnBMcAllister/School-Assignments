'''
COMP 3270 coding section
requires networkx, argparse
requires python 3.6+ (can get with anaconda or elsewhere, note standard python with mac is python 2)
pip install networkx
pip install argparse
'''

import argparse
import networkx as nx
import pickle
import matplotlib.pyplot as plt

from makegraph import edge_labels

parser = argparse.ArgumentParser()
parser.add_argument("--graph", help="file containing graph in pickle format for problem 1")
args = parser.parse_args()

'''
Problem 1
Implement the disjoint-set / union-find data structure with path compression
'''
class DisjointSet:
    # data structure to back the disjoint set here (you can use an array, a dict, or you could use a graph)
    
    def __init__(self):
        # initialize here
        self.forest = {}


    def makeset(self, x):
        # your code here
        if x not in self.forest:
            self.forest[x] = x

    def find(self, x):
        # your code here
        if self.forest[x] != x:
            self.forest[x] = self.find(self.forest[x])
        return self.forest[x]

    def union(self, x, y):
        # your code here
        X = self.find(x)
        Y = self.find(y)

        if X != Y:
            self.forest[Y] = X


    





'''
Problem 2
find the minimum spanning tree of G using your disjoint set data structure above
then draw the graph with the edges in the MST twice as thick as the other edges and save that to mst.png

some code I used to draw the graph
edge_labels = nx.get_edge_attributes(G, "weight") # get edge labels
pos = nx.spring_layout(G) # get position of nodes with a spring model layout
nx.draw_networkx_edges(G, pos)
nx.draw_networkx_nodes(G, pos)
nx.draw_networkx_labels(G, pos)
nx.draw_networkx_edge_labels(G, pos, edge_labels)

plt.axis("off")
plt.savefig('graph.png')
'''

def kruskal(G):
    mst = nx.Graph()
    ds = DisjointSet()

    E = sorted(G.edges(data=True), key=lambda x: x[2]["weight"])

    for v in G.nodes:
        ds.makeset(v)

    for u, v, data in E:
        U = ds.find(u)
        V = ds.find(v)

        if U != V:
            mst.add_edge(u, v, weight = data['weight'])
            ds.union(U, V)

    # Calculate positions once for both graphs
    pos = nx.spring_layout(G)
    edge_labels = nx.get_edge_attributes(G, "weight")

    # Draw the original graph with the same style
    nx.draw_networkx_edges(G, pos, width=1, edge_color='grey', alpha=0.5)
    nx.draw_networkx_nodes(G, pos)
    nx.draw_networkx_labels(G, pos)
    nx.draw_networkx_edge_labels(G, pos, edge_labels)

    # Draw the MST edges on top of the original graph
    nx.draw_networkx_edges(mst, pos, width=2, edge_color='yellow')

    # Create edge labels for the MST
    mst_edge_labels = nx.get_edge_attributes(mst, "weight")
    nx.draw_networkx_edge_labels(mst, pos, edge_labels=mst_edge_labels)

    plt.axis("off")
    plt.savefig('mst.png')
    plt.show()

# load graphs and run functions

graph = pickle.load(open(args.graph,'rb'))
kruskal(graph)


