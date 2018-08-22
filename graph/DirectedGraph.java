package graph;

/**
 * https://blog.csdn.net/xxniuren/article/details/52218211
 */
public class DirectedGraph {



}

class VertexNode {
    /**
     * index of this vertex
     */
    private int id;

    /**
     * edge linking to this vertex
     */
    private EdgeNode preEdge;

}

class EdgeNode {

    /**
     * index of pre-vertex
     */
    private int vertexId;

    /**
     * vertex linked to by this edge
     */
    private VertexNode nextVertex;

}
