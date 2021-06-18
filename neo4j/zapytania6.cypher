// Zad 1

MATCH (t:town{name:"Darjeeling"}),
      (p:peak{name:"Sandakphu"}),
      path = shortestPath((t)-[*]->(p))
return path

// Zad 2

MATCH (t:town{name:"Darjeeling"}),
      (p:peak{name:"Sandakphu"}),
      path = shortestPath((t)-[*]->(p))
      WHERE all(r IN relationships(path) WHERE r.winter = "true")
return path

// Zad 3

MATCH (t:town{name:"Darjeeling"}),
      (p:peak{name:"Sandakphu"}),
      path = (t)-[*]->(p)
return path, length(path)
ORDER BY length(path)

// Zad 4
MATCH (airport:Airport),
      path = (airport)<-[:ORIGIN]-(f:Flight)
return airport, count(path)
ORDER BY count(path)

// Zad 5
MATCH path = (a:Airport {name:"LAX"})-[*1..10]-(b:Airport {name: 'DAY'})
WITH path, Nodes(path) as nodes
WITH path, [n IN nodes WHERE "Flight" IN labels(n)] as flights
UNWIND flights as f
MATCH (t:Ticket)-[:ASSIGN]->(f)
WITH path, t, sum(t.price) AS total_price
WHERE total_price < 3000
RETURN path, t.class, total_price
