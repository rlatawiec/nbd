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

MATCH path = (a:Airport {name:"LAX"})<-[:ORIGIN]-(:Flight)-[*0..6]-(b:Airport)
WITH path, Nodes(path) as nodes
WITH path, [n IN nodes WHERE "Flight" IN labels(n)] as flights
UNWIND flights as f
MATCH (t:Ticket)-[:ASSIGN]->(f)
WITH path, collect(t) as tickets
WITH path, reduce(sum = 0, t IN tickets | sum + t.price) AS total_price
WHERE total_price < 3000
RETURN path, total_price

// Zad 6
MATCH path = (a:Airport {name:"LAX"})<-[:ORIGIN]-(:Flight)-[*0..7]-(b:Airport{name: "DAY"})
WITH path, Nodes(path) as nodes
WITH path, [n IN nodes WHERE "Flight" IN labels(n)] as flights
UNWIND flights as f
MATCH (t:Ticket)-[:ASSIGN]->(f)
WITH path, collect(t) as tickets
WITH path, reduce(sum = 0, t IN tickets | sum + t.price) AS total_price
RETURN path, total_price
ORDER BY total_price

// Zad 7
MATCH path = (a:Airport {name:"LAX"})<-[:ORIGIN]-(:Flight)-[*0..7]-(b:Airport{name: "DAY"})
WITH path, Nodes(path) as nodes
WITH path, [n IN nodes WHERE "Flight" IN labels(n)] as flights
UNWIND flights as f
MATCH (t:Ticket)-[:ASSIGN]->(f)
WITH path, collect(t) as tickets
WITH path, reduce(sum = 0, t IN tickets | sum + t.price) AS total_price
RETURN path, total_price
ORDER BY total_price
LIMIT 1

// Zad 8
MATCH path = (a:Airport {name:"LAX"})<-[:ORIGIN]-(:Flight)-[*0..7]-(b:Airport{name: "DAY"})
WITH path, Nodes(path) as nodes
WITH path, [n IN nodes WHERE "Flight" IN labels(n)] as flights
UNWIND flights as f
MATCH (t:Ticket{class:"business"})-[:ASSIGN]->(f)
WITH path, collect(t) as tickets
WITH path, reduce(sum = 0, t IN tickets | sum + t.price) AS total_price
RETURN path, total_price
ORDER BY total_price
LIMIT 1

// Zad 10
MATCH path = (a:Airport)<-[:ORIGIN]-(:Flight)-[:DESTINATION]->(b:Airport)<-[:ORIGIN]-(:Flight)-[:DESTINATION]->(c:Airport)
WHERE a.name <> b.name AND a.name <> c.name
WITH path, Nodes(path) as nodes
WITH path, [n IN nodes WHERE "Flight" IN labels(n)] as flights
UNWIND flights as f
MATCH (t:Ticket{class:"business"})-[:ASSIGN]->(f)
WITH path, collect(t) as tickets
WITH path, reduce(sum = 0, t IN tickets | sum + t.price) AS total_price
RETURN path, total_price
ORDER BY total_price
LIMIT 1
