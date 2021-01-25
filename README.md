# Estudo em JPA - JPQL e Criteria

## Aula 01 - Relacionamentos bidirecionais
- Como mapear relacionamentos bidirecionais
- Que relacionamentos bidirecionais precisam ser "unidos" pelo atributo `mappedBy`
- O lado inverso do relacionamento é **opcional**
- Para o schema no banco vale o lado "forte" do relacionamento (que não usa `mappedBy`)

## Aula 02 - Lidando com queries N+1
- Relacionamento `ToMany` são *Lazy* por padrão
- *Lazy* significa que só serão carregados sob demanda
- Podemos reconfigurar esse comportamento pele atributo `fetch` da anotação usando a enum `FetchType.EAGER`
- Nas queries podemos inicializar um relacionamento lazy usando `join fetch`
  - para receber apenas resultados distintos podemos usar a palavra chave `distinct`
  
## Aula 03 - Funções da agregação e Group By
- JPQL possui os tipico funções de agregação do mundo SQL
  - Exemplos são **SUM**, **AVG**, **MIN**, **MAX** ou **COUNT**
- JPQL também possui a cláusula `group` by que pode ser usado em combinação com as funções de agregação
  como executar projeções e "instanciar objetos" já pelo JPQL

## Aula 04 - Camada de Persistência
- Mesmo com JPA faz sentido usar um DAO para encapsular as queries
- Em algumas bibliotecas chamam os DAO de repositórios (por exemplo Spring Data)
- O DAO deve receber o `EntityManager` como dependência (preferencialmente pelo construtor)
- `NamedQuery` é uma forma de associar a entidade com suas queries
  - `NamedQuery` tem uma vantagem pois é analisada ao criar o `EntityManager`
  
## Aula 05 - Queries dinâmicas com Criteria
- A **JPQL** deve ser usada para queries fixas que sempre buscam pelos mesmo parâmetros
- Quando a *query* é dinâmica o JPQL perde a legibilidade e o código fica mais difícil de se manter
  - Para solucionar isso foi criado uma outra API de pesquisa, a **Criteria API**
- A criteria permite definir queries apenas com chamadas de métodos e assim possui mais flexibilidade quando os parâmetros variam
- Os protagonistas da criteria são:
  - `CriteriaQuery` - a query em si, que possui os métodos principais como `select(..), from(..) e where(..)`
  - `Criteriabuilder` - uma classe auxiliar para definir filtros e projeções
  - `Root` - para definir os caminhas para atributos `(m.data)`
 
