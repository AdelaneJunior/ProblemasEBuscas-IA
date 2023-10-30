# Problemas E Buscas - IA
  Neste projeto eu criei todas as classes como Vertex, Edges e o próprio Grafo utilizando dessas classes para fazer a estrutura funcionar corretamente, e realizar busca por pronfundidade, largura e heurisca, todas as buscas com vertice inicial e um target.  
  Esse é nosso grafo, a parte onde está escrito Vertex são as pessoas e aquela parte mais abaixo, “graph.addEdge” é onde eu digo as relações existentes entre as pessoas.     
    
  ![image](https://github.com/AdelaneJunior/ProblemasEBuscas-IA/assets/114602270/e4cbcf25-0d83-47bd-a0d0-6877dc52dc38)  
    
  No caso do nosso grafo, como pode ser visto mais acima, eu disse que ele tem peso e não é direcionado.     
  Sobre o peso basicamente, para cada conexão eu determino um valor que pra gente pode representar algo, nesse nosso caso eu pensei em dizer o quão próximas/íntimas  as pessoas são. Quanto menor o valor mais próximas elas são.  
  No caso de não ser direcionado, basicamente eu digo que a conexão é recíproca/igual de ambas as partes. Da mesma forma que vai voltar, ou seja a partir de Joao eu posso ir para Samara e voltar para Joao e o peso da conexão é o mesmo.
