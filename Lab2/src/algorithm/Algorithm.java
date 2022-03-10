
package algorithm;

public abstract class Algorithm
{
    protected Problem problem;

    public Algorithm(Problem problem)
    {
        this.problem = problem;
    }

    /**
     *
     * @param problem
     * @return Solution
     */
    public Solution solve(Problem problem)
    {
        return null;
    }
}
