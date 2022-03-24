package app;

import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Problem
{
    //create a reference to a city object
    private City city;

    public Problem(City city)
    {
        this.city = city;
    }

    /**
     * Main solve method, it uses an weighted graph to apply
     * Prim's algorithm so it returns the MST of the graph given as parameter
     * @input void
     * @return void
     */
    public void solve()
    {
        //graph with vertices of type Itnersection and edges of type Street
        Graph<Intersection, Street> cityGraph = new SimpleWeightedGraph<>(Street.class);

        //populating the intersections
        for (var intersection : city.getIntersections())
        {
            cityGraph.addVertex(intersection);
        }

        //populating the streets
        for (var street : city.getStreets())
        {
            cityGraph.addEdge(street.getIntersection1(), street.getIntersection2(), street);
            cityGraph.setEdgeWeight(street, street.getLength());
        }

        //using var so we don't have to type the type of the MST
        var primMST = new PrimMinimumSpanningTree<>(cityGraph).getSpanningTree();

        //printing
        System.out.printf("Cost -> %f\n", primMST.getWeight());
        System.out.println("Edges ->");
        for(Street street : primMST.getEdges())
        {
            System.out.printf("%s\n", street);
        }
    }
}