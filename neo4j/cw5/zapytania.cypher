// 1
MATCH (m:Movie) RETURN m

// 2
MATCH (:Person{name:"Hugo Weaving"})-[:ACTED_IN]->(m:Movie) RETURN m

// 3
MATCH (:Person{name:"Hugo Weaving"})-[:ACTED_IN]->(m:Movie)<-[:DIRECTED]-(d:Person) RETURN d

// 4
MATCH (:Person{name:"Hugo Weaving"})-[:ACTED_IN]->(m:Movie)<-[:ACTED_IN]-(other:Person) RETURN other

// 5
MATCH (p:Person)-[:ACTED_IN]->(m:Movie{title:"The Matrix"}) RETURN p

// 6
MATCH (p:Person)-[r:ACTED_IN]->(m:Movie) RETURN p, count(r)

// 7
MATCH (p:Person)-[:WROTE]->(m:Movie)<-[:DIRECTED]-(p) RETURN p, m.title

// 8
MATCH (keanu:Person{name:"Keanu Reeves"})-[:ACTED_IN]->(m:Movie)<-[:ACTED_IN]-(hugo:Person{name:"Hugo Weaving"}) RETURN m

// 9
CREATE (ca:Movie{title: "Captain America: The First Avenger", released: 2011})
CREATE (ce:Person{name: "Chris Evans", born:1981})-[:ACTED_IN]->(ca)
CREATE (ha:Person{name: "Hayley Atwell", born: 1982})-[:ACTED_IN]->(ca)
CREATE (ss:Person{name: "Sebastian Stan", born: 1982})-[:ACTED_IN]->(ca)
CREATE (jj:Person{name: "Joe Johnston", born: 1950})-[:DIRECTED]->(ca)
CREATE (cm:Person{name: "Christopher Markus", born: 1970})-[:WROTE]->(ca)

MATCH r=(ca:Movie{title: "Captain America: The First Avenger"})-[]-() RETURN r
