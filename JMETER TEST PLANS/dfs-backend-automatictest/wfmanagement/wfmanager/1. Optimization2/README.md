This example shows how to solve an optimization problem where objective is calculated using an external tool. It also demonstrates re-using a workflow developed earlier as a new block.

**Blocks:** Composite, Design space exploration, Program, Text\
**Tags:** #general #basic #optimization #integration #windows #linux #added-3-0 #updated-6-14-3


# Workflow

Optimization is a process of finding the values of model parameters (design variables), which lead to the best performance of model under investigation.
Model performance is usually quantified in terms of several fitness functions constructed from measured model responses.

In this project a simple optimization task (without noise, smoothing or heavy calculations) is demonstrated.

**Workflow:** [Optimization](./Optimization.p7wf)\
**Results:** see the [Optimization](./Optimization.p7rep) report

# Results

This example includes a preconfigured report which shows the solution and collected data after you run the workflow.

**Report contents:**

* _Pareto Frontier_: Pareto frontier plot of the given problem.
* _Optimal Solutions_: a parallel coordinates plot showing each solution as a polyline.
* _Solution Data_: a table containing the data shown on the _Optimal Solutions_ plot.
* _Evaluation Data_: a table containing a history of evaluations, values of variables and all calculated function values.
