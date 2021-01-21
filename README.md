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
 
